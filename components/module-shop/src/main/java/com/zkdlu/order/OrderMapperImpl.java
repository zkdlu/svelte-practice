package com.zkdlu.order;

import com.zkdlu.common.LocalDateTimeProvider;
import com.zkdlu.common.UuidProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class OrderMapperImpl implements OrderMapper{
    private final UuidProvider uuidProvider;
    private final LocalDateTimeProvider localDateTimeProvider;

    @Override
    public Order mapFrom(Cart cart) {
        return new Order(
                uuidProvider.randomUUID().toString(),
                cart.getTitle(),
                localDateTimeProvider.now(),
                cart.getTotalPrice(),
                cart.getTotalPrice()
        );
    }
}
