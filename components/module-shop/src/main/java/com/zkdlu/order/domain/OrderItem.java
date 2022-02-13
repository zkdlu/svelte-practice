package com.zkdlu.order.domain;

import lombok.Getter;

@Getter
public class OrderItem {
    private long shopId;
    private long foodId;
    private String foodName;
    private int foodPrice;

    public OrderItem(long shopId, long foodId, String foodName, int foodPrice) {
        this.shopId = shopId;
        this.foodId = foodId;
        this.foodName = foodName;
        this.foodPrice = foodPrice;
    }
}
