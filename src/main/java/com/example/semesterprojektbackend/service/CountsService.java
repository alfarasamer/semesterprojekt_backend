package com.example.semesterprojektbackend.service;

import com.example.semesterprojektbackend.model.Counts;
import com.example.semesterprojektbackend.repositories.BrandRepo;
import com.example.semesterprojektbackend.repositories.CategoryRepo;
import com.example.semesterprojektbackend.repositories.ProductRepo;
import com.example.semesterprojektbackend.repositories.UserRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CountsService {

    private final CategoryRepo categoryRepo;
    private final UserRepo userRepo;
    private final BrandRepo brandRepo;
    private final ProductRepo productRepo;

    public Counts getCounts() {
        Counts counts = new Counts();

        counts.setBrandsCount(this.brandRepo.count());
        counts.setCategoriesCount(this.categoryRepo.count());
        counts.setProductsCount(this.productRepo.count());
        counts.setUsersCount(this.userRepo.count());

        return counts;
    }
}
