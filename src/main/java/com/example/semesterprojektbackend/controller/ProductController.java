package com.example.semesterprojektbackend.controller;

import com.example.semesterprojektbackend.model.Login;
import com.example.semesterprojektbackend.model.Product;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {
    @GetMapping("/products")
    public Product getLogin() {
        return getDemoProduct();
    }

    @GetMapping("/products/{itemNumber}")
    public Product getProductPath(@PathVariable int itemNumber) {
        return getDemoProduct();
    }

    private Product getDemoProduct() {
        return new Product(123,"T-shirt","L",1,2,true,99.5);
    }
}
