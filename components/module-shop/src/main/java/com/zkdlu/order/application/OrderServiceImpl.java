package com.zkdlu.order.application;

import com.zkdlu.order.domain.Order;
import com.zkdlu.order.domain.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Collections;

@RequiredArgsConstructor
@Service
public class OrderServiceImpl implements OrderService{
    private final OrderMapper orderMapper;
    private final OrderRepository orderRepository;

    @Override
    public Order placeOrder(Cart cart) {
        Order order = orderMapper.mapFrom(cart);
        order.place();

        return orderRepository.save(order);
    }

    @Override
    public Order getOrder(String orderId) {
        return new Order(
                orderId,
                LocalDateTime.of(2022, 2, 12, 12, 30, 40), Collections.emptyList());
    }
}
