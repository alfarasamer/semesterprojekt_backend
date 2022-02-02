package com.example.semesterprojektbackend.controller;

import com.example.semesterprojektbackend.model.Counts;
import com.example.semesterprojektbackend.service.CountsService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("/counts")
public class CountsController {
    private final CountsService countsService;

    @GetMapping()
    public Counts getCounts() {
        return countsService.getCounts();
    }
}
