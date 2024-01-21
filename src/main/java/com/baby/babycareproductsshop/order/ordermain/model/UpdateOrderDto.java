package com.baby.babycareproductsshop.order.ordermain.model;

// 이름(addressnm), 전번(phonenumber), 이메일(email), 결제수단(ipayment_option)
import lombok.Data;

@Data
public class UpdateOrderDto {

    private String addressnm;

    private String phonenumber;

    private String email;

    private int ipayment_option;
}