package com.baby.babycareproductsshop.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;


@Getter
@RequiredArgsConstructor
public enum AuthErrorCode implements ErrorCode { //enum : Const 대체 할 수 있음.
    // 리뷰
    UPLOAD_PIC_OVER_REVIEW(HttpStatus.NOT_FOUND, "사진은 최대 5장까지만 넣을 수 있습니다."),
    DEL_REVIEW_NOT_FAIL(HttpStatus.NOT_FOUND, "리뷰가 삭제되지 않았습니다."),
    REVIEW_NOT_PRODUCT_SCORE_OR_CONTENTS_PIC_OVER_REVIEW(HttpStatus.BAD_REQUEST, "사용하신 제품의 별점과 사용 후기를 알려주세요!!"),
    UPLOAD_REVIEW_REGISTRATION_REVIEW(HttpStatus.OK, "리뷰가 정상적으로 등록되었습니다."),

    // 게시판 / 댓글
    GLOBAL_EXCEPTION(HttpStatus.BAD_REQUEST, "요청 사항을 처리할 수 없습니다."),
    PICS_CREATE_FAIL(HttpStatus.INTERNAL_SERVER_ERROR, "사진 등록에 실패했습니다."),
    USER_MODIFY_FAIL(HttpStatus.INTERNAL_SERVER_ERROR, "작성자 외 수정 및 삭제가 불가능합니다."),

    POST_NOT_FOUND(HttpStatus.NOT_FOUND, "게시글이 존재하지 않습니다."),
    POST_REGISTER_FAIL(HttpStatus.INTERNAL_SERVER_ERROR, "게시글 등록 및 수정이 불가능합니다."),
    POST_DELETE_FAIL(HttpStatus.INTERNAL_SERVER_ERROR, "게시글을 삭제할 수 없습니다."),
    COMMENT_NOT_FOUND(HttpStatus.NOT_FOUND, "댓글이 존재하지 않습니다."),
    COMMENT_REGISTER_FAIL(HttpStatus.INTERNAL_SERVER_ERROR, "댓글 등록 및 수정이 불가능합니다."),
    COMMENT_DELETE_FAIL(HttpStatus.INTERNAL_SERVER_ERROR, "댓글 수정이 불가능합니다."),

    // 회원
    INVALID_ADDRESS_SIZE(HttpStatus.BAD_REQUEST, "주소는 최소 1개 최대 3개 까지 입력할 수 있습니다."),
    DUPLICATED_UID(HttpStatus.BAD_REQUEST, "이미 사용중인 아이디입니다."),
    PASSWORD_NOT_MATCHED(HttpStatus.NOT_FOUND, "비밀번호를 확인해주세요."),
    LOGIN_FAIL(HttpStatus.NOT_FOUND, "아이디와 비밀번호를 확인해주세요."),
    NEED_SIGNIN(HttpStatus.UNAUTHORIZED, "로그인이 필요합니다."),
    NOT_FOUND_REFRESH_TOKEN(HttpStatus.NOT_FOUND, "refresh-token 이 없습니다."),

    // 오더
    INVALID_ORDER(HttpStatus.BAD_REQUEST, "해당 주문을 처리할수 없습니다. 죄송합니다"),
    COUNT_ZERO(HttpStatus.INTERNAL_SERVER_ERROR, "재고가 다 떨어진 제품입니다"),
    LESS_MONEY(HttpStatus.BAD_REQUEST, "금액부족으로 결제할수 없습니다");

    private final HttpStatus httpStatus;
    private final String message;
}
