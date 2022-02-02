package com.example.semesterprojektbackend.service;

import com.example.semesterprojektbackend.model.Brand;
import com.example.semesterprojektbackend.repositories.BrandRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BrandService {
    private final BrandRepo brandRepo;

    public BrandService(BrandRepo brandRepo) {
        this.brandRepo = brandRepo;
    }

    //Return List of Brands
    public List<Brand> getBrands() {
        return brandRepo.findAll();
    }

    // Save new Brand
    public Brand save(Brand brand) {
        brandRepo.save(brand);
        return brand;
    }

    // Get by id
    public Optional<Brand> findById(int id) {
        return brandRepo.findById(id);
    }

    // Delete by id
    public void delete(int id) {
        brandRepo.deleteById(id);
    }


}
