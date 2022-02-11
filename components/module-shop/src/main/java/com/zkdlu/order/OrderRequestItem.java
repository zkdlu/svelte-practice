package com.zkdlu.order;

import lombok.Getter;

@Getter
public class OrderRequestItem {
    private long shopId;
    private long foodId;
    private String foodName;
    private int foodPrice;

    public OrderRequestItem(long shopId, long foodId, String foodName, int foodPrice) {
        this.shopId = shopId;
        this.foodId = foodId;
        this.foodName = foodName;
        this.foodPrice = foodPrice;
    }
}
