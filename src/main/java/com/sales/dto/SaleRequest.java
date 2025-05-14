package com.sales.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SaleRequest {
    private Date date;
    private String client;
    private String paymentType;
    private String currency;
    private BigDecimal totalWithoutVat;
    private BigDecimal vat;
    private BigDecimal totalWithVat;
    private List<SaleItemRequest> items;
}