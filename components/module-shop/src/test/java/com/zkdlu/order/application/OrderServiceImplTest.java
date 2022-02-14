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
import java.util.Optional;

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
        Order givenOrder = getDefaultOrder("order id");
        spyOrderMapper.mapFrom_returnValue = givenOrder;

        orderService.placeOrder(null);

        assertThat(spyOrderRepository.save_argumentOrder).isEqualTo(givenOrder);
    }

    @Test
    void placeOrder_returnsOrder_stateOrdered() {
        spyOrderMapper.mapFrom_returnValue = getDefaultOrder("order id");

        Order actual = orderService.placeOrder(null);

        assertThat(actual.getOrderState()).isEqualTo(OrderState.ORDERED);
    }

    @Test
    void placeOrder_throwsException_whenOrderItemsIsEmpty() {
        var exception = Assertions.assertThrows(IllegalStateException.class, () -> {
            spyOrderMapper.mapFrom_returnValue = new Order(
                    "",
                    LocalDateTime.of(2022, 2, 12, 12, 30, 40), Collections.emptyList());

            orderService.placeOrder(null);
        });
    }

    @Test
    void getOrder_returnsOrder() {
        spyOrderRepository.findById_returnValue = Optional.of(getDefaultOrder("order id"));
        var actual = orderService.getOrder("order id");

        assertThat(actual.getOrderId()).isEqualTo("order id");
        assertThat(actual.getOrderDate()).isEqualTo(LocalDateTime.of(2022, 2, 12, 12, 30, 40));
    }

    @Test
    void getOrder_passesOrderIdToRepository() {
        spyOrderRepository.findById_returnValue = Optional.of(getDefaultOrder("order id"));
        
        orderService.getOrder("order id");

        assertThat(spyOrderRepository.findById_argumentOrderId).isEqualTo("order id");
    }

    @Test
    void getOrder_throwsException_whenOrderNotExists() {
        Assertions.assertThrows(IllegalStateException.class, () -> {
            orderService.getOrder("order id");
        });
    }

    @Test
    void pay_returnsOrder() {
        spyOrderRepository.findById_returnValue = Optional.of(getDefaultOrder("order id"));
        var actual = orderService.pay("order id");

        assertThat(actual.getOrderId()).isEqualTo("order id");
        assertThat(actual.getOrderDate()).isEqualTo(LocalDateTime.of(2022, 2, 12, 12, 30, 40));
        assertThat(actual.getOrderState()).isEqualTo(OrderState.PAYED);
    }

    @Test
    void pay_passesOrderIdToRepository() {
        spyOrderRepository.findById_returnValue = Optional.of(getDefaultOrder("order id"));
        orderService.pay("order id");

        assertThat(spyOrderRepository.findById_argumentOrderId).isEqualTo("order id");
    }

    @Test
    void pay_throwsException_whenOrderNotExists() {
        Assertions.assertThrows(IllegalStateException.class, () -> {
            orderService.pay("order id");
        });
    }

    private Order getDefaultOrder(String orderId) {
        return new Order(
                orderId,
                LocalDateTime.of(2022, 2, 12, 12, 30, 40),
                List.of(new OrderItem(0, 0, null, 0)));
    }
}