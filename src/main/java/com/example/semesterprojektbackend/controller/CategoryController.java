//Done, need review
package com.example.semesterprojektbackend.controller;

import com.example.semesterprojektbackend.model.Category;
import com.example.semesterprojektbackend.model.Product;
import com.example.semesterprojektbackend.service.CategoryService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class CategoryController {

    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping("/categories")
    public String getCategory(){
        List<Category> categoryList = categoryService.getCategories();
        return categoryList.toString();
        // TODO: 29/06/2021 to get all categories 
    }

    @GetMapping("/categories/{categoryId}")
    public Optional<Category> findById(@PathVariable int categoryId){
        return categoryService.findById(categoryId);
    }

    @PostMapping("/categories/addNew")
    public String addNew(Category category){
        categoryService.save(category);
        return "redirect:/categories";
    }

    @PutMapping("/categories/{categoryId}")
    public Product putCategoryPath(@PathVariable int categoryId, @RequestBody Category category) {
        // TODO: 29/06/2021 to edit category information
    return null;
    }

    @DeleteMapping("/categories/{categoryId}")
    public Product deleteCategoryPath(@PathVariable int categoryId) {
        // TODO: 29/06/2021 to delete a specific category
    return null;
    }

    private Category demoCategory() {
        return new Category( 1, "Main Category1");
        // TODO: 29/06/2021 to be deleted later! }
}
}
