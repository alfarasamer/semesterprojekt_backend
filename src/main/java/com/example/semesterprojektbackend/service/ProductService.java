package com.example.semesterprojektbackend.service;

import com.example.semesterprojektbackend.model.Product;
import com.example.semesterprojektbackend.repositories.ProductRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    private final ProductRepo productRepo;

    public ProductService(ProductRepo productRepo) {
        this.productRepo = productRepo;
    }

    public List<Product> getProducts(){
        return productRepo.findAll();
    }

}
