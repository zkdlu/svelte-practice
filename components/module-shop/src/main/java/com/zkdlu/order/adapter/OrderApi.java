package com.zkdlu.order.adapter;

import com.zkdlu.order.application.Cart;
import com.zkdlu.order.application.OrderService;
import com.zkdlu.order.domain.Order;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/orders")
public class OrderApi {
    private final OrderService orderService;

    @PostMapping
    public ResponseEntity placeOrder(@RequestBody Cart cart) {
        var order = orderService.placeOrder(cart);
        return new ResponseEntity(order, HttpStatus.CREATED);
    }

    @GetMapping("/{orderId}")
    public Order getOrder(@PathVariable String orderId) {
        return orderService.getOrder(orderId);
    }
}
