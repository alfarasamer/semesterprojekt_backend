package com.example.semesterprojektbackend.service;

import com.example.semesterprojektbackend.model.*;
import com.example.semesterprojektbackend.repositories.CartItemRepo;
import com.example.semesterprojektbackend.repositories.CartRepo;
import com.example.semesterprojektbackend.repositories.UserRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
@AllArgsConstructor
public class CartService {

    private final CartRepo cartRepo;
    private final UserRepo userRepo;
    private final CartItemRepo cartItemRepo;
    private final ProductService productService;
    //Return all carts for Admin
    public List<Cart> getCart() {
        return cartRepo.findAll();
    }

    // Save Cart
    public void save(Cart cart) {
        cartRepo.save(cart);
    }

    //Find Cart by Id
    public Optional<Cart> findById(int id) {
        return cartRepo.findById(id);
    }

    //Create Cart On Registraiton
    public Cart createCart(Long userId){
        Cart cart = new Cart();
        cart.setId(userId);
        save(cart);
        return cart;
    }

    // Delete Cart
    public void delete(int id) {
        cartRepo.deleteById(id);
    }

    public CartDTO getCartDTO(String userName){
        Optional<User> user = userRepo.findByUsername(userName);
        CartDTO cartDTO = new CartDTO();
        cartDTO.setCartItemsCount(user.get().getCart().getCartItems().size());

        float total = 0;
        List<CartItem> cartItemList  =user.get().getCart().getCartItems();
        for (CartItem cartItem : cartItemList){
            total +=(cartItem.getQuantity()*cartItem.getProduct().getPrice());
        }
        cartDTO.setCartTotal(total);

        return cartDTO;
    }

    public List<CartItem> changeQuantity(List<CartItem> cartItems, int quantity, Long itemNumber){
        for (CartItem cartItem:cartItems) {
            if (cartItem.getProduct().getItemNumber() == itemNumber){
                cartItem.setQuantity(cartItem.getQuantity()+quantity);
                if (cartItem.getQuantity()<=0){
                    cartItems.remove(cartItem);
                    cartItemRepo.delete(cartItem);
                    return cartItems;
                }
            }
        }
        return cartItems;
    }

    public void updateCart(Long itemNumber, int quantity, String username) {

        boolean itemExist = false;

        Optional<User> user = userRepo.findByUsername(username);
        List<CartItem> cartItems = user.get().getCart().getCartItems();
        for (CartItem cartItem : cartItems) {
            if (Objects.equals(cartItem.getProduct().getItemNumber(), itemNumber)) {
                itemExist = true;
                break;
            }
        }
        if (itemExist) {
            List<CartItem> cartItems1 = changeQuantity(cartItems, quantity, itemNumber);
            User tempUser = user.get();
            tempUser.getCart().setCartItems(cartItems1);
            userRepo.flush();
            userRepo.save(tempUser);
        } else if (quantity == 1){
            CartItem newCartItem = new CartItem();
            Product product = productService.findByItemNumber(itemNumber);

            newCartItem.setQuantity(1);
            newCartItem.setProduct(product);
            newCartItem.setCart(user.get().getCart());

            cartItemRepo.save(newCartItem);
            cartItems.add(newCartItem);
            Cart cart1 = user.get().getCart();
            cart1.setCartItems(cartItems);

            cartRepo.flush();
            cartRepo.save(cart1);
        }
    }
}
