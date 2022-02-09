package com.zkdlu.shop.food;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
public class Food {
    private long id;
    private String name;
    private int price;
    private String category;
    private String icon;
    private boolean saled;
    private long shopId;

    public Food(long id, String name, int price, String category, String icon, boolean saled, long shopId) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.category = category;
        this.icon = icon;
        this.saled = saled;
        this.shopId = shopId;
    }
}
