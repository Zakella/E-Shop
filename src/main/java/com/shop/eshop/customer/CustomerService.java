package com.shop.eshop.customer;

import com.shop.eshop.exception.NotFoundException;
import com.shop.eshop.fakeData.FakeCustomers;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
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
        Sort sort = Sort.by((Sort.Direction.ASC), "name");//сортировка по возврастанию
        return customerRepository.findAll(sort);
    }

    public Customer getCustomer(Long id) {
        return customerRepository.
                findById(id)
                .orElseThrow(() ->
                {
                    NotFoundException notFoundException = new NotFoundException("Customer width id " + id + " not found");
                    Logger.error("Error in customer width id {}", id);
                    return notFoundException;
                });
    }

    public Customer save(Customer customer) {
        return customerRepository.save(customer);
    }

    public void saveCustomers(List<Customer> customers) {
        customerRepository.saveAll(customers);
    }

    public void deleteById(Long id) {
        customerRepository.deleteCustomerById(id);
    }

    public Customer getCustomerByEmail(String email) {

        return customerRepository.
                findCustomerByEmail(email)
                .orElseThrow(() ->
                {
                    NotFoundException notFoundException = new NotFoundException("Customer width id " + email + " not found");
                    Logger.error("Error in customer width email {}", email);
                    return notFoundException;
                });

    }

    public Customer getCustomerByPhone(String phone) {

        return customerRepository.
                findCustomerByPhone(phone)
                .orElseThrow(() ->
                {
                    NotFoundException notFoundException = new NotFoundException("Customer width id " + phone + " not found");
                    Logger.error("Error in customer width phone {}", phone);
                    return notFoundException;
                });

    }

    public void generateCustomers() {
        FakeCustomers fakeCustomers = new FakeCustomers(this.customerRepository);
        fakeCustomers.generateRandomCustomers();

    }

    public Page  pageCustomers() {//изучить потом подробнее, пагинация
        PageRequest pageRequest = PageRequest.of(0,
                5,
                Sort.by("name").ascending()
        );
        Page<Customer> page =customerRepository.findAll(pageRequest);
        return page;

    }

}


