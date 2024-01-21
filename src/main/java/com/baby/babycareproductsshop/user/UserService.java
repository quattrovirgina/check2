package com.baby.babycareproductsshop.user;

import com.baby.babycareproductsshop.common.AppProperties;
import com.baby.babycareproductsshop.common.Const;
import com.baby.babycareproductsshop.common.MyCookieUtils;
import com.baby.babycareproductsshop.common.ResVo;
import com.baby.babycareproductsshop.exception.AuthErrorCode;
import com.baby.babycareproductsshop.exception.CommonErrorCode;
import com.baby.babycareproductsshop.exception.RestApiException;
//import com.baby.babycareproductsshop.product.ProductWishListMapper;
//import com.baby.babycareproductsshop.product.model.ProductSelWishListVo;
import com.baby.babycareproductsshop.security.AuthenticationFacade;
import com.baby.babycareproductsshop.security.JwtTokenProvider;
import com.baby.babycareproductsshop.security.MyPrincipal;
import com.baby.babycareproductsshop.user.model.*;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserService {
    private final UserMapper userMapper;
    // private final ProductWishListMapper wishListMapper;
    private final UserAddressMapper addressMapper;
    private final UserChildMapper childMapper;
    private final PasswordEncoder passwordEncoder;
    private final JwtTokenProvider jwtTokenProvider;
    private final AppProperties appProperties;
    private final MyCookieUtils myCookieUtils;
    private final AuthenticationFacade authenticationFacade;

    //회원가입
    public ResVo postSignUp(UserSignUpDto dto) {
        String hashedUpw = passwordEncoder.encode(dto.getUpw());
        dto.setUpw(hashedUpw);
        int insUserResult = userMapper.insUser(dto);

        for (UserChildDto child : dto.getChildren()) {
            child.setIuser(dto.getIuser());
            int insChildResult = childMapper.insUserChildren(child);
        }

        UserInsAddressDto addressDto = new UserInsAddressDto(dto);
        int insAddressResult = addressMapper.insUserAddress(addressDto);

        return new ResVo(dto.getIuser());
    }

    //회원가입 약관 조회
    public List<UserClauseVo> getClause() {
        return userMapper.selClause();
    }

    //아이디 중복 체크
    public ResVo postCheckUid(UserCheckUidDto dto) {
        UserSignInProcDto result = userMapper.selSignInInfoByUid(dto.getUid());
        if (result != null) {
            throw new RestApiException(AuthErrorCode.DUPLICATED_UID);
        }
        return new ResVo(Const.SUCCESS);
    }

    //로그인
    public UserSignInVo postSignIn(HttpServletResponse res, UserSignInDto dto) {
        UserSignInProcDto vo = userMapper.selSignInInfoByUid(dto.getUid());
        if (vo == null) {
            return UserSignInVo.builder()
                    .result(Const.UID_NOT_EXIST)
                    .build();
        }
        if (!passwordEncoder.matches(dto.getUpw(), vo.getUpw())) {
            return UserSignInVo.builder()
                    .result(Const.UPW_NOT_MATCHED)
                    .build();
        }
        MyPrincipal myPrincipal = new MyPrincipal(vo.getIuser());
        String at = jwtTokenProvider.generateAccessToken(myPrincipal);
        String rt = jwtTokenProvider.generateRefreshToken(myPrincipal);

        int rtCookieMaxAge = appProperties.getJwt().getRefreshCookieMaxAge();
        myCookieUtils.deleteCookie(res, "refreshToken");
        myCookieUtils.setCookie(res, "refreshToken", rt, rtCookieMaxAge);

        return UserSignInVo.builder()
                .result(Const.SIGN_IN_SUCCESS)
                .accessToken(at)
                .nm(vo.getNm())
                .build();
    }

    //마이 페이지 회원 정보 조회
    public UserSelMyInfoVo getMyInfo() {
        int iuser = authenticationFacade.getLoginUserPk();
        UserSelMyInfoVo myInfoVo = userMapper.selMyInfo(iuser);
        // List<ProductSelWishListVo> wishList = wishListMapper.selWishList(iuser);
        // myInfoVo.setMyWishList(wishList);
        return myInfoVo;
    }

    //회원 정보 수정 전 비밀번호 체크
    public UserSelToModifyVo postCheckUpw(UserCheckUpwDto dto) {
        int iuser = authenticationFacade.getLoginUserPk();
        UserSelToModifyVo vo = userMapper.selUserInfoByIuser(iuser);
        String hashedUpw = vo.getUpw();
        if (!passwordEncoder.matches(dto.getUpw(), hashedUpw)) {
            throw new RestApiException(AuthErrorCode.PASSWORD_NOT_MATCHED);
        }
        vo.setChildren(childMapper.selUserChildren(iuser));
        vo.setResult(Const.SIGN_IN_SUCCESS);
        return vo;
    }

    //유저 정보 수정
    public ResVo putUserInfo(UserUpdDto dto) {
        dto.setIuser(authenticationFacade.getLoginUserPk());
        if (dto.getUpw() != null) {
            String hashedUpw = passwordEncoder.encode(dto.getUpw());
            dto.setUpw(hashedUpw);
        }
        int result = userMapper.updUser(dto);
        int delChildResult = childMapper.delUserChildren(dto.getIuser());
        for (UserChildDto child : dto.getChildren()) {
            child.setIuser(dto.getIuser());
            int insChildResult = childMapper.insUserChildren(child);
        }
        return new ResVo(Const.SUCCESS);
    }

    //로그 아웃
    public ResVo signout(HttpServletResponse res) {
        myCookieUtils.deleteCookie(res, "refreshToken");
        return new ResVo(Const.SUCCESS);
    }

    //회원 탈퇴
    public ResVo unregister() {
        int iuser = authenticationFacade.getLoginUserPk();
        int result = userMapper.delUser(iuser);
        return new ResVo(Const.SUCCESS);
    }

    //유저 주소 정보 입력
    public ResVo postUserAddress(UserInsAddressDto dto) {
        dto.setIuser(authenticationFacade.getLoginUserPk());
        List<UserSelAddressVo> vo = addressMapper.selUserAddress(dto.getIuser());
        if (vo.size() == 3) {
            throw new RestApiException(AuthErrorCode.INVALID_ADDRESS_SIZE);
        }
        int result = addressMapper.insUserAddress(dto);
        return new ResVo(Const.SUCCESS);
    }

    //유저 주소 정보 조회
    public List<UserSelAddressVo> getUserAddress() {
        int iuser = authenticationFacade.getLoginUserPk();
        return addressMapper.selUserAddress(iuser);
    }

    //유저 주소 정보 수정
    public ResVo putUserAddress(UserUpdAddressDto dto) {
        dto.setIuser(authenticationFacade.getLoginUserPk());
        int result = addressMapper.updUserAddress(dto);
        return new ResVo(Const.SUCCESS);
    }
    //유저 주소 정보 삭제
    public ResVo delUserAddress(UserDelAddressDto dto) {
        dto.setIuser(authenticationFacade.getLoginUserPk());
        List<UserSelAddressVo> vo = addressMapper.selUserAddress(dto.getIuser());
        if (vo.size() == 1) {
            throw new RestApiException(AuthErrorCode.INVALID_ADDRESS_SIZE);
        }
        int result = addressMapper.delUserAddress(dto);
        return new ResVo(Const.SUCCESS);
    }
}

