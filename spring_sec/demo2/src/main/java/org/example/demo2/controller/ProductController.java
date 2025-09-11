package org.example.demo2.controller;

import jakarta.persistence.Id;
import org.example.demo2.model.Product;
import org.example.demo2.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/p")
public class ProductController {
    @Autowired
    private ProductRepository productRepository;

    @GetMapping("/products/{id}")
    public Product getProduct(@PathVariable int id) {
        return productRepository.findById(id);
    }

    @PostMapping("products")
    public Product addProduct(@RequestBody Product product) {
        return productRepository.save(product);
    }
}
