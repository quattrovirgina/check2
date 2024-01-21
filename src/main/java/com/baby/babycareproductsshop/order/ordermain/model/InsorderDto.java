package com.baby.babycareproductsshop.order.ordermain.model;

// 일부 product 데이터들을 삽입

// 사용 변수: iuser, iaddress, iproduct

import com.baby.babycareproductsshop.product.model.ProductMainSelDto;
import com.baby.babycareproductsshop.product.model.ProductSelDto;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.validation.Valid;
import lombok.Data;

import java.util.List;

@Data
public class InsorderDto {
    @JsonIgnore
    private int iorder;

    private int iuser;

    private int iaddress;

    private int iproduct;

}
