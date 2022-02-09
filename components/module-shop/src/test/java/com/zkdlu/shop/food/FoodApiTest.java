package com.zkdlu.shop.food;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasSize;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

class FoodApiTest {

    private MockMvc mockMvc;
    private SpyFoodService spyFoodService;

    @BeforeEach
    void setUp() {
        spyFoodService = new SpyFoodService();
        FoodApi controller = new FoodApi(spyFoodService);
        mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
    }

    @Test
    void getFoods_returnsOkHttpStatus() throws Exception {
        mockMvc.perform(get("/shops/1/foods"))
                .andExpect(status().isOk());
    }

    @Test
    void getFoods_returnsFoods() throws Exception {
        spyFoodService.getFoodsFromShop_returnValue = List.of(
                new Food(
                        1L,
                        "음식",
                        1000,
                        "식사류",
                        "\uD83C\uDF63",
                        true,
                        1L
                )
        );

        mockMvc.perform(get("/shops/1/foods"))
                .andExpect(jsonPath("$").isArray())
                .andExpect(jsonPath("$", hasSize(1)))
                .andExpect(jsonPath("$[0].id", equalTo(1)))
                .andExpect(jsonPath("$[0].name", equalTo("음식")))
                .andExpect(jsonPath("$[0].price", equalTo(1000)))
                .andExpect(jsonPath("$[0].category", equalTo("식사류")))
                .andExpect(jsonPath("$[0].icon", equalTo("\uD83C\uDF63")))
                .andExpect(jsonPath("$[0].saled", equalTo(true)))
                .andExpect(jsonPath("$[0].shopId", equalTo(1)));
    }

    @Test
    void getFoods_passesShopIdToService() throws Exception {
        mockMvc.perform(get("/shops/1/foods"));

        assertThat(spyFoodService.getFoodsFromShop_argumentsShopId).isEqualTo(1L);
    }
}