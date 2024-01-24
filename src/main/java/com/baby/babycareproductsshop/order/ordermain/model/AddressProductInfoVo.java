package com.baby.babycareproductsshop.order.ordermain.model;

import lombok.Data;

import java.util.List;

@Data
public class AddressProductInfoVo {
    private List<AddressVo> addressDetails;
    private List<PurchaseProductInfoVo> products;
}
