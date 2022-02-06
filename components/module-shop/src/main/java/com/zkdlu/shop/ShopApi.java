package com.zkdlu.shop;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/shops")
public class ShopApi {

    @GetMapping
    public List<Shop> getShops() {
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
