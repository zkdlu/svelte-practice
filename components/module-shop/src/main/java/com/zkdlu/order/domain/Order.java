package com.zkdlu.order.domain;

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
    @JsonFormat(pattern = "yyyy-MM-dd hh:mm:ss")
    private LocalDateTime orderDate;
    @Enumerated(EnumType.STRING)
    private OrderState orderState;

    public Order(String orderId, LocalDateTime orderDate) {
        this.orderId = orderId;
        this.orderDate = orderDate;
        this.orderState = OrderState.NONE;
    }

    public void place() {
        this.orderState = OrderState.ORDERED;
    }
}
