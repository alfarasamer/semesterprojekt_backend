package com.example.semesterprojektbackend.controller;

import com.example.semesterprojektbackend.model.User;
import com.example.semesterprojektbackend.model.UserDTO;
import com.example.semesterprojektbackend.service.UserDTOService;
import com.example.semesterprojektbackend.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/users")
@AllArgsConstructor
public class UserController {

    private final UserService userService;
    private final UserDTOService userDTOService;

    @GetMapping()
    public List<User> getUsers() {
        return userService.findAll();
    }

    @GetMapping("/{id}")
    public Optional<User> getUserById(@PathVariable Long id) {
        return userService.findById(id);
    }
    @GetMapping("/token/{token}")
    public UserDTO getUserDTOByToken(@PathVariable String token){
        return userDTOService.findByToken(token);
    }


    @PostMapping()
    public String addNew(@Valid @RequestBody User user) {
        userService.signUpUser(user);
        return "User created";
    }

    @PutMapping("/{id}")
    public ResponseEntity<User> updateUser(@PathVariable Long id, @RequestBody User userDetails) {
        User user = userService.findById(id)
                .orElseThrow(() -> new NullPointerException("User with Id " + id + " doesn't exist"));

        user.setFirstName(userDetails.getFirstName());
        user.setLastName(userDetails.getLastName());
        user.setEnabled(userDetails.getEnabled());
        user.setLocked(userDetails.getLocked());
        user.setRole(userDetails.getRole());

        User updatedUser = userService.save(user);
        return ResponseEntity.ok(updatedUser);
    }

    @DeleteMapping("/{userId}")
    public ResponseEntity<Map<String, Boolean>> deleteUser(@PathVariable Long userId) {
        userService.delete(userId);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return ResponseEntity.ok(response);
    }



}
