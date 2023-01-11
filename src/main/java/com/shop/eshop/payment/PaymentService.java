package com.shop.eshop.payment;
import com.shop.eshop.customer.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class PaymentService {

    private final CustomerRepository customerRepository;
    private final PaymentRepository paymentRepository;

    private final CardPayment cardPayment;

    @Autowired
    public PaymentService(CustomerRepository customerRepository,
                          PaymentRepository paymentRepository,
                          CardPayment cardPayment) {

        this.customerRepository = customerRepository;
        this.paymentRepository = paymentRepository;
        this.cardPayment = cardPayment;
    }

    void chargeCard(UUID customerId, Payment payment){

    }
}
