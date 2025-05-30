package com.sales.model;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String eik;
    private String vatNumber;
    private String address;
    private String phone;
    private String email;
    private String mol;
    private Double creditLimit;
    private Double currentDebt;
    private Integer paymentTerm;
    @Enumerated(EnumType.STRING)
    @Column(name = "customer_group")
    private Group group;
    private String notes;
    private Double totalSales;
    private Integer salesCount;
    private LocalDate lastSaleDate;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public enum Group {
        VIP, REGULAR, NEW
    }
}
