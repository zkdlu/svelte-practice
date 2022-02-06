package com.zkdlu.shop;

import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
class ShopRepositoryImpl implements ShopRepository {
    @Override
    public List<Shop> findAll() {
        return List.of(
                new Shop(1L,
                        "shop-1",
                        ShopCategory.CHICKEN,
                        10000,
                        1000,
                        new ShopLocation(100L, 100L),
                        true,
                        "icon")
        );
    }
}
