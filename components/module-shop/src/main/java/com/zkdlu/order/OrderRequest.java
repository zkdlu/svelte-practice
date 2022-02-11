package com.zkdlu.order;

import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@Getter
public class OrderRequest {
    private int totalPrice;
    private List<OrderRequestItem> orderItems;

    public OrderRequest(int totalPrice, List<OrderRequestItem> orderItems) {
        this.totalPrice = totalPrice;
        this.orderItems = orderItems;
    }
}
