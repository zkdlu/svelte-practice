package com.zkdlu.payment;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/payment")
public class PaymentApi {
    private final PaymentService paymentService;

    @PostMapping("{orderId}")
    public void pay(@PathVariable String orderId) {
        paymentService.pay(orderId);
    }
}
