package com.zkdlu.shop;

import com.zkdlu.shop.food.Food;

import java.util.List;

class SpyShopService implements ShopService {
    public List<Shop> getShops_returnValue;
    public long getFoods_argumentShopId;
    public List<Food> getFoods_returnValue;

    @Override
    public List<Shop> getShops() {
        return getShops_returnValue;
    }

    @Override
    public List<Food> getFoods(long shopId) {
        getFoods_argumentShopId = shopId;
        return getFoods_returnValue;
    }
}
