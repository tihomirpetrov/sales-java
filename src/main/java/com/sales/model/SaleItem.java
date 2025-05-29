package com.sales.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Entity
@Table(name = "sale_items")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SaleItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String productCode;
    private String productName;
    private BigDecimal quantity;
    private String unit;
    private BigDecimal priceWithoutVat;
    private BigDecimal vatPercent;
    private BigDecimal priceWithVat;
    private BigDecimal total;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "sale_id")
    private Sale sale;
}