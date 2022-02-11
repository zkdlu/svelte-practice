package com.zkdlu.order;

public class SpyOrderService implements OrderService {
    public OrderRequest placeOrder_argumentOrderRequest;
    public Order placeOrder_returnValue;

    @Override
    public Order placeOrder(OrderRequest orderRequest) {
        placeOrder_argumentOrderRequest = orderRequest;
        return placeOrder_returnValue;
    }
}
