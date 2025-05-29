package com.sales.controller;

import com.sales.model.Customer;
import com.sales.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/customers")
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @GetMapping
    public List<Customer> getAll() {
        return customerService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Customer> getById(@PathVariable Long id) {
        Optional<Customer> customer = customerService.findById(id);
        return customer.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public Customer create(@RequestBody Customer customer) {
        customer.setId(null);
        return customerService.save(customer);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Customer> update(@PathVariable Long id, @RequestBody Customer customer) {
        if (!customerService.findById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        customer.setId(id);
        return ResponseEntity.ok(customerService.save(customer));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        if (!customerService.findById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        customerService.delete(id);
        return ResponseEntity.noContent().build();
    }
} 