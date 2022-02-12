package com.zkdlu.order;

public class SpyOrderMapper implements OrderMapper {
    public Cart mapFrom_argumentCart;
    public Order mapFrom_returnValue = new Order(null, null, null, 0, 0);

    @Override
    public Order mapFrom(Cart cart) {
        mapFrom_argumentCart = cart;
        return mapFrom_returnValue;
    }
}
