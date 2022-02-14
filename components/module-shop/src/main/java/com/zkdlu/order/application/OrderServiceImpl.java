package com.zkdlu.order.application;

import com.zkdlu.order.domain.Order;
import com.zkdlu.order.domain.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

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
        return orderRepository.findById(orderId)
                .orElseThrow(IllegalStateException::new);
    }

    @Override
    public Order pay(String orderId) {
        Order order = orderRepository.findById(orderId)
                .orElseThrow(IllegalStateException::new);

        order.payed();
        return order;
    }
}
