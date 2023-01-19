package com.shop.eshop.customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(path = "api/v1/customers-registration")
public class CustomerRegistrationController {

    @Autowired
    private final CustomerService customerService;

    public CustomerRegistrationController(CustomerService customerService) {
        this.customerService = customerService;
    }


    @PutMapping
    public void registerNewCustomer(@Valid @RequestBody CustomerRegistrationRequest customerRegistrationRequest){
        this.customerService.registerNewCustomer(customerRegistrationRequest);
    }
}
