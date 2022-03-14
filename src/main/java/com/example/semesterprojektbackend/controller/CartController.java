package com.example.semesterprojektbackend.controller;

import com.example.semesterprojektbackend.model.*;
import com.example.semesterprojektbackend.repositories.CartItemRepo;
import com.example.semesterprojektbackend.repositories.CartRepo;
import com.example.semesterprojektbackend.repositories.UserRepo;
import com.example.semesterprojektbackend.service.CartService;
import com.example.semesterprojektbackend.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@RestController
public class CartController {

private final UserRepo userRepo;
private final CartService cartService;

    @GetMapping("/cart")
    public List<CartItem> cartItems(){
        final String currentUserName = SecurityContextHolder.getContext().getAuthentication().getName();
        Optional<User> user = userRepo.findByUsername(currentUserName);
        List<CartItem> cartItems = user.get().getCart().getCartItems();
        return cartItems;
    }

    @GetMapping("/cartdto")
    public CartDTO getCartDTO(){
        final String currentUserName = SecurityContextHolder.getContext().getAuthentication().getName();

        CartDTO cartDTO = cartService.getCartDTO(currentUserName);
        return  cartDTO;
    }

    @PutMapping("/cart/add-to-cart/{productId}")
    public ResponseEntity<?> addToCart(@PathVariable Long productId){
        final String currentUserName = SecurityContextHolder.getContext().getAuthentication().getName();

        cartService.updateCart(productId,1,currentUserName);

        return ResponseEntity.ok().build();
    }
    @PutMapping("/cart/remove-from-cart/{productId}")
    public ResponseEntity<?> removeFromCart(@PathVariable Long productId){
        final String currentUserName = SecurityContextHolder.getContext().getAuthentication().getName();

        cartService.updateCart(productId,-1,currentUserName);

        return ResponseEntity.ok().build();
    }
}
