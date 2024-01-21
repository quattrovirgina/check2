package com.baby.babycareproductsshop.order.orderdetail.model;

// 주문상세 테이블 입력
// 사용데이터: iorder, iproduct, process_statem, created_at

import lombok.Data;

@Data
public class InsDetailDTo {
    private int iorder;

    private int iproduct;

    private int process_state;
}
