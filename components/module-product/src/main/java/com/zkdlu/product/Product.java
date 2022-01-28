package com.zkdlu.product;

import lombok.Getter;

@Getter
public class Product {
    private long id;

    public Product(long id) {
        this.id = id;
    }
}
