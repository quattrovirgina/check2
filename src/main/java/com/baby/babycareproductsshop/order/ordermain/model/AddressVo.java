package com.baby.babycareproductsshop.order.ordermain.model;

import lombok.Data;

import java.util.List;

@Data
public class AddressVo {

    private int iaddress;

    private String zipCode;

    private String address;

    private List<String> addressDetail;
}