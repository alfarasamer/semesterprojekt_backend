package com.example.semesterprojektbackend.controller;

import com.example.semesterprojektbackend.model.Category;
import com.example.semesterprojektbackend.model.Login;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {

    @GetMapping("/login")
    public Login getLogin() {
        return getDemoLogin();
    }

    @GetMapping("/login/{userName}")
    public Login getLoginPath(@PathVariable String userName) {
        return getDemoLogin();
    }
    private Login getDemoLogin() {
        return new Login("User1", "Password1");
    }
}

