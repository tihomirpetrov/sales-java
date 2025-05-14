package com.sales.service;

import com.sales.model.Sale;
import com.sales.repository.SaleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SaleService {
    @Autowired
    private SaleRepository saleRepository;

    public Sale saveSale(Sale sale) {
        // Може да добавите бизнес логика тук
        return saleRepository.save(sale);
    }
}
