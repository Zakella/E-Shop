package com.shop.eshop.payment;

import com.shop.eshop.payment.CardPaymentCharge;
import com.shop.eshop.payment.Currency;

import java.math.BigDecimal;

public interface CardPaymentCharger {

    CardPaymentCharge chargeCard(
            String cardSource,
            BigDecimal amount,
            Currency currency,
            String description
    );
}