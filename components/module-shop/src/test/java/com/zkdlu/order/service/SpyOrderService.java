package com.zkdlu.order.service;

import com.zkdlu.order.domain.Order;

public class SpyOrderService implements OrderService {
    public Cart placeOrder_argumentCart;
    public Order placeOrder_returnValue;

    @Override
    public Order placeOrder(Cart cart) {
        placeOrder_argumentCart = cart;
        return placeOrder_returnValue;
    }
}
