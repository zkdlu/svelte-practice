package com.zkdlu.shop;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
class ShopServiceImpl implements ShopService {
    private final ShopRepository shopRepository;

    @Override
    public List<Shop> getShops() {
        return shopRepository.findAll();
    }

    @Override
    public List<Food> getFoods(long shopId) {
        Shop shop = shopRepository.findById(shopId)
                .orElseThrow(NotExistShopException::new);

        return shop.getFoods();
    }
}
