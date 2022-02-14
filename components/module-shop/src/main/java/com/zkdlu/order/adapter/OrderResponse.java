package com.zkdlu.order.adapter;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.zkdlu.order.domain.Order;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
class OrderResponse {
    private String orderId;
    @JsonFormat(pattern = "yyyy-MM-dd hh:mm:ss")
    private LocalDateTime orderDate;
    private String orderState;

    public OrderResponse(String orderId, LocalDateTime orderDate, String orderState) {
        this.orderId = orderId;
        this.orderDate = orderDate;
        this.orderState = orderState;
    }

    static OrderResponse of(Order order) {
        return new OrderResponse(
                order.getOrderId(),
                order.getOrderDate(),
                order.getOrderState().getTag()
        );
    }
}
