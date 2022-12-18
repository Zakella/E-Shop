package com.shop.eshop.controller;

import com.shop.eshop.model.Customer;
import com.shop.eshop.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RequestMapping(path = "api/v1/customers")
@RestController
public class CustomerController {
    private final CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping()
    List<Customer> getCustomers (){
        return this.customerService.getCustomers();
    }

    @GetMapping(path = "{id}")
    Customer getCustomer (@PathVariable ("id") Long id){
        return this.customerService.getCustomer(id);
    }

    @PostMapping()
    public void createCustomer(@Valid @RequestBody List <Customer> cList) {
        System.out.println("Post customer");
    }

    @PutMapping()
    public void updateCustomer(@Valid @RequestBody Customer customer) {
        System.out.println("Updating customer");
    }

    @DeleteMapping(path = "{id}")
    public void deleteCustomer(@PathVariable("id") Long id) {
        System.out.println("Deleting customer width" + id);
    }



}
