package com.example.semesterprojektbackend.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ControllerRessourcen {

    @GetMapping("/categories"){
        return getCategory();
    }

    @GetMapping("/categories/{category}")
    public Category getCategory(@PathVariable String category)
        return getCategory(category);
    }
