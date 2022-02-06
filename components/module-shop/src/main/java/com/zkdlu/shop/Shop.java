package com.zkdlu.shop;

import lombok.Getter;

@Getter
public class Shop {
    private long id;
    private String name;
    private ShopCategory category;
    private int minPrice;
    private int deliveryPrice;
    private ShopLocation location;
    private boolean open;
    private String icon;

    public Shop(long id, String name, ShopCategory category, int minPrice, int deliveryPrice, ShopLocation location, boolean open, String icon) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.minPrice = minPrice;
        this.deliveryPrice = deliveryPrice;
        this.location = location;
        this.open = open;
        this.icon = icon;
    }
}
