package com.zkdlu.shop;

import com.zkdlu.shop.food.Food;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import java.util.List;

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

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "SHOP_ID")
    private List<Food> foods;

    public Shop(long id, String name, ShopCategory category, int minPrice, int deliveryPrice, ShopLocation location, boolean open, String icon, List<Food> foods) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.minPrice = minPrice;
        this.deliveryPrice = deliveryPrice;
        this.location = location;
        this.open = open;
        this.icon = icon;
        this.foods = foods;
    }
}
