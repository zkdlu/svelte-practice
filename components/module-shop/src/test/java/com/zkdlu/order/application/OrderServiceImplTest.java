package com.zkdlu.order.application;

import com.zkdlu.order.domain.Order;
import com.zkdlu.order.domain.OrderItem;
import com.zkdlu.order.domain.OrderState;
import com.zkdlu.order.domain.SpyOrderRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.Collections;
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
        Cart givenCart = new Cart(List.of(givenCartItem));

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

    @Test
    void placeOrder_throwsException_whenOrderItemsIsEmpty() {
        var exception = Assertions.assertThrows(IllegalStateException.class, () -> {
            spyOrderMapper.mapFrom_returnValue = new Order(
                    UUID.randomUUID().toString(),
                    LocalDateTime.of(2022, 2, 12, 12, 30, 40), Collections.emptyList());

            orderService.placeOrder(null);
        });
    }

    @Test
    void getOrder_returnsOrder() {
        var actual = orderService.getOrder("order id");

        assertThat(actual.getOrderId()).isEqualTo("order id");
        assertThat(actual.getOrderDate()).isEqualTo(LocalDateTime.of(2022, 2, 12, 12, 30, 40));
    }

    private Order getDefaultOrder(UUID orderId) {
        return new Order(
                orderId.toString(),
                LocalDateTime.of(2022, 2, 12, 12, 30, 40),
                List.of(new OrderItem(0, 0, null, 0)));
    }
}