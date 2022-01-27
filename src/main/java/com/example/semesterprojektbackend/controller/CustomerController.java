package com.example.semesterprojektbackend.controller;

import com.example.semesterprojektbackend.model.Customer;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;

@RestController
public class CustomerController {

    @GetMapping("/user")
    public ArrayList<Customer> getUser() {
        return null; // TODO: 29/06/2021 to list all users
    }

    @GetMapping("/user/{userId}")
    public Customer getUserPath(@PathVariable int userId) {
        return null;// TODO: 29/06/2021 to return a specific user
    }

    @PostMapping("/user")
    public Customer postUserPath(@RequestBody Customer customer) {
         // TODO: 29/06/2021 to create a new user
    return null;
    }

    /*@PutMapping("/users/{userId}")
    public Customer putUserPath(@PathVariable int userId, @RequestBody Customer customer) {
        // TODO: 29/06/2021 to edit user data
    return null;
    }*/

    @DeleteMapping("/user/{userId}")
    public Customer deleteUserPath(@PathVariable int userId) {
        return null;
        // TODO: 29/06/2021 to delete a specific user
    }
}