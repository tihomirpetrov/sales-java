package com.sales.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.util.List;

@Entity
@Table(name = "sales")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Sale {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private OffsetDateTime date;

    @Column(nullable = false, columnDefinition = "text")
    private String client;

    @Column(nullable = false)
    private String paymentType; // CASH, CARD, BANK

    @Column(nullable = false)
    private String currency;

    @Column(nullable = false)
    private BigDecimal totalWithoutVat;

    @Column(nullable = false)
    private BigDecimal vat;

    @Column(nullable = false)
    private BigDecimal totalWithVat;

    @JsonManagedReference
    @OneToMany(mappedBy = "sale", cascade = CascadeType.ALL)
    private List<SaleItem> items;
}
