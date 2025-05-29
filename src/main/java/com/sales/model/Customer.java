package com.sales.model;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
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
    private String groupName;
    private String notes;
    private Double totalSales;
    private Integer salesCount;
    private LocalDate lastSaleDate;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    // getters and setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getEik() { return eik; }
    public void setEik(String eik) { this.eik = eik; }
    public String getVatNumber() { return vatNumber; }
    public void setVatNumber(String vatNumber) { this.vatNumber = vatNumber; }
    public String getAddress() { return address; }
    public void setAddress(String address) { this.address = address; }
    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public String getMol() { return mol; }
    public void setMol(String mol) { this.mol = mol; }
    public Double getCreditLimit() { return creditLimit; }
    public void setCreditLimit(Double creditLimit) { this.creditLimit = creditLimit; }
    public Double getCurrentDebt() { return currentDebt; }
    public void setCurrentDebt(Double currentDebt) { this.currentDebt = currentDebt; }
    public Integer getPaymentTerm() { return paymentTerm; }
    public void setPaymentTerm(Integer paymentTerm) { this.paymentTerm = paymentTerm; }
    public String getGroupName() { return groupName; }
    public void setGroupName(String groupName) { this.groupName = groupName; }
    public String getNotes() { return notes; }
    public void setNotes(String notes) { this.notes = notes; }
    public Double getTotalSales() { return totalSales; }
    public void setTotalSales(Double totalSales) { this.totalSales = totalSales; }
    public Integer getSalesCount() { return salesCount; }
    public void setSalesCount(Integer salesCount) { this.salesCount = salesCount; }
    public LocalDate getLastSaleDate() { return lastSaleDate; }
    public void setLastSaleDate(LocalDate lastSaleDate) { this.lastSaleDate = lastSaleDate; }
    public LocalDateTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }
    public LocalDateTime getUpdatedAt() { return updatedAt; }
    public void setUpdatedAt(LocalDateTime updatedAt) { this.updatedAt = updatedAt; }
}
