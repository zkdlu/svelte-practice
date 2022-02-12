package com.zkdlu.order.service;

import com.zkdlu.order.domain.Order;

public class SpyOrderMapper implements OrderMapper {
    public Cart mapFrom_argumentCart;
    public Order mapFrom_returnValue = new Order(null, null);

    @Override
    public Order mapFrom(Cart cart) {
        mapFrom_argumentCart = cart;
        return mapFrom_returnValue;
    }
}
