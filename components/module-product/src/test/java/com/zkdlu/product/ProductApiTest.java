package com.zkdlu.product;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

class ProductApiTest {

    private MockMvc mockMvc;

    @BeforeEach
    void setUp() {
        ProductApi controller = new ProductApi();
        mockMvc = MockMvcBuilders.standaloneSetup(controller)
                .build();
    }

    @Test
    void getProducts_returns_okHttpStatus() throws Exception {
        mockMvc.perform(get("/products"))
                .andExpect(status().isOk());
    }
}