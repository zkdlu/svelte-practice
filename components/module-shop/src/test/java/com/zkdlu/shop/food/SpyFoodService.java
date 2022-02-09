package com.zkdlu.shop.food;

import java.util.List;

public class SpyFoodService implements FoodService {
    public long getFoodsFromShop_argumentsShopId;
    public List<Food> getFoodsFromShop_returnValue;

    @Override
    public List<Food> getFoodsFromShop(long shopId) {
        getFoodsFromShop_argumentsShopId = shopId;
        return getFoodsFromShop_returnValue;
    }
}
