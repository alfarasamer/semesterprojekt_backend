// Done, need review
package com.example.semesterprojektbackend.model;

import java.util.ArrayList;

public class Cart {
    private int cartId;
    private ArrayList<Product> products;

    public Cart(int cartId, ArrayList<Product> products) {
        this.cartId = cartId;
        this.products = products;
    }

    public ArrayList<Product> getProducts() {
        return products;
    }

    public void setProducts(ArrayList<Product> products) {
        this.products = products;
    }
}
