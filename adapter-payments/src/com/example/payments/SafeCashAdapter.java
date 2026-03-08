package com.example.payments;

public class SafeCashAdapter implements PaymentGateway {

    private final SafeCashClient client;

    public SafeCashAdapter(SafeCashClient client) {
        this.client = client;
    }

    @Override
    public String charge(String custId, int amountCents) {
        SafeCashPayment payment = client.createPayment(amountCents, custId);
        return payment.confirm();
    }
}