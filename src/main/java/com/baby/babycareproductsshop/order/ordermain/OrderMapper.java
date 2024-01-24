package com.baby.babycareproductsshop.order.ordermain;

import com.baby.babycareproductsshop.order.ordermain.model.*;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

// ordermapper
// 사용 쿼리: insOrder, updateOrder, getAfterOrder

@Mapper
public interface OrderMapper {

    int insOrder(InsorderDto dto);
    // product에서 고른 데이터들 일부를 삽입

    int updateOrder(UpdateOrderDto dto);
    // 이름, 이메일, 결제수단을 입력


    // 결제페이지 조회



    /* AfterOrderVo getAfterOrder(AfterOrderDto dto);
    // 주문완료

    int cancelOrder(CancelOrderDto dto);
    // 주문취소

    int RefundOrder(DeleteOrderDto dto);
    // 환불

     */

}
