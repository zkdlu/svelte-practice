package com.zkdlu.order.service;

import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class CartTest {
    @Test
    void cartThrownException_whenCartIsNull() {
        var actual = assertThrows(IllegalArgumentException.class, () -> {
           new Cart(0, null);
        });

        assertThat(actual.getMessage()).isEqualTo("주문 항목이 비어있습니다.");
    }

    @Test
    void cartThrownException_whenCartIsEmpty() {
        var actual = assertThrows(IllegalArgumentException.class, () -> {
            new Cart(0, Collections.emptyList());
        });

        assertThat(actual.getMessage()).isEqualTo("주문 항목이 비어있습니다.");
    }

    @Test
    void cart_title_is_cartItemName_when_size_one() {
        var cart = new Cart(0, List.of(new CartItem(0,0,"이름", 0)));

        assertThat(cart.getTitle()).isEqualTo("이름");
    }

    @Test
    void cart_title_is_cartItemNames_when_size_more_than_one() {
        var cart = new Cart(0, List.of(
                new CartItem(0,0,"이름", 0),
                new CartItem(0,0,"이름", 0)
        ));

        assertThat(cart.getTitle()).isEqualTo("이름 외 1개");
    }
}