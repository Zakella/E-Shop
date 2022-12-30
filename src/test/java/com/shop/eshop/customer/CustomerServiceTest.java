package com.shop.eshop.customer;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.*;

class CustomerServiceTest {

    @Autowired
    CustomerService underTest;

    @BeforeEach
    void setUp(CustomerService customerService) {
        this.underTest = customerService;
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void deleteById() {
        this.underTest.deleteById(1164l);
    }
}