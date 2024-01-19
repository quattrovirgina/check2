package com.baby.babycareproductsshop.product.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@Schema(title = "상품 상세 정보 조회시 응답할 전체 리스트")
public class ProductSelVo {
    @JsonIgnore
    @Schema(title = "상품 PK")
    private int iproduct;

    @JsonIgnore
    @Schema(title = "리뷰 PK")
    private int ireview;

    @Schema(title = "상품 사진")
    private List<String> productPics = new ArrayList<>();

    @Schema(title = "상품 이름")
    private String productNm;

    @Schema(title = "상품 가격")
    private int price;

    @Schema(title = "상품 수량")
    private int remainedProduct;

    @Schema(title = "상품 상세 정보")
    private String productDetails;

    @Schema(title = "작성 시간")
    private String createdAt;

    @Schema(title = "작성자")
    private String Nm;

    @Schema(title = "리뷰 사진")
    private List<String> reviewPic = new ArrayList<>();

    @Schema(title = "리뷰 내용")
    private String contents;

    @Schema(title = "별점")
    private int productScore;

    @Schema(title = "리뷰 갯수")
    private int countIreview;

    @Schema(title = "평균 별점")
    private double avgProductScore;
}
