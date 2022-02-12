package com.zkdlu.order;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.EqualsAndHashCode;
import lombok.Getter;

import javax.persistence.Entity;
import java.time.LocalDateTime;

@EqualsAndHashCode
@Entity
@Getter
public class Order {
    private String orderId;
    private String orderTitle;
    @JsonFormat(pattern = "yyyy-MM-dd hh:mm:ss")
    private LocalDateTime orderDate;
    private int orderAmount;
    private int paymentAmount;
    private OrderState orderState;

    public Order(String orderId, String orderTitle, LocalDateTime orderDate, int orderAmount, int paymentAmount) {
        this.orderId = orderId;
        this.orderTitle = orderTitle;
        this.orderDate = orderDate;
        this.orderAmount = orderAmount;
        this.paymentAmount = paymentAmount;
        this.orderState = OrderState.NONE;
    }

    public void place() {
        this.orderState = OrderState.ORDERED;
    }
}
