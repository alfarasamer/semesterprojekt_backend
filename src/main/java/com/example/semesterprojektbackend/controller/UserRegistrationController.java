package com.example.semesterprojektbackend.controller;

import com.example.semesterprojektbackend.model.UserRegistration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.Registration;

@RestController
public class UserRegistrationController {
    @GetMapping("/registration")
    public Registration getRegistration() {
        return getDemoRegistration();
    }

    @GetMapping("/registration/{userName}")
    public UserRegistration getRegistrationPath(@PathVariable String userName) {
        return getDemoRegistration();
    }
    private UserRegistration getDemoRegistration() {
        return new UserRegistration("Max", "Mustermann","muster@qq.com","musteruser","passwordtest");
    }
}

