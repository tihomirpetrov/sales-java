package com.sales.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SaleItemRequest {
    private String productCode;
    private String productName;
    private BigDecimal quantity;
    private String unit;
    private BigDecimal priceWithoutVat;
    private BigDecimal vatPercent;
    private BigDecimal priceWithVat;
    private BigDecimal total;
}
