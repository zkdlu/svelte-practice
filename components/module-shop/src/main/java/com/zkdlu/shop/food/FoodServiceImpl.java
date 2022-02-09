package com.zkdlu.shop.food;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class FoodServiceImpl implements FoodService{
    private final FoodRepository foodRepository;

    @Override
    public List<Food> getFoodsFromShop(long shopId) {
        return foodRepository.findByShopId(shopId);
    }
}
