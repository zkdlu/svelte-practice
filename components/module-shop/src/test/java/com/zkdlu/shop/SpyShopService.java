package com.zkdlu.shop;

import java.util.List;

class SpyShopService implements ShopService {
    public List<Shop> getShops_returnValue;

    @Override
    public List<Shop> getShops() {
        return getShops_returnValue;
    }
}