package com.zkdlu.order.domain;

import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.time.LocalDateTime;
import java.util.List;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
@EqualsAndHashCode
@Entity
@Table(name = "ORDERS")
@Getter
public class Order {
    @Id
    private String orderId;
    private LocalDateTime orderDate;
    @Enumerated(EnumType.STRING)
    private OrderState orderState;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "ORDER_ID")
    private List<OrderItem> orderItems;

    public Order(String orderId, LocalDateTime orderDate, List<OrderItem> orderItems) {
        this.orderId = orderId;
        this.orderDate = orderDate;
        this.orderItems = orderItems;
        this.orderState = OrderState.NONE;
    }

    public void place() {
        this.orderState = OrderState.ORDERED;
    }
}
