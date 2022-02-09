package com.zkdlu.shop.food;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class FoodServiceImplTest {

    private FoodService foodService;
    private SpyFoodRepository spyFoodRepository;

    @BeforeEach
    void setUp() {
        spyFoodRepository = new SpyFoodRepository();
        foodService = new FoodServiceImpl(spyFoodRepository);
    }

    @Test
    void getFoodsFromShop_passesShopIdToRepository() {
        foodService.getFoodsFromShop(1L);

        assertThat(spyFoodRepository.findByShopId_argumentShopId).isEqualTo(1L);
    }

    @Test
    void getFoodsFromShop_returnsShop() {
        spyFoodRepository.findByShopId_returnValue = List.of(
                new Food(1L,
                        "찜닭",
                        10000,
                        "식사류",
                        "icon",
                        true,
                        2L));

        var actual = foodService.getFoodsFromShop(1L);

        assertThat(actual).hasSize(1);
        assertThat(actual.get(0).getId()).isEqualTo(1L);
        assertThat(actual.get(0).getName()).isEqualTo("찜닭");
        assertThat(actual.get(0).getPrice()).isEqualTo(10000);
        assertThat(actual.get(0).getCategory()).isEqualTo("식사류");
        assertThat(actual.get(0).getIcon()).isEqualTo("icon");
        assertThat(actual.get(0).isSaled()).isEqualTo(true);
        assertThat(actual.get(0).getShopId()).isEqualTo(2L);
    }
}