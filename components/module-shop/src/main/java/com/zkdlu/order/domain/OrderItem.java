package com.zkdlu.order.domain;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Entity
@Getter
public class OrderItem {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long orderItemId;
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
