package com.shop.eshop.payment;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.UUID;

@Entity()
//@Table(name = "payments")
public class Payment {

    @Id
    @GeneratedValue

    private Long paymentID;

    private Long customerId;

    private BigDecimal amount;

    private Currency currency;

//    @Column(name = "cardnumber")
    private String source;

    private String description;

    public Payment(Long paymentID, Long customerId, BigDecimal amount,
                   Currency currency, String source, String description) {
        this.paymentID = paymentID;
        this.customerId = customerId;
        this.amount = amount;
        this.currency = currency;
        this.source = source;
        this.description = description;
    }

    public Payment() {
    }

    public Long getPaymentID() {
        return paymentID;
    }

    public void setPaymentID(Long paymentID) {
        this.paymentID = paymentID;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public Currency getCurrency() {
        return currency;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
