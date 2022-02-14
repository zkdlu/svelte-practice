package com.zkdlu.order.domain;

import lombok.Getter;

@Getter
public enum OrderState {
    NONE("NONE"),
    ORDERED("ORDERED"),
    PAYED("PAYED");

    private String tag;

    OrderState(String tag) {
        this.tag = tag;
    }
}
