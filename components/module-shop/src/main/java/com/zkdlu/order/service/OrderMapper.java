package com.zkdlu.order.service;

import com.zkdlu.order.domain.Order;

public interface OrderMapper {
    Order mapFrom(Cart cart);
}
