package com.zkdlu.shop;

import com.zkdlu.shop.food.Food;

import java.util.List;

interface ShopService {
    List<Shop> getShops();

    List<Food> getFoods(long shopId);
}
