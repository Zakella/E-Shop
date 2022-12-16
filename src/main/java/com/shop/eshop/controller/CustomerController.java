package com.shop.eshop.controller;

import com.shop.eshop.model.Customer;
import com.shop.eshop.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomerController {
    private final CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("/client")
    Customer getCustomer (){
        return this.customerService.getCustomer();
    }

//    @GetMapping("/client")
//    Customer getCustomer (){
////        return "!";
//        return new Customer(1L, "Zapolschi", "Veaceslav", "079244444", "zapolski.slava@gmail.com");
//    }
//

}
