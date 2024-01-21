package com.baby.babycareproductsshop.order.orderdetail;

import com.baby.babycareproductsshop.order.orderdetail.model.InsDetailDTo;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface DetailMapper {

    int insDetails(InsDetailDTo dto);
}
