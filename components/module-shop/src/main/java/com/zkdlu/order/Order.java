package com.zkdlu.order;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
public class Order {
    private UUID orderId;
    private String orderTitle;
    @JsonFormat(pattern = "yyyy-MM-dd hh:mm:ss")
    private LocalDateTime orderDate;
    private int orderAmount;
    private int paymentAmount;

    public Order(UUID orderId, String orderTitle, LocalDateTime orderDate, int orderAmount, int paymentAmount) {
        this.orderId = orderId;
        this.orderTitle = orderTitle;
        this.orderDate = orderDate;
        this.orderAmount = orderAmount;
        this.paymentAmount = paymentAmount;
    }
}
