package com.zkdlu.order.application;

import com.zkdlu.order.domain.Order;

public class SpyOrderService implements OrderService {
    public Cart placeOrder_argumentCart;
    public Order placeOrder_returnValue;
    public String getOrder_argumentOrderId;
    public Order getOrder_returnValue;
    public String pay_argumentOrderId;
    public Order pay_returnValue;

    @Override
    public Order placeOrder(Cart cart) {
        placeOrder_argumentCart = cart;
        return placeOrder_returnValue;
    }

    @Override
    public Order getOrder(String orderId) {
        getOrder_argumentOrderId = orderId;
        return getOrder_returnValue;
    }

    @Override
    public Order pay(String orderId) {
        pay_argumentOrderId = orderId;
        return pay_returnValue;
    }
}
