package com.example.semesterprojektbackend.controller;

import com.example.semesterprojektbackend.model.Category;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CategoryController {

    @GetMapping("/categories")
    public Category getCategory() {
        return getDemoCategory();
    }

    @GetMapping("/categories/{category}")
    public Category getCategoryPath(@PathVariable String category) {
        return getDemoCategory();
    }

    private Category getDemoCategory() {
        return new Category("Category1", 3);
    }
}
