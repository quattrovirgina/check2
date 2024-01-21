package com.baby.babycareproductsshop.order.ordermain;

import com.baby.babycareproductsshop.common.ResVo;
import com.baby.babycareproductsshop.order.orderdetail.DetailMapper;
import com.baby.babycareproductsshop.order.orderdetail.model.InsDetailDTo;
import com.baby.babycareproductsshop.order.ordermain.model.AfterOrderDto;
import com.baby.babycareproductsshop.order.ordermain.model.AfterOrderVo;
import com.baby.babycareproductsshop.order.ordermain.model.InsorderDto;
import com.baby.babycareproductsshop.order.ordermain.model.UpdateOrderDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/order")

public class OrderController {
    private final OrderService service;

    // 주문 결제페이지
    @PostMapping("/buyorder")
    public ResVo insertorder(@RequestBody InsorderDto dto) {
        return service.OrderIns(dto);
    }

    @PutMapping("/buyorder/edit")
    public ResVo updateorder(@RequestBody UpdateOrderDto dto) {
        return service.orderUpadte(dto);
    }

    // 주문완료페이지
    @PostMapping("/getorder/buydetails")
    public ResVo insertdetails(@RequestBody InsDetailDTo dto) {

        return service.insDetails(dto);
    }

    @GetMapping("/getorder")
    public AfterOrderVo afterordered(@RequestBody AfterOrderDto dto) {
        return service.ordercomplete(dto);
    }



}
