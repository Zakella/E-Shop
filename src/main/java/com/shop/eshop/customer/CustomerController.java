package com.shop.eshop.customer;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RequestMapping(path = "api/v1/customers")
@RestController
public class CustomerController {

    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @PostMapping()
    public void createCustomer(@Valid @RequestBody Customer customer) {
        this.customerService.saveCustomer( customer);
    }
}
