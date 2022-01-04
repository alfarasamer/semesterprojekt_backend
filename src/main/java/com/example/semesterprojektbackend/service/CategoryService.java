package com.example.semesterprojektbackend.service;

import com.example.semesterprojektbackend.model.Category;
import com.example.semesterprojektbackend.repositories.CategoryRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class CategoryService {
    private final CategoryRepo categoryRepo;

    //Return List of Categories
    public List<Category> getCategories(){
        return categoryRepo.findAll();
    }
    // Save new Category
    public Category save (Category category){
        categoryRepo.save(category);
        return category;
    }
    // Get by id
    public Optional<Category> findById(int id){
        return categoryRepo.findById(id);
    }
    // Delete by id
    public void delete(int id){
        categoryRepo.deleteById(id);
    }
}
