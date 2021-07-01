//Done, need review

package com.example.semesterprojektbackend.controller;

import com.example.semesterprojektbackend.model.Product;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
public class ProductController {
    @GetMapping("/products")
    public ArrayList<Product> getProducts() {
        return null;
        // TODO: 29/06/2021 to return all products
    }

    @GetMapping("/products/{itemNumber}")
    public Product getProductPath(@PathVariable int itemNumber) {
        return demoProduct();
        // TODO: 29/06/2021 to return a specific item
    }

    @PostMapping("/products")
    public Product postProductPath(@RequestBody Product product) {
        // TODO: 29/06/2021 to create a new item
    }

    @PutMapping("/products/{itemNumber}")
    public Product putProductPath(@PathVariable int itemNumber,@RequestBody Product product) {
        // TODO: 29/06/2021 to edit a specific product
    }

    @DeleteMapping("/products/{itemNumber}")
    public Product deleteProductPath(@PathVariable int itemNumber) {
        // TODO: 29/06/2021 to delete a specific product
    }

    private Product demoProduct() {
        return new Product(123, "T-shirt","T-Shirt long description", "L", 1, 2, true, 99.5);
        // TODO: 29/06/2021 to be deleted later! }
}
}