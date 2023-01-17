package com.shop.eshop.customer;

import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(path = "api/v1/customers-registration")
public class CustomerRegistrationController {


    @PutMapping
    public void registerNewCustomer(@Valid @RequestBody CustomerRegistrationRequest customerRegistrationRequest){
        System.out.println(customerRegistrationRequest );


    }
}
