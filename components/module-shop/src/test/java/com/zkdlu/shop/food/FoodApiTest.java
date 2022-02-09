package com.zkdlu.shop.food;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasSize;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

class FoodApiTest {

    private MockMvc mockMvc;

    @BeforeEach
    void setUp() {
        FoodApi controller = new FoodApi();
        mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
    }

    @Test
    void getFoods_returnsOkHttpStatus() throws Exception {
        mockMvc.perform(get("/shops/1/foods"))
                .andExpect(status().isOk());
    }

    @Test
    void getFoods_returnsFoods() throws Exception {
        mockMvc.perform(get("/shops/1/foods"))
                .andExpect(jsonPath("$").isArray())
                .andExpect(jsonPath("$", hasSize(1)))
                .andExpect(jsonPath("$[0].id", equalTo(1)))
                .andExpect(jsonPath("$[0].name", equalTo("음식")))
                .andExpect(jsonPath("$[0].price", equalTo(1000)))
                .andExpect(jsonPath("$[0].category", equalTo("식사류")))
                .andExpect(jsonPath("$[0].icon", equalTo("\uD83C\uDF63")))
                .andExpect(jsonPath("$[0].saled", equalTo(true)));
    }
}