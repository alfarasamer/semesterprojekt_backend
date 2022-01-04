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

    public Product save(Product product){
        productRepo.save(product);
        return product;
    }

    public Optional<Product> findById(Long id){
        return productRepo.findById(id);
    }
    public void delete (Long id){
        productRepo.deleteById(id);
    }
}
