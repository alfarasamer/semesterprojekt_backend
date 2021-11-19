// Done, *******
package com.example.semesterprojektbackend.controller;

import com.example.semesterprojektbackend.model.User;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
public class UserController {

    @GetMapping("/user")
    public ArrayList<User> getUser() {
        return null; // TODO: 29/06/2021 to list all users
    }

    @GetMapping("/user/{userId}")
    public User getUserPath(@PathVariable int userId) {
        return demoUser();// TODO: 29/06/2021 to return a specific user
    }

    @PostMapping("/user")
    public User postUserPath(@RequestBody User user) {
         // TODO: 29/06/2021 to create a new user
    return null;
    }

    @PutMapping("/users/{userId}")
    public User putUserPath(@PathVariable int userId, @RequestBody User user) {
        // TODO: 29/06/2021 to edit user data
    return null;
    }

    @DeleteMapping("/user/{userId}")
    public User deleteUserPath(@PathVariable int userId) {
        return null;
        // TODO: 29/06/2021 to delete a specific user
    }

    private User demoUser() {
        return new User("Herr", "Max", "Mustermann", 1, "Wien", "Musterstrasse", 10, "mustermail@test.at", "musteruser", "musterPassword", true, "Kunde");

        // TODO: 29/06/2021 to be deleted later! }
    }

}