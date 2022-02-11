package com.zkdlu.order;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.zkdlu.common.StubUuidProvider;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.UUID;

import static org.hamcrest.Matchers.equalTo;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

class OrderApiTest {

    private MockMvc mockMvc;
    private StubUuidProvider stubUuidProvider;
    private ObjectMapper objectMapper;

    @BeforeEach
    void setUp() {
        objectMapper = new ObjectMapper();
        stubUuidProvider = new StubUuidProvider();
        OrderApi orderApi = new OrderApi(stubUuidProvider);
        mockMvc = MockMvcBuilders.standaloneSetup(orderApi).build();
    }

    @Test
    void placeOrder_returnsCreatedHttpStatus() throws Exception {
        OrderRequest orderRequest = new OrderRequest();

        mockMvc.perform(post("/orders")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsBytes(orderRequest)))
                .andExpect(status().isCreated());
    }

    @Test
    void placeOrder_returnsOrder() throws Exception {
        OrderRequest orderRequest = new OrderRequest();

        UUID givenUuid = UUID.randomUUID();
        stubUuidProvider.randomUUID_returnValue = givenUuid;

        mockMvc.perform(post("/orders")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsBytes(orderRequest)))
                .andExpect(jsonPath("$.orderId", equalTo(givenUuid.toString())))
                .andExpect(jsonPath("$.orderTitle", equalTo("치킨이 두마리")))
                .andExpect(jsonPath("$.orderDate", equalTo("2022-02-12 12:30:40")))
                .andExpect(jsonPath("$.orderAmount", equalTo(10000)))
                .andExpect(jsonPath("$.paymentAmount", equalTo(10000)));
    }
}