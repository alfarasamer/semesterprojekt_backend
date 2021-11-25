package com.example.semesterprojektbackend.service;

import com.example.semesterprojektbackend.model.Category;
import com.example.semesterprojektbackend.repositories.CategoryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {
    private final CategoryRepo categoryRepo;

    public CategoryService(CategoryRepo categoryRepo) {
        this.categoryRepo = categoryRepo;
    }
    //Return List of Categories
    public List<Category> getCategories(){
        return categoryRepo.findAll();
    }
    // Save new Category
    public void save (Category category){
        categoryRepo.save(category);
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
