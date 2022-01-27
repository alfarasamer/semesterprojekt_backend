package com.example.semesterprojektbackend.model;

import javax.persistence.*;

@Entity
public class CartItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @OneToOne
    private Product product;

    @ManyToOne(fetch = FetchType.EAGER)
    private Cart cart;
    private int quantity = 1;
}
