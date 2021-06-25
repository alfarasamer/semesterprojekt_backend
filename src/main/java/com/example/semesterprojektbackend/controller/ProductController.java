package com.example.semesterprojektbackend.controller;

import com.example.semesterprojektbackend.model.Product;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
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

    @PostMapping("/products")
    public Product postProduct() {
        return postDemoProduct();
    }

    @PostMapping("/registration/{itemNumber}")
    public Product postProductPath(@PathVariable int itemNumber) {
        return postDemoProduct();
    }

    private Product postDemoProduct() {
        return new Product(123,"Shirt", "XL", 12, true, 55.33);
    }


}
