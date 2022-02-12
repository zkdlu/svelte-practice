package com.zkdlu.order.service;

import com.zkdlu.order.domain.Order;

public interface OrderService {
    Order placeOrder(Cart cart);
}
