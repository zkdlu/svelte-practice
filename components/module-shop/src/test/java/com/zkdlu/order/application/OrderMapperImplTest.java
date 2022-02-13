package com.zkdlu.order.application;

import com.zkdlu.common.StubLocalDateTimeProvider;
import com.zkdlu.common.StubUuidProvider;
import com.zkdlu.order.domain.Order;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;

class OrderMapperImplTest {

    private OrderMapper orderMapper;
    private StubUuidProvider stubUuidProvider;
    private StubLocalDateTimeProvider stubLocalDateTimeProvider;

    @BeforeEach
    void setUp() {
        stubUuidProvider = new StubUuidProvider();
        stubLocalDateTimeProvider = new StubLocalDateTimeProvider();
        orderMapper = new OrderMapperImpl(stubUuidProvider, stubLocalDateTimeProvider);
    }

    @Test
    void mapFrom_returnOrder_mappedFromCart() {
        LocalDateTime givenLocalDateTime = LocalDateTime.of(2022, 2, 11, 12, 13, 14);
        stubLocalDateTimeProvider.now_returnValue = givenLocalDateTime;
        UUID givenUuid = UUID.randomUUID();
        stubUuidProvider.randomUUID_returnValue = givenUuid;

        CartItem givenCartItem = new CartItem(1L, 2L, "치킨이 두마리!", 10000);
        Cart givenCart = new Cart(List.of(givenCartItem));

        Order order = orderMapper.mapFrom(givenCart);

        assertThat(order.getOrderId()).isEqualTo(givenUuid.toString());
        assertThat(order.getOrderDate()).isEqualTo(givenLocalDateTime);

        assertThat(order.getOrderItems()).hasSize(1);
        assertThat(order.getOrderItems().get(0).getShopId()).isEqualTo(1L);
        assertThat(order.getOrderItems().get(0).getFoodId()).isEqualTo(2L);
        assertThat(order.getOrderItems().get(0).getFoodName()).isEqualTo("치킨이 두마리!");
        assertThat(order.getOrderItems().get(0).getFoodPrice()).isEqualTo(10000);
    }
}