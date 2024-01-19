package com.baby.babycareproductsshop.user.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class UserSelAddressVo {
    private int iaddress;
    private String zipCode;
    private String address;
    private String addressDetail;
}
