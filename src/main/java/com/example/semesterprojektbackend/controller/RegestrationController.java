package com.example.semesterprojektbackend.controller;

import com.example.semesterprojektbackend.model.Login;
import com.example.semesterprojektbackend.model.UserRegestration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.Registration;

@RestController
public class RegestrationController {
    @GetMapping("/registration")
    public Registration getRegistration() {
        return getDemoRegistration();
    }

    @GetMapping("/registration/{userName}")
    public UserRegestration getRegistrationPath(@PathVariable String userName) {
        return getDemoRegistration();
    }
    private UserRegestration getDemoRegistration() {
        return new UserRegestration("Max", "Mustermann","muster@qq.com","musteruser","passwordtest");
    }
}

