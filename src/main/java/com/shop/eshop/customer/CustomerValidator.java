package com.shop.eshop.customer;

import org.springframework.stereotype.Service;

@Service
public class CustomerValidator {

    private Customer customer;

    public CustomerValidator(Customer customer) {
        this.customer = customer;
    }

    //    public void validateName(){
//        String name = customer.getName();
//    };

}
