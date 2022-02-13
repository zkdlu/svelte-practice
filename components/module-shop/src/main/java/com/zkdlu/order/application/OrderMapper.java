package com.zkdlu.order.application;

import com.zkdlu.order.domain.Order;

public interface OrderMapper {
    Order mapFrom(Cart cart);
}
