// Done, need review
package com.example.semesterprojektbackend.controller;

import com.example.semesterprojektbackend.model.Cart;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
public class CartController {

    @GetMapping("/cart")
    public ArrayList<Cart> getCart() {
        return null;
        // TODO: 29/06/2021 to return all saved carts from all users (for admin view)
    }

    @GetMapping("/cart/{cartId}")
    public Cart getCartPath(@PathVariable int cartId) {
        return demoCart();
        // TODO: 29/06/2021 to return a specific cart (for user view)
    }


    @PutMapping("/cart/{cartId}")
    public Cart putCartPath(@PathVariable int cartId, @RequestBody Cart cart) {
        // TODO: 29/06/2021 to edit a user cart
    }

    private Cart demoCart() {
        return null;
    }
}