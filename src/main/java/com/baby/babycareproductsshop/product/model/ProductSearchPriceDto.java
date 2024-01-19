package com.baby.babycareproductsshop.product.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.List;

@Data
@Schema(title = "검색 시 필요한 데이터")
public class ProductSearchPriceDto {
    @Schema(title = "검색어")
    private String keyword;

    @Schema(title = "최솟값")
    private int minPrice;

    @Schema(title = "최댓값")
    private int maxPrice;

    @Schema(title = "카테고리 PK")
    private List<Integer> category;

    @Schema(title = "정렬 값")
    private int sortBy ;


    @JsonIgnore
    private int startIdx;
    @JsonIgnore
    private int rowCount = 5;

    @Schema(title = "페이징처리")
    public void setPage(int page) {
        this.startIdx = (page - 1) * rowCount;
    }



}
