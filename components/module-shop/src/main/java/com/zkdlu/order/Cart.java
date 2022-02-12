package com.zkdlu.order;

import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@Getter
public class Cart {
    private int totalPrice;
    private List<CartItem> cartItems;
    private String title;

    public Cart(int totalPrice, List<CartItem> cartItems) {
        this.totalPrice = totalPrice;
        this.cartItems = cartItems;

        validate();

        this.title = makeTitleFromCartItems();
    }

    private String makeTitleFromCartItems() {
        String baseName = cartItems.get(0).getFoodName();

        if (cartItems.size() > 1) {
            return baseName + " 외 " + (cartItems.size() - 1) + "개";
        }

        return baseName;
    }

    private void validate() {
        verifyCartItems();
        verifyTotalAmount();
    }

    private void verifyTotalAmount() {
        int orderAmount = cartItems.stream()
                .mapToInt(CartItem::getFoodPrice)
                .sum();

        if (totalPrice != orderAmount) {
            throw new IllegalArgumentException("결제 금액이 변동되었습니다.");
        }
    }

    private void verifyCartItems() {
        if (cartItems == null || cartItems.isEmpty()) {
            throw new IllegalArgumentException("주문 항목이 비어있습니다.");
        }
    }
}
