package com.sales.controller;

import com.sales.dto.SaleRequest;
import com.sales.model.Sale;
import com.sales.model.SaleItem;
import com.sales.service.SaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}