package com.shop.eshop.service;

import com.shop.eshop.model.Customer;
import com.shop.eshop.repository.CustomerRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class CustomerServiceTest {

    private CustomerService underTest;

    @Autowired
    private CustomerRepository customerRepository;

    @BeforeEach
    void setUp() {
        underTest = new CustomerService(customerRepository);
    }

    @AfterEach
    void tearDown() {
        customerRepository.deleteAll();
    }

    @Test
    void findAll() {

        Customer Slava = new Customer("Slava", "Zapolschi", "79294106",
                "zapolski@gmail.com", "123");

        Customer Maria = new Customer("Maria", "Zapolschi", " 79294106",
                "zapolski@gmail.com", "123");

        customerRepository.saveAll(Arrays.asList(Slava, Maria));

        List<Customer> customers = underTest.findAll();
        assertEquals(2, customers.size());


    }

    @Test
    void getCustomer() {

        Customer Slava = new Customer("Slava", "Zapolschi", "79294106",
                "zapolski@gmail.com", "123");

        customerRepository.save(Slava);

        Customer customer = underTest.getCustomer(1L);
        assertEquals("Slava", customer.getName());
        assertEquals("Zapolschi", customer.getLastName());
        assertEquals("79294106", customer.getPhone());
        assertEquals("zapolski@gmail.com", customer.getEmail());



    }
}