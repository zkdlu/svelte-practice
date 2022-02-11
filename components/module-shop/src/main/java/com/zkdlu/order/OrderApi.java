package com.zkdlu.order;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity placeOrder(@RequestBody OrderRequest orderRequest) {
        var order = orderService.placeOrder(orderRequest);
        return new ResponseEntity(order, HttpStatus.CREATED);
    }
}
