package com.sales.controller;

import com.sales.dto.CreateProductDto;
import com.sales.model.Product;
import com.sales.service.ProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
@CrossOrigin(origins = "http://localhost:4200")
public class ProductController {
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping
    public ResponseEntity<Product> createProduct(@RequestBody CreateProductDto dto) {
        Product product = productService.createProduct(dto);
        return ResponseEntity.ok(product);
    }

    @GetMapping
    public ResponseEntity<List<Product>> getAllProducts() {
        List<Product> products = productService.getAllProducts();
        return ResponseEntity.ok(products);
    }

    @GetMapping("/new")
    public ResponseEntity<List<Product>> getNewProducts() {
        List<Product> products = productService.getNewProducts();
        return ResponseEntity.ok(products);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Product> updateProduct(@PathVariable Long id, @RequestBody CreateProductDto dto) {
        Product updated = productService.updateProduct(id, dto);
        return ResponseEntity.ok(updated);
    }

    @PostMapping("/bulk")
    public List<Product> bulkCreate(@RequestBody List<CreateProductDto> products) {
        return productService.bulkCreate(products);
    }
}