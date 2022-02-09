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

    public Food(long id, String name, int price, String category, String icon, boolean saled) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.category = category;
        this.icon = icon;
        this.saled = saled;
    }

    //    id: i,
//    name: '음식-' + i,
//    price: 10000 + 1000 * i,
//    category: '식사류',
//    icon: '🍣',
//    saled: true,
}
