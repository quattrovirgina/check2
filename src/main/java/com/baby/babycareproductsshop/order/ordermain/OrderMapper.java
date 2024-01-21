package com.baby.babycareproductsshop.order.ordermain;

import com.baby.babycareproductsshop.order.ordermain.model.AfterOrderDto;
import com.baby.babycareproductsshop.order.ordermain.model.AfterOrderVo;
import com.baby.babycareproductsshop.order.ordermain.model.InsorderDto;
import com.baby.babycareproductsshop.order.ordermain.model.UpdateOrderDto;
import org.apache.ibatis.annotations.Mapper;

// ordermapper
// 사용 쿼리: insOrder, updateOrder, getAfterOrder

@Mapper
public interface OrderMapper {

    int insOrder(InsorderDto dto);
    // product에서 고른 데이터들 일부를 삽입

    int updateOrder(UpdateOrderDto dto);
    // 이름, 이메일, 결제수단을 입력

    AfterOrderVo getAfterOrder(AfterOrderDto dto);

}
