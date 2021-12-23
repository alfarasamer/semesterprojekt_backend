package com.example.semesterprojektbackend.controller;

import com.example.semesterprojektbackend.model.Product;
import com.example.semesterprojektbackend.model.User;
import com.example.semesterprojektbackend.service.UserService;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class UserController {


/*
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }


    @GetMapping("/users")
    public List<User> getUsers(){
        return userService.findAll();
    }

    @GetMapping("/users/{id}")
    public Optional<User> getUserById(@PathVariable Long id){
    return userService.findById(id);
    }

    @PostMapping("/registration")
    public String addNew(@Validated @RequestBody User user) {
        user.setPassword(BCryptPasswordEncoder. user.getPassword());
        userService.save(user);
        return "redirect:/";
    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
*/
}
