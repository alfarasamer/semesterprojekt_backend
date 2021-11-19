//Done, need review
package com.example.semesterprojektbackend.controller;

import com.example.semesterprojektbackend.model.Category;
import com.example.semesterprojektbackend.model.Product;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
public class CategoryController {

    @GetMapping("/categories")
    public ArrayList<Category> getCategory() {
        return null;
        // TODO: 29/06/2021 to get all categories 
    }
    @GetMapping("/categories/{categoryId}")
    public Category getCategoryPath(@PathVariable int categoryId) {
        return demoCategory();
        // TODO: 29/06/2021 to get a specific category 
    }

    @PostMapping("/categories")
    public Product postCategoryPath(@RequestBody Category category) {
        return null;
        // TODO: 29/06/2021 to create a new category
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
