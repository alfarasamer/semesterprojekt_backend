package com.example.semesterprojektbackend.controller;

import com.example.semesterprojektbackend.model.Category;
import com.example.semesterprojektbackend.repositories.CategoryRepo;
import com.example.semesterprojektbackend.service.CategoryService;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
public class CategoryController {

    private final CategoryRepo categoryRepo;
    private final CategoryService categoryService;

    public CategoryController(CategoryRepo categoryRepo, CategoryService categoryService) {
        this.categoryRepo = categoryRepo;
        this.categoryService = categoryService;
    }

    @GetMapping("/categories")
    public List<Category> getCategory() {
        return categoryService.getCategories();
    }

    @GetMapping("/categories/{categoryId}")
    public Optional<Category> findById(@PathVariable int categoryId) {
        return categoryService.findById(categoryId);
    }

    @PostMapping("/categories/")
    public String addNew(@Valid @RequestBody Category category) {
        categoryService.save(category);
        return "redirect:/categories";
    }

    @PutMapping("/categories/{categoryId}")
    public ResponseEntity<Category> updateCategory(@PathVariable Integer categoryId, @RequestBody Category categoryDetails) {
        Category category = categoryService.findById(categoryId)
                .orElseThrow(() -> new NullPointerException("Category not exist with id :" + categoryId));
        category.setCategoryName(categoryDetails.getCategoryName());
        Category updatedCategory = categoryRepo.save(category);
        return ResponseEntity.ok(updatedCategory);
    }

    @DeleteMapping("/categories/{categoryId}")
    public ResponseEntity<Map<String, Boolean>> deleteCategory(@PathVariable Integer categoryId) {
        categoryService.delete(categoryId);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return ResponseEntity.ok(response);
    }

}
