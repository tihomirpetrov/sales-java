package com.sales.dto;

import lombok.Data;

@Data
public class CreateProductDto {
    private String code;
    private String barcode;
    private String name;
    private String unit;
    private Double priceWithoutVat;
    private Double priceWithVat;
    private Integer vatPercent;
    private Integer quantity;
    private String description;
    private String category;
    private String supplier;
    private Integer minQuantity;
    private Integer maxQuantity;
    private String location;
}