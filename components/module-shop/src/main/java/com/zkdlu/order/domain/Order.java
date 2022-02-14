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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.time.LocalDateTime;
import java.util.ArrayList;
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

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "order")
    private List<OrderItem> orderItems = new ArrayList<>();

    public Order(String orderId, LocalDateTime orderDate, List<OrderItem> orderItems) {
        this.orderId = orderId;
        this.orderDate = orderDate;
        this.orderItems = orderItems;
        this.orderState = OrderState.NONE;
    }

    public void place() {
        ordered();
        validate();
    }

    private void validate() {
        if (orderItems.isEmpty()) {
            throw new IllegalStateException("주문 항목이 빔");
        }
    }

    public void ordered() {
        this.orderState = OrderState.ORDERED;
    }

    public void payed() {
        this.orderState = OrderState.PAYED;
    }
}
