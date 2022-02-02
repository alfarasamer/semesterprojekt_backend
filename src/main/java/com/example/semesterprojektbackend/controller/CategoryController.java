package com.example.semesterprojektbackend.controller;

import com.example.semesterprojektbackend.model.Category;
import com.example.semesterprojektbackend.service.CategoryService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@AllArgsConstructor
@RequestMapping("/categories")
public class CategoryController {

    private final CategoryService categoryService;

    @GetMapping()
    public List<Category> getCategory() {
        return categoryService.getCategories();
    }

    @GetMapping("/{categoryId}")
    public Optional<Category> findById(@PathVariable int categoryId) {
        return categoryService.findById(categoryId);
    }

    @PostMapping()
    public String addNew(@Valid @RequestBody Category category) {
        categoryService.save(category);
        return "Category created";
    }

    @PutMapping("/{categoryId}")
    public ResponseEntity<Category> updateCategory(@PathVariable int categoryId, @RequestBody Category categoryDetails) {
        Category category = categoryService.findById(categoryId)
                .orElseThrow(() -> new NullPointerException("Category not exist with id :" + categoryId));
        category.setCategoryName(categoryDetails.getCategoryName());
        Category updatedCategory = categoryService.save(category);
        return ResponseEntity.ok(updatedCategory);
    }

    @DeleteMapping("/{categoryId}")
    public ResponseEntity<Map<String, Boolean>> deleteCategory(@PathVariable int categoryId) {
        categoryService.delete(categoryId);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return ResponseEntity.ok(response);
    }
}
