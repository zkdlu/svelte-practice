package com.zkdlu.order.service;

import com.zkdlu.order.domain.Order;
import com.zkdlu.order.domain.OrderState;
import com.zkdlu.order.domain.SpyOrderRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;

class OrderServiceImplTest {

    private OrderService orderService;
    private SpyOrderMapper spyOrderMapper;
    private SpyOrderRepository spyOrderRepository;

    @BeforeEach
    void setUp() {
        spyOrderMapper = new SpyOrderMapper();
        spyOrderRepository = new SpyOrderRepository();
        orderService = new OrderServiceImpl(spyOrderMapper, spyOrderRepository);
    }

    @Test
    void placeOrder_createNewOrderUsingCart() {
        CartItem givenCartItem = new CartItem(1L, 2L, "치킨이 두마리!", 10000);
        Cart givenCart = new Cart(10000, List.of(givenCartItem));

        orderService.placeOrder(givenCart);

        assertThat(spyOrderMapper.mapFrom_argumentCart).isEqualTo(givenCart);
    }

    @Test
    void placeOrder_passesOrderToRepository() {
        UUID givenOrderId = UUID.randomUUID();
        Order givenOrder = getDefaultOrder(givenOrderId);
        spyOrderMapper.mapFrom_returnValue = givenOrder;

        orderService.placeOrder(null);

        assertThat(spyOrderRepository.save_argumentOrder).isEqualTo(givenOrder);
    }

    @Test
    void placeOrder_returnsOrder_stateOrdered() {
        spyOrderMapper.mapFrom_returnValue = getDefaultOrder(UUID.randomUUID());

        Order actual = orderService.placeOrder(null);

        assertThat(actual.getOrderState()).isEqualTo(OrderState.ORDERED);
    }

    private Order getDefaultOrder(UUID orderId) {
        return new Order(
                orderId.toString(),
                "치킨이 두마리",
                LocalDateTime.of(2022, 2, 12, 12, 30, 40),
                10000,
                10000);
    }
}