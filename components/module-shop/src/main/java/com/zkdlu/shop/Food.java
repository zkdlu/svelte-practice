package com.zkdlu.shop;

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
public class Food {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
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
}
