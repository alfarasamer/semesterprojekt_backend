package com.example.semesterprojektbackend.controller;

import com.example.semesterprojektbackend.model.UserRegistration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserRegistrationController {
    @GetMapping("/registration")
    public UserRegistration getRegistration() {
        return getDemoRegistration();
    }

    @GetMapping("/registration/{userId}")
    public UserRegistration getRegistrationPath(@PathVariable int userId) {
        return getDemoRegistration();
    }

    private UserRegistration getDemoRegistration() {
        return new UserRegistration("Max", "Mastermind", "muster@qq.com", "musters", "passwords");
    }

    @PostMapping("/registration")
    public UserRegistration postRegistration() {
        return postDemoRegistration();
    }

    @PostMapping("/registration/{userId}")
    public UserRegistration postRegistrationPath(@PathVariable int userId) {
        return postDemoRegistration();
    }

    private UserRegistration postDemoRegistration() {
        return new UserRegistration("Maps", "Mastermind", "mustermail@muster.com", "mysterious", "masterclasses");
    }
}

