package com.shop.eshop.payment;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;


@SpringBootApplication
public interface CardPayment {

    CardPaymentCharge chargeCard(
            String cardSource,
            BigDecimal amount,
            Currency currency,
            String description
    );
}
