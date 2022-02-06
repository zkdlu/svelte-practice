package com.zkdlu.shop;

import java.util.List;

class SpyShopRepository implements ShopRepository {
    public List<Shop> findAll_returnValue;

    @Override
    public List<Shop> findAll() {
        return findAll_returnValue;
    }
}
