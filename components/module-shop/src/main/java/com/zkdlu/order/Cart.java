package com.zkdlu.order;

import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@Getter
public class Cart {
    private int totalPrice;
    private List<CartItem> cartItems;
    private String title;

    public Cart(int totalPrice, String title, List<CartItem> cartItems) {
        this.totalPrice = totalPrice;
        this.title = title;
        this.cartItems = cartItems;
    }
}
