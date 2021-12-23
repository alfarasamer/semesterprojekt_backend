package com.example.semesterprojektbackend.controller;

import com.example.semesterprojektbackend.model.Product;
import com.example.semesterprojektbackend.repositories.ProductRepo;
import com.example.semesterprojektbackend.service.ProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
public class ProductController {

    private final ProductRepo productRepo;
    private final ProductService productService;

    public ProductController(ProductRepo productRepo, ProductService productService) {
        this.productRepo = productRepo;
        this.productService = productService;
    }

    @GetMapping("/products")
    public List<Product> getProducts() {
        return productService.findAll();
    }

    @GetMapping("/products/{itemNumber}")
    public Optional<Product> getProductPath(@PathVariable Long itemNumber) {
        return productService.findById(itemNumber);
    }

    @PostMapping("/products")
    public String addNew(@Validated @RequestBody Product product) {
        productService.save(product);
        return "redirect:/products";
    }

    @PutMapping("/products/{itemNumber}")
    public ResponseEntity<Product> updateProduct(@PathVariable Long itemNumber, @RequestBody Product productDetails) {
        Product product = productService.findById(itemNumber)
                .orElseThrow(() -> new NullPointerException("Category not exist with id :" + itemNumber));

        product.setProductDescription(productDetails.getProductDescription());
        product.setProductLongDescription(productDetails.getProductLongDescription());
        product.setSize(productDetails.getSize());
        product.setCategory(productDetails.getCategory());
        product.setPrice(productDetails.getPrice());

        Product updatedProduct = productRepo.save(product);
        return ResponseEntity.ok(updatedProduct);
    }

    @DeleteMapping("/products/{itemNumber}")
    public ResponseEntity<Map<String, Boolean>> deleteProduct(@PathVariable Long itemNumber) {
        productService.delete(itemNumber);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return ResponseEntity.ok(response);
    }

}