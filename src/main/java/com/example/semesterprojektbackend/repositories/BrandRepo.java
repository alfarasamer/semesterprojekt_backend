package com.example.semesterprojektbackend.repositories;

import com.example.semesterprojektbackend.model.Brand;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BrandRepo extends JpaRepository<Brand,Integer> {
}
