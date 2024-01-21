package com.baby.babycareproductsshop.order.ordermain.model;

import lombok.Data;

import java.util.List;

// 주문한 상품목록 조회
@Data
public class AfterOrderVo {
    private int idetails;

    private String createdAt;

    private List<Integer> iproduct;

    private String productNm;

    private int price;

    private int totalprice;

    private String address;
}
