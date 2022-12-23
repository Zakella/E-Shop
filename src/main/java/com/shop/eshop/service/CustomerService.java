package com.shop.eshop.service;

import com.shop.eshop.exception.NotFoundException;
import com.shop.eshop.model.Customer;
import com.shop.eshop.repository.CustomerRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {

    private static final Logger Logger = LoggerFactory.getLogger(CustomerService.class);
    private final CustomerRepository customerRepository;


    @Autowired
    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public List<Customer> findAll() {
        return customerRepository.findAll();
    }

    public Customer getCustomer(Long id){
        return customerRepository.
                findById(id)
                .orElseThrow(()->
                {
                    NotFoundException notFoundException = new NotFoundException("Customer width id " + id + " not found");
                    Logger.error("Error in customer width id {}", id);
                    return notFoundException;
                });
    }

    public Customer save(Customer customer) {
        return customerRepository.save(customer);
    }

    public void deleteById(Long id) {
        customerRepository.deleteById(id);
    }
}


