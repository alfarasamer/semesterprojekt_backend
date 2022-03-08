package com.example.semesterprojektbackend.controller;

import com.example.semesterprojektbackend.model.Cart;
import com.example.semesterprojektbackend.model.CartItem;
import com.example.semesterprojektbackend.model.User;
import com.example.semesterprojektbackend.repositories.UserRepo;
import com.example.semesterprojektbackend.service.UserDTOService;
import com.example.semesterprojektbackend.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@RestController
public class CartController {

private final UserRepo userRepo;

    @GetMapping("/cart")
    public List<CartItem> cartItems(){

        final String currentUserName = SecurityContextHolder.getContext().getAuthentication().getName();

        Optional<User> user = userRepo.findByUsername(currentUserName);
        List<CartItem> cartItems = user.get().getCart().getCartItems();
        return cartItems;
    }
}
