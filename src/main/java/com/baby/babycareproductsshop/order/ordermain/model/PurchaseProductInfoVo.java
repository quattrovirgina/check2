package com.baby.babycareproductsshop.order.ordermain.model;

import lombok.Data;

@Data
public class PurchaseProductInfoVo {
    // @JsonIgnore: 직렬화 시 해당필드를 포함시키고 싶지 않을때 선언하는 어노테이션
    private int iproduct;

    private String repPic;

    private String productTotalPrice;

    private String productCnt;

    private String productNm;


}
