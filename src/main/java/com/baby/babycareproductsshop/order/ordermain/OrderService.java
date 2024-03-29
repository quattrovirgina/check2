package com.baby.babycareproductsshop.order.ordermain;

import com.baby.babycareproductsshop.common.Const;
import com.baby.babycareproductsshop.common.ResVo;
import com.baby.babycareproductsshop.order.orderdetail.DetailMapper;
import com.baby.babycareproductsshop.order.ordermain.model.*;
import com.baby.babycareproductsshop.security.AuthenticationFacade;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Service
public class OrderService {
    private final OrderMapper orderMapper;
    private final DetailMapper Dmapper;
    private final AuthenticationFacade authenticationFacade;
    private final AddressProductMapper addressProductmapper;

    public ResVo orderIns(InsorderDto dto) {
        int insorderresult = orderMapper.insOrder(dto);

        if(insorderresult == 0) {
            return new ResVo(Const.FAIL);
        }
        return new ResVo(Const.SUCCESS);
    }

    public ResVo orderUpadte(UpdateOrderDto dto) {
        int updateresult = orderMapper.updateOrder(dto);

        if(updateresult == 0) {
            return new ResVo(Const.FAIL);
        }
        return new ResVo(Const.SUCCESS);

    }

    public AddressProductInfoVo orderSee(SeeOrderDto dto) {
        dto.setIuser(authenticationFacade.getLoginUserPk());
        log.info("dto result is: {}", dto);

        List<AddressVo> addresses = addressProductmapper.seeAddressDetails(dto);
        List<PurchaseProductInfoVo> products = addressProductmapper.seeProducts(dto);

        AddressProductInfoVo vo = new AddressProductInfoVo();

        vo.setAddressDetails(addresses);
        vo.setProducts(products);

        return vo;
    }

    // 주문 결제 페이지
    /* public ResVo insDetails(InsDetailDTo dto) {

        int detailresult = Dmapper.insDetails(dto);

        if(detailresult == 0) {
            return new ResVo(Const.FAIL);
        }
        return new ResVo(Const.SUCCESS);
    }

    public AfterOrderVo ordercomplete(AfterOrderDto dto) {
        try {
            AfterOrderVo li = orderMapper.getAfterOrder(dto);

            if(Utils.isNotNull(li)) {
                return li;
            } else {
                throw new RestApiException(AuthErrorCode.POST_NOT_FOUND);
            }
        } catch(Exception e) {
            throw new RestApiException(AuthErrorCode.GLOBAL_EXCEPTION);
        }
    }

    // 주문내역 조회 페이지

    // 주문취소 페이지(4 = 취소, 5 = 환불)
    public ResVo ordercancel(CancelOrderDto dto) {
        return null;
    }
     */

}
