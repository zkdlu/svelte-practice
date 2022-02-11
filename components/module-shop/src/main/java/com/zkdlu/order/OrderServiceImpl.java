package com.zkdlu.order;

import com.zkdlu.common.UuidProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@RequiredArgsConstructor
@Service
public class OrderServiceImpl implements OrderService{
    private final UuidProvider uuidProvider;

    @Override
    public Order placeOrder(OrderRequest orderRequest) {
        return new Order(
                uuidProvider.randomUUID(),
                "치킨이 두마리",
                LocalDateTime.of(2022, 2, 12, 12, 30, 40),
                10000,
                10000);
    }
}
