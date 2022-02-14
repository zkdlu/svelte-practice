package com.zkdlu.order.application;

import com.zkdlu.order.domain.Order;

public interface OrderService {
    Order placeOrder(Cart cart);

    Order getOrder(String orderId);

    Order pay(String orderId);
}
