package com.entiros.springbootrestapiprojects.oauth.service;

import com.entiros.springbootrestapiprojects.oauth.model.Consent;
import com.entiros.springbootrestapiprojects.oauth.model.Fund;
import com.entiros.springbootrestapiprojects.oauth.model.Payment;
import com.entiros.springbootrestapiprojects.oauth.repository.ConsentsRespository;
import com.entiros.springbootrestapiprojects.oauth.repository.PaymentsRespository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PaymentServiceImpl implements PaymentService {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    private PaymentsRespository paymentsRespository;

    @Override
    public Iterable<Payment> listAllPayments() {
        logger.debug("listAllPayments called");
        return paymentsRespository.findAll();
    }

    @Override
    public Payment getPaymentById(String id) {
        logger.debug("getPaymentById called");
        return paymentsRespository.findById(id);
    }

    @Override
    public Payment savePayments(Payment payment) {
        logger.debug("savePayment called");
        return paymentsRespository.save(payment);
    }

    @Override
    public void deletePaymentById(String paymentId) {
        logger.debug("deletePaymentById called");
        paymentsRespository.delete(paymentId);

    }
}
