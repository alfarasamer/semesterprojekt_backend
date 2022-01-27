package com.example.semesterprojektbackend.repositories;

import com.example.semesterprojektbackend.model.CartItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartItemRepo extends JpaRepository<CartItem, Integer> {
}
