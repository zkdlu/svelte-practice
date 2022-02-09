package com.zkdlu.shop.food;

import java.util.List;

public class SpyFoodService implements FoodService {
    public long getFoodsFromShop_argumentsShopId;

    @Override
    public List<Food> getFoodsFromShop(long shopId) {
        getFoodsFromShop_argumentsShopId = shopId;
        return null;
    }
}
