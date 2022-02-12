package com.zkdlu.order;

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
}
