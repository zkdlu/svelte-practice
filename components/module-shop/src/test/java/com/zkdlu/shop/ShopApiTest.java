package com.zkdlu.shop;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasSize;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

class ShopApiTest {

    private MockMvc mockMvc;

    @BeforeEach
    void setUp() {
        ShopApi controller = new ShopApi();
        mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
    }

    @Test
    void getShops_returnsOkHttpStatus() throws Exception {
        mockMvc.perform(get("/shops"))
                .andExpect(status().isOk());
    }

    @Test
    void getShops_returnsShops() throws Exception {
        mockMvc.perform(get("/shops"))
                .andExpect(jsonPath("$").isArray())
                .andExpect(jsonPath("$", hasSize(1)))
                .andExpect(jsonPath("$[0].id", equalTo(1)))
                .andExpect(jsonPath("$[0].name", equalTo("shop-1")))
                .andExpect(jsonPath("$[0].category", equalTo("CHICKEN")))
                .andExpect(jsonPath("$[0].minPrice", equalTo(10000)))
                .andExpect(jsonPath("$[0].deliveryPrice", equalTo(1000)))
                .andExpect(jsonPath("$[0].location.longitude", equalTo(100)))
                .andExpect(jsonPath("$[0].location.latitude", equalTo(100)))
                .andExpect(jsonPath("$[0].open", equalTo(true)))
                .andExpect(jsonPath("$[0].icon", equalTo("icon")));
    }
}