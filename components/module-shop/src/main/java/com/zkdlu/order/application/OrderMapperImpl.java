package com.zkdlu.order.application;

import com.zkdlu.common.LocalDateTimeProvider;
import com.zkdlu.common.UuidProvider;
import com.zkdlu.order.domain.Order;
import com.zkdlu.order.domain.OrderItem;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Component
public class OrderMapperImpl implements OrderMapper{
    private final UuidProvider uuidProvider;
    private final LocalDateTimeProvider localDateTimeProvider;

    @Override
    public Order mapFrom(Cart cart) {
        return new Order(
                uuidProvider.randomUUID().toString(),
                localDateTimeProvider.now(),
                mapFromCartItem(cart.getCartItems()));
    }

    private List<OrderItem> mapFromCartItem(List<CartItem> cartItems) {
        return cartItems.stream().map(cartItem -> new OrderItem(
                cartItem.getShopId(),
                cartItem.getFoodId(),
                cartItem.getFoodName(),
                cartItem.getFoodPrice()
        )).collect(Collectors.toList());
    }
}
