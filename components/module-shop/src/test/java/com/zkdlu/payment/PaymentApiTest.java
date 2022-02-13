package com.zkdlu.payment;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

class PaymentApiTest {

    private MockMvc mockMvc;

    @BeforeEach
    void setUp() {
        PaymentApi controller = new PaymentApi();
        mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
    }

    @Test
    void pay_returnsOkHttpStatus() throws Exception {
        mockMvc.perform(post("/payment"))
                .andExpect(status().isOk());
    }
}