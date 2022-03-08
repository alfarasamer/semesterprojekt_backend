package com.example.semesterprojektbackend.controller;

import com.example.semesterprojektbackend.model.Product;
import com.example.semesterprojektbackend.model.enumuration.Status;
import com.example.semesterprojektbackend.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@AllArgsConstructor
public class ProductController {

    private final ProductService productService;


    @GetMapping("/products")
    public Iterable<Product> getProducts() {
        return productService.findAll();
    }

    @GetMapping("/activeproducts")
    public List<Product> getActiveProducts() {
        return productService.getActiveProducts();
    }

    @GetMapping("/product-by-item-number/{itemNumber}")
    public Optional<Product> getProductPath(@PathVariable Long itemNumber) {
        if (productService.findById(itemNumber).isPresent()){
            if (productService.findById(itemNumber).get().getStatus()== Status.ACTIVE){
                return productService.findById(itemNumber);
            }
        }
        return Optional.empty();
    }

    @GetMapping("/products/{itemNumber}")
    public Optional<Product> getProductById(@PathVariable Long itemNumber) {
        if (productService.findById(itemNumber).isPresent()){
            if (productService.findById(itemNumber).get().getStatus()== Status.ACTIVE){
                return productService.findById(itemNumber);
            }
        }
        return Optional.empty();
    }

    @PostMapping("/products")
    public String addNew(@Valid @RequestBody Product product) {
        productService.save(product);
        return "Product created";
    }

    @PutMapping("/products/{itemNumber}")
    public ResponseEntity<Product> updateProduct(@Valid @PathVariable Long itemNumber, @RequestBody Product productDetails) {
        Product product = productService.findById(itemNumber)
                .orElseThrow(() -> new NullPointerException("Product with itemNumber " + itemNumber + " doesn't exist"));

        product.setPrice(productDetails.getPrice());
        product.setName(productDetails.getName());
        product.setDescription(productDetails.getDescription());
        product.setSize(productDetails.getSize());
        product.setStatus(productDetails.getStatus());
        product.setBrand(productDetails.getBrand());
        product.setCategory(productDetails.getCategory());

        Product updatedProduct = productService.save(product);
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