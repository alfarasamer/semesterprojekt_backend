package com.example.semesterprojektbackend.service;

import com.example.semesterprojektbackend.model.Product;
import com.example.semesterprojektbackend.repositories.ProductRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    private final ProductRepo productRepo;

    public ProductService(ProductRepo productRepo) {
        this.productRepo = productRepo;
    }

    public List<Product> findAll(){
        return productRepo.findAll();
    }

    public void save(Product product){
        productRepo.save(product);
    }

    public Optional<Product> findById(int id){
        return productRepo.findById(id);
    }
    public void delete (int id){
        productRepo.deleteById(id);
    }
}
