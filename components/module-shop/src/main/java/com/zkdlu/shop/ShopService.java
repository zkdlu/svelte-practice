package com.zkdlu.shop;

import java.util.List;

interface ShopService {
    List<Shop> getShops();

    List<Food> getFoods(long shopId);
}
