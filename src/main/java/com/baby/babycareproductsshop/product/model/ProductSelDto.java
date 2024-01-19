package com.baby.babycareproductsshop.product.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Schema(title = "상품 상세 정보 필요한 데이터")
public class ProductSelDto {

    @Schema(title = "상품 PK")
    private int iproduct;


}
