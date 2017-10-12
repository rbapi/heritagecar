package com.entiros.springbootrestapiprojects.oauth.service;


import com.entiros.springbootrestapiprojects.oauth.model.Payment;

public interface PaymentService {
    Iterable<Payment> listAllPayments();

    Payment getPaymentById(String id);

    Payment savePayments(Payment payment);

    void deletePaymentById(String PaymentId);
}
