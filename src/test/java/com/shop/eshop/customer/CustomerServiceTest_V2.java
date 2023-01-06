package com.shop.eshop.customer;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.*;

class CustomerServiceTest_V2 {

    private CustomerService underTest;

    @Mock
    private CustomerRepository customerRepository;
    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        this.underTest = new CustomerService(customerRepository);
    }

    @Test
    void itShouldSaveNewCustomer() {
        //given
        Customer customer = new Customer("Slava", "Zapolschi", "79294106",
                "zapolski@gmail.com", "123");

        //when
        //then

    }
}