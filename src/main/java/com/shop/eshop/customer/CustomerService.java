package com.shop.eshop.customer;

import com.shop.eshop.exception.NotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    public void saveCustomers(List <Customer> customers){
        customerRepository.saveAll(customers);
    }

    public void deleteById(Long id) {
        customerRepository.deleteById(id);
    }

    public Customer getCustomerByEmail(String email){

        return customerRepository.
                findCustomerByEmail(email)
                .orElseThrow(()->
                {
                    NotFoundException notFoundException = new NotFoundException("Customer width id " + email + " not found");
                    Logger.error("Error in customer width email {}", email);
                    return notFoundException;
                });

    }

    public Customer getCustomerByPhone(String phone){

        return customerRepository.
                findCustomerByPhone(phone)
                .orElseThrow(()->
                {
                    NotFoundException notFoundException = new NotFoundException("Customer width id " + phone + " not found");
                    Logger.error("Error in customer width phone {}", phone);
                    return notFoundException;
                });

    }
}


