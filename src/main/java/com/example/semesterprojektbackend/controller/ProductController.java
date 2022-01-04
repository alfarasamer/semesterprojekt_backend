package com.example.semesterprojektbackend.controller;

import com.example.semesterprojektbackend.model.Product;
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
@RequestMapping("/products")
public class ProductController {

    private final ProductService productService;


    @GetMapping()
    public List<Product> getProducts() {
        return productService.findAll();
    }

    @GetMapping("/{itemNumber}")
    public Optional<Product> getProductPath(@PathVariable Long itemNumber) {
        return productService.findById(itemNumber);
    }

    @PostMapping()
    public String addNew(@Valid @RequestBody Product product) {
        productService.save(product);
        return "Product created";
    }

    @PutMapping("/{itemNumber}")
    public ResponseEntity<Product> updateProduct(@PathVariable Long itemNumber, @RequestBody Product productDetails) {
        Product product = productService.findById(itemNumber)
                .orElseThrow(() -> new NullPointerException("Category not exist with id :" + itemNumber));

        product.setProductDescription(productDetails.getProductDescription());
        product.setProductLongDescription(productDetails.getProductLongDescription());
        product.setSize(productDetails.getSize());
        product.setCategory(productDetails.getCategory());
        product.setPrice(productDetails.getPrice());

        Product updatedProduct = productService.save(product);
        return ResponseEntity.ok(updatedProduct);
    }

    @DeleteMapping("/{itemNumber}")
    public ResponseEntity<Map<String, Boolean>> deleteProduct(@PathVariable Long itemNumber) {
        productService.delete(itemNumber);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return ResponseEntity.ok(response);
    }

}