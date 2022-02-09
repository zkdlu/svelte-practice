package com.zkdlu.shop;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Entity
@Getter
public class Shop {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String name;
    @Enumerated(EnumType.STRING)
    private ShopCategory category;
    private int minPrice;
    private int deliveryPrice;
    @Embedded
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
