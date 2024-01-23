package com.baby.babycareproductsshop.order.ordermain;

import com.baby.babycareproductsshop.common.ResVo;
import com.baby.babycareproductsshop.order.ordermain.model.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/order")

public class OrderController {
    private final OrderService service;

    // 주문 결제페이지
    @PostMapping("/buyorder")
    public ResVo insertorder(@RequestBody InsorderDto dto) {
        return service.orderIns(dto);
    }

    @PutMapping("/buyorder/edit")
    public ResVo updateorder(@RequestBody UpdateOrderDto dto) {
        return service.orderUpadte(dto);
    }

//    @GetMapping("/buyorder/see")
//    public List<seeOrderVo> seeitorder(@RequestBody seeOrderDto dto) {
//        return service.orderSee(dto);
//    }
    // 리턴타입은 AddressProductInfoVo,

    @GetMapping("/buyorder")
    public AddressProductInfoVo seeitorder(SeeOrderDto dto) {

        return service.orderSee(dto);

    }





    // 주문완료페이지
   /* @PostMapping("/getorder/buydetails")
    public ResVo insertdetails(@RequestBody InsDetailDTo dto) {

        return service.insDetails(dto);
    }

    @GetMapping("/getorder")
    public AfterOrderVo afterordered(@RequestBody AfterOrderDto dto) {
        return service.ordercomplete(dto);
    }

    // 주문내역 페이지
    // 취소내역 페이지
    // 주문취소 및 주문환불 페이지
    @PatchMapping("/cancelorder")
    public ResVo cancelordered(@RequestBody CancelOrderDto dto) {
        return null;
    }
    // 주문환불 혹은 주문취소한거 삭제하는 페이지
    @DeleteMapping("/delorder")
    public ResVo deleteordered(@RequestBody DeleteOrderDto dto) {
        return null;
    } */


}
