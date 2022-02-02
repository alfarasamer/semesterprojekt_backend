package com.example.semesterprojektbackend.service;

import com.example.semesterprojektbackend.model.Product;
import com.example.semesterprojektbackend.model.enumuration.Status;
import com.example.semesterprojektbackend.repositories.ProductRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ProductService {
    private final ProductRepo productRepo;


    public List<Product> findAll() {
        return productRepo.findAll();
    }

    public List<Product> getActiveProducts() {
        List<Product> activeProducts = productRepo.findAll().stream().filter(p -> p.getStatus() == Status.ACTIVE).collect(Collectors.toList());

        return activeProducts;
    }


    public Product save(Product product) {
        productRepo.save(product);
        return product;
    }

    public Product findByItemNumber(Long itemNumber) {
        return productRepo.findByItemNumber(itemNumber);
    }

    public Optional<Product> findById(Long itemNumber) {
        return productRepo.findById(itemNumber);
    }

    public void delete(Long id) {
        productRepo.deleteById(id);
    }

}
