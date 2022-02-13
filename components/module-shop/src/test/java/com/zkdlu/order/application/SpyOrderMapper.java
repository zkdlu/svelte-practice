package com.zkdlu.order.application;

import com.zkdlu.order.domain.Order;
import com.zkdlu.order.domain.OrderItem;

import java.util.List;

public class SpyOrderMapper implements OrderMapper {
    public Cart mapFrom_argumentCart;
    public Order mapFrom_returnValue = new Order(null, null,
            List.of(new OrderItem(0, 0, null, 0)));

    @Override
    public Order mapFrom(Cart cart) {
        mapFrom_argumentCart = cart;
        return mapFrom_returnValue;
    }
}
