package com.shop.eshop.payment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/payment")
public class PaymentController {

    @Autowired
    private final PaymentService  paymentService;

    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @RequestMapping()
    public void makePayment(@RequestBody PaymentRequest paymentRequest){
        Long customerId = paymentRequest.getPayment().getCustomerId();
        paymentService.chargeCard(customerId, paymentRequest);

    }
}
