package com.zkdlu.order;

import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@Getter
public class OrderRequest {
    private int totalPrice;
    private List<OrderRequestItem> orderItems;
}
