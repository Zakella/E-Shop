package com.shop.eshop.customer;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.stereotype.Service;


public class CustomerRegistrationRequest {

    private Customer customer;


    public CustomerRegistrationRequest(@JsonProperty("customer") Customer customer) {
        this.customer = customer;
    }

    public Customer getCustomer() {
        return customer;
    }

}
