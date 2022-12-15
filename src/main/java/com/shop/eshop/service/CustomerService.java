package com.shop.eshop.service;

import com.shop.eshop.model.Customer;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {


    public Customer getCustomer(){
        return new Customer(1l, "Zapolschi", "Veaceslav", "079244444", "zapolski.slava@gmail.com");
    }

}
