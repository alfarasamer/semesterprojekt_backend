package com.example.semesterprojektbackend.service;

import com.example.semesterprojektbackend.model.Cart;
import com.example.semesterprojektbackend.repositories.CartRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CartService {
    private final CartRepo cartRepo;

    public CartService(CartRepo cartRepo) {
        this.cartRepo = cartRepo;
    }

    public List<Cart> getCart(){
        return cartRepo.findAll();
    }
    public void save (Cart cart){
        cartRepo.save(cart);
    }
    public Optional<Cart> findById(int id){
        return cartRepo.findById(id);
    }
    public void delete (int id){
        cartRepo.deleteById(id);
    }
}
