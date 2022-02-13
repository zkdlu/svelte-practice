package com.zkdlu.order.adapter;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.zkdlu.order.application.Cart;
import com.zkdlu.order.application.CartItem;
import com.zkdlu.order.application.SpyOrderService;
import com.zkdlu.order.domain.Order;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

class OrderApiTest {

    private ObjectMapper objectMapper;
    private SpyOrderService spyOrderService;
    private MockMvc mockMvc;

    @BeforeEach
    void setUp() {
        objectMapper = new ObjectMapper();

        spyOrderService = new SpyOrderService();
        OrderApi orderApi = new OrderApi(spyOrderService);

        mockMvc = MockMvcBuilders.standaloneSetup(orderApi).build();
    }

    @Test
    void placeOrder_returnsCreatedHttpStatus() throws Exception {
        spyOrderService.placeOrder_returnValue = new Order(null, null, null);

        mockMvc.perform(post("/orders")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsBytes(new Cart())))
                .andExpect(status().isCreated());
    }

    @Test
    void placeOrder_returnsOrder() throws Exception {
        UUID givenUuid = UUID.randomUUID();

        spyOrderService.placeOrder_returnValue = new Order(
                givenUuid.toString(),
                LocalDateTime.of(2022, 2, 12, 12, 30, 40), null);

        mockMvc.perform(post("/orders")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsBytes(new Cart())))
                .andExpect(jsonPath("$.orderId", equalTo(givenUuid.toString())))
                .andExpect(jsonPath("$.orderDate", equalTo("2022-02-12 12:30:40")));
    }

    @Test
    void placeOrder_passesOrderRequestToService() throws Exception {
        spyOrderService.placeOrder_returnValue = new Order(null, null, null);

        CartItem givenCartItem = new CartItem(1L, 2L, "치킨이 두마리!", 10000);
        Cart givenCart = new Cart(List.of(givenCartItem));

        mockMvc.perform(post("/orders")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsBytes(givenCart)));

        assertThat(spyOrderService.placeOrder_argumentCart.getCartItems()).hasSize(1);
        assertThat(spyOrderService.placeOrder_argumentCart.getCartItems().get(0).getShopId()).isEqualTo(1L);
        assertThat(spyOrderService.placeOrder_argumentCart.getCartItems().get(0).getFoodId()).isEqualTo(2L);
        assertThat(spyOrderService.placeOrder_argumentCart.getCartItems().get(0).getFoodName()).isEqualTo("치킨이 두마리!");
        assertThat(spyOrderService.placeOrder_argumentCart.getCartItems().get(0).getFoodPrice()).isEqualTo(10000);
    }

    @Test
    void getOder_returnsOkHttpStatus() throws Exception {
        spyOrderService.getOrder_returnValue = new Order(null, null, null);

        mockMvc.perform(get("/orders/givenOrderId"))
                .andExpect(status().isOk());
    }

    @Test
    void getOrder_returnsOrder() throws Exception {
        spyOrderService.getOrder_returnValue = new Order("givenOrderId", LocalDateTime.of(2022,2,13,12,30,0), null);
        mockMvc.perform(get("/orders/givenOrderId"))
                .andExpect(jsonPath("$.orderId", equalTo("givenOrderId")))
                .andExpect(jsonPath("$.orderDate", equalTo("2022-02-13 12:30:00")));
    }

    @Test
    void getOrder_passesOrderIdToService() throws Exception {
        spyOrderService.getOrder_returnValue = new Order(null, null, null);

        mockMvc.perform(get("/orders/givenOrderId"));

        assertThat(spyOrderService.getOrder_argumentOrderId).isEqualTo("givenOrderId");
    }
}