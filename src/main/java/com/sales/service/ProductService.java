package com.sales.service;

import com.sales.dto.CreateProductDto;
import com.sales.model.Product;
import com.sales.repository.ProductRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {
    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Transactional
    public Product createProduct(CreateProductDto dto) {
        Product product = new Product();
        product.setCode(dto.getCode());
        product.setBarcode(dto.getBarcode());
        product.setName(dto.getName());
        product.setUnit(dto.getUnit());
        product.setPriceWithoutVat(dto.getPriceWithoutVat());
        product.setPriceWithVat(dto.getPriceWithVat());
        product.setVatPercent(dto.getVatPercent());
        product.setQuantity(dto.getQuantity());
        product.setDescription(dto.getDescription());
        product.setCategory(dto.getCategory());
        product.setSupplier(dto.getSupplier());
        product.setMinQuantity(dto.getMinQuantity());
        product.setMaxQuantity(dto.getMaxQuantity());
        product.setLocation(dto.getLocation());
        return productRepository.save(product);
    }

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public List<Product> getNewProducts() {
        // Може да добавите логика за нови продукти
        return productRepository.findAll();
    }

    @Transactional
    public Product updateProduct(Long id, CreateProductDto dto) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found"));
        product.setCode(dto.getCode());
        product.setBarcode(dto.getBarcode());
        product.setName(dto.getName());
        product.setUnit(dto.getUnit());
        product.setPriceWithoutVat(dto.getPriceWithoutVat());
        product.setPriceWithVat(dto.getPriceWithVat());
        product.setVatPercent(dto.getVatPercent());
        product.setQuantity(dto.getQuantity());
        product.setDescription(dto.getDescription());
        product.setCategory(dto.getCategory());
        product.setSupplier(dto.getSupplier());
        product.setMinQuantity(dto.getMinQuantity());
        product.setMaxQuantity(dto.getMaxQuantity());
        product.setLocation(dto.getLocation());
        return productRepository.save(product);
    }

    @Transactional
    public List<Product> bulkCreate(List<CreateProductDto> dtos) {
        List<Product> saved = new ArrayList<>();
        for (CreateProductDto dto : dtos) {
            saved.add(createProduct(dto));
        }
        return saved;
    }
}