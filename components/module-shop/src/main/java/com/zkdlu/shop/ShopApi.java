package com.zkdlu.shop;

import com.zkdlu.shop.food.Food;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/shops")
class ShopApi {
    private final ShopService shopService;

    @GetMapping
    public List<Shop> getShops() {
        return shopService.getShops();
    }

    @GetMapping("/{id}/foods")
    public List<Food> getFoods(@PathVariable("id") long shopId) {
        return shopService.getFoods(shopId);
    }
}
