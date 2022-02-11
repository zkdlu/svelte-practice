package com.zkdlu.order;

import com.zkdlu.common.UuidProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;


@RequiredArgsConstructor
@RestController
@RequestMapping("/orders")
public class OrderApi {
    private final UuidProvider uuidProvider;

    @PostMapping
    public ResponseEntity placeOrder(@RequestBody OrderRequest orderRequest) {
        var order = new Order(
                uuidProvider.randomUUID(),
                "치킨이 두마리",
                LocalDateTime.of(2022, 2, 12, 12, 30, 40),
                10000,
                10000);

        return new ResponseEntity(order, HttpStatus.CREATED);
    }
}
