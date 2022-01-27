package com.example.semesterprojektbackend.service;

import com.example.semesterprojektbackend.model.Cart;
import com.example.semesterprojektbackend.repositories.CartRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class CartService {

    private final CartRepo cartRepo;

    //Return all carts for Admin
    public List<Cart> getCart(){
        return cartRepo.findAll();
    }

    // Save Cart
    public void save (Cart cart){
        cartRepo.save(cart);
    }

    //Find Cart by Id
    public Optional<Cart> findById(int id){
        return cartRepo.findById(id);
    }
    // Delete Cart
    public void delete (int id){
        cartRepo.deleteById(id);
    }
}
