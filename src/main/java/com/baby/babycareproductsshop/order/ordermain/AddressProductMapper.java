package com.baby.babycareproductsshop.order.ordermain;

import com.baby.babycareproductsshop.order.ordermain.model.AddressVo;
import com.baby.babycareproductsshop.order.ordermain.model.PurchaseProductInfoVo;
import com.baby.babycareproductsshop.order.ordermain.model.SeeOrderDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface AddressProductMapper {

    List<AddressVo> seeAddressDetails(SeeOrderDto dto);

    List<PurchaseProductInfoVo> seeProducts(SeeOrderDto dto);
}
