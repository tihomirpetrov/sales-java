package com.sales.service;

import com.sales.model.Sale;
import com.sales.repository.SaleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

@Service
public class SaleService {
    @Autowired
    private SaleRepository saleRepository;

    @Transactional
    public Sale saveSale(Sale sale) {
        // Може да добавите бизнес логика тук
        return saleRepository.save(sale);
    }

    public List<Sale> getSalesByDate(LocalDate date) {
        return saleRepository.findByDate(date);
    }

    public List<Sale> searchSales(LocalDate startDate, LocalDate endDate, String client, String paymentType) {
        return saleRepository.searchSales(startDate, endDate, client, paymentType);
    }
}
