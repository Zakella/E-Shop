package com.shop.eshop.service;

import com.shop.eshop.exception.NotFoundException;
import com.shop.eshop.model.Customer;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class CustomerService {

    public List <Customer> getCustomers(){
        return  Arrays.asList(
                new Customer(1L, "Zapolschi", "Veaceslav", "079244444", "zapolski.slava@gmail.com", "123"),
                new Customer(2L, "Joe", "Doe", "1898989898", "joe.doe@gmail.com", "345")
                );
    }

    public Customer getCustomer(Long id){
        return this.getCustomers()
                .stream()
                .filter(customer -> customer.getId().equals(id))
                .findFirst()
                .orElseThrow(()->new NotFoundException("Customer width id " + id + " not found"));

    }

}
