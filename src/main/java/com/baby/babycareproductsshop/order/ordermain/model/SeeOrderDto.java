package com.baby.babycareproductsshop.order.ordermain.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

// 주문결제 페이지 조회

@Data
public class SeeOrderDto {
    @JsonIgnore
    private int iuser;

    private int iorder;
}
