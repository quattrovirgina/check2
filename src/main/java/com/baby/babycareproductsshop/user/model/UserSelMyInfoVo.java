package com.baby.babycareproductsshop.user.model;

// import com.baby.babycareproductsshop.product.model.ProductSelWishListVo;
import lombok.Data;

import java.util.List;

@Data
public class UserSelMyInfoVo {
    private String nm;
    private int beforeDeposit;
    private int preparation;
    private int shipping;
    private int completed;
    // private List<ProductSelWishListVo> myWishList;
}
