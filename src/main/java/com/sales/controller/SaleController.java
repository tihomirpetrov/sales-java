package com.sales.controller;

import com.sales.dto.SaleRequest;
import com.sales.model.Sale;
import com.sales.model.SaleItem;
import com.sales.service.SaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/sales")
public class SaleController {
    @Autowired
    private SaleService saleService;

    @PostMapping
    public ResponseEntity<?> createSale(@RequestBody SaleRequest saleRequest) {
        Sale sale = new Sale();
        sale.setDate(saleRequest.getDate());
        sale.setClient(saleRequest.getClient());
        sale.setPaymentType(saleRequest.getPaymentType());
        sale.setCurrency(saleRequest.getCurrency());

        // Задаваме общите суми
        sale.setTotalWithoutVat(saleRequest.getTotalWithoutVat());
        sale.setVat(saleRequest.getVat());
        sale.setTotalWithVat(saleRequest.getTotalWithVat());

        List<SaleItem> items = saleRequest.getItems().stream().map(itemReq -> {
            SaleItem item = new SaleItem();
            item.setProductCode(itemReq.getProductCode());
            item.setProductName(itemReq.getProductName());
            item.setQuantity(itemReq.getQuantity());
            item.setUnit(itemReq.getUnit());
            item.setPriceWithoutVat(itemReq.getPriceWithoutVat());
            item.setVatPercent(itemReq.getVatPercent());
            item.setPriceWithVat(itemReq.getPriceWithVat());
            item.setTotal(itemReq.getTotal());
            item.setSale(sale);
            return item;
        }).toList();

        sale.setItems(items);

        Sale saved = saleService.saveSale(sale);
        return ResponseEntity.ok(saved.getId());
    }

    @GetMapping("/by-date/{date}")
    public ResponseEntity<List<Sale>> getSalesByDate(
            @PathVariable @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date) {
        List<Sale> sales = saleService.getSalesByDate(date);
        return ResponseEntity.ok(sales);
    }

    @GetMapping("/search")
    public ResponseEntity<List<Sale>> searchSales(
            @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate startDate,
            @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate endDate,
            @RequestParam(required = false) String client,
            @RequestParam(required = false) String paymentType) {

        List<Sale> sales = saleService.searchSales(startDate, endDate, client, paymentType);
        return ResponseEntity.ok(sales);
    }
}