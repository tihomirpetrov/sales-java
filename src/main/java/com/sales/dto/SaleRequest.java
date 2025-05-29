package com.sales.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SaleRequest {
    private OffsetDateTime date;
    private String client;
    private String paymentType;
    private String currency;
    private BigDecimal totalWithoutVat;
    private BigDecimal vat;
    private BigDecimal totalWithVat;
    private List<SaleItemRequest> items;
}