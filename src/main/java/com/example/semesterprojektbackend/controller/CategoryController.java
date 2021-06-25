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
    @GetMapping("/categories/{categoryId}")
    public Category getCategoryPath(@PathVariable int categoryId) {
        return getDemoCategory();
    }
    private Category getDemoCategory() {
        return new Category(10, "Sub Category1",1,"Main Category1");
    }
}
