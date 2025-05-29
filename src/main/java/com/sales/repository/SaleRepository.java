package com.sales.repository;

import com.sales.model.Sale;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface SaleRepository extends JpaRepository<Sale, Long> {
    List<Sale> findByDate(LocalDate date);

    @Query(value = "SELECT * FROM sales s WHERE " +
           "(:startDate IS NULL OR s.date >= :startDate) AND " +
           "(:endDate IS NULL OR s.date <= :endDate) AND " +
           "(:client IS NULL OR LOWER(CAST(s.client AS text)) LIKE LOWER(CONCAT('%', :client, '%'))) AND " +
           "(:paymentType IS NULL OR s.payment_type = :paymentType)", nativeQuery = true)
    List<Sale> searchSales(
            @Param("startDate") LocalDate startDate,
            @Param("endDate") LocalDate endDate,
            @Param("client") String client,
            @Param("paymentType") String paymentType
    );
}
