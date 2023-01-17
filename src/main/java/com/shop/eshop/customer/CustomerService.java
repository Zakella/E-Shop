package com.shop.eshop.customer;

import org.springframework.stereotype.Service;

@Service
public class CustomerService {

    private final CustomerRepository customerRepository;

    private final CustomerValidator customerValidator;

    public CustomerService(CustomerRepository customerRepository, CustomerValidator customerValidator) {
        this.customerRepository = customerRepository;
        this.customerValidator = customerValidator;
    }

    public void saveCustomer(Customer customer){
        this.customerValidator.validateCustomerBeforeSaving(customer);
        this.customerRepository.save(customer);

    }
}
