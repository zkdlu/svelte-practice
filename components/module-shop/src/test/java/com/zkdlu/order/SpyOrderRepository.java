package com.zkdlu.order;

public class SpyOrderRepository implements OrderRepository {
    public Order save_argumentOrder;

    @Override
    public Order save(Order order) {
        save_argumentOrder = order;
        return order;
    }
}
