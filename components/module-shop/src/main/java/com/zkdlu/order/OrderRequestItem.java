package com.zkdlu.order;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
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
