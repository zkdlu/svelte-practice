package com.zkdlu.payment;

public class SpyPaymentService implements PaymentService {
    public String pay_argumentOrderId;

    @Override
    public void pay(String orderId) {
        pay_argumentOrderId = orderId;
    }
}
