package com.zkdlu.order;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDateTime;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
@EqualsAndHashCode
@Entity
@Table(name = "ORDERS")
@Getter
public class Order {
    @Id
    private String orderId;
    private String orderTitle;
    @JsonFormat(pattern = "yyyy-MM-dd hh:mm:ss")
    private LocalDateTime orderDate;
    private int orderAmount;
    private int paymentAmount;
    @Enumerated(EnumType.STRING)
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
