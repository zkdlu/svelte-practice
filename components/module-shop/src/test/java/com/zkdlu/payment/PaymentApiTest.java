package com.zkdlu.payment;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

class PaymentApiTest {

    private MockMvc mockMvc;
    private SpyPaymentService spyPaymentService;

    @BeforeEach
    void setUp() {
        spyPaymentService = new SpyPaymentService();
        PaymentApi controller = new PaymentApi(spyPaymentService);
        mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
    }

    @Test
    void pay_returnsOkHttpStatus() throws Exception {
        mockMvc.perform(post("/payment/orderId"))
                .andExpect(status().isOk());
    }

    @Test
    void pay_passesOrderIdToService() throws Exception {
        String givenOrderId = "givenOrderId";

        mockMvc.perform(post("/payment/" + givenOrderId));

        assertThat(spyPaymentService.pay_argumentOrderId).isEqualTo(givenOrderId);
    }
}