package com.sales.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String code;

    @Column
    private String barcode;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String unit;

    @Column(nullable = false)
    private Double priceWithoutVat;

    @Column(nullable = false)
    private Double priceWithVat;

    @Column(nullable = false)
    private Integer vatPercent;

    @Column(nullable = false)
    private Integer quantity;

    @Column(length = 1000)
    private String description;

    @Column
    private String category;

    @Column
    private String supplier;

    @Column
    private Integer minQuantity;

    @Column
    private Integer maxQuantity;

    @Column
    private String location;
}