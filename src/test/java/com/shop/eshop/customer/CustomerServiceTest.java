package com.shop.eshop.customer;

import com.shop.eshop.customer.Customer;
import com.shop.eshop.customer.CustomerRepository;
import com.shop.eshop.customer.CustomerService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)

class CustomerServiceTest {

    private CustomerService underTest;
    @Test
    void itShouldSaveCustomer() {
        //Given
        Customer customer = new Customer("Slava", "Zapolschi", "79294106",
               "zapolski@gmail.com", "123");
        //When
       underTest.saveCustomer(customer);

        //Then

        Optional<Customer> optionalCustomer = underTest.getCustomerByName("Slava");
        assertThat(optionalCustomer).isPresent();

    }



//
//    @Autowired
//    private CustomerRepository customerRepository;
//
//    @BeforeEach
//    void setUp() {
//        underTest = new CustomerService(customerRepository);
//    }
//
//    @AfterEach
//    void tearDown() {
//        customerRepository.deleteAll();
//    }
//
//    @Test
//    void findAll() {
//
//        Customer Slava = new Customer("Slava", "Zapolschi", "79294106",
//                "zapolski@gmail.com", "123");
//
//        Customer Maria = new Customer("Maria", "Zapolschi", " 79294106",
//                "zapolski@gmail.com", "123");
//
//        customerRepository.saveAll(Arrays.asList(Slava, Maria));
//
//        List<Customer> customers = underTest.findAll();
//        assertEquals(2, customers.size());
//
//
//    }
//
//    @Test
//    void getCustomer() {
//
//        Customer Slava = new Customer("Slava", "Zapolschi", "79294106",
//                "zapolski@gmail.com", "123");
//
//        customerRepository.save(Slava);
//
//        Customer customer = underTest.getCustomer(1L);
//        assertEquals("Slava", customer.getName());
//        assertEquals("Zapolschi", customer.getLastname());
//        assertEquals("79294106", customer.getPhone());
//        assertEquals("zapolski@gmail.com", customer.getEmail());
//
//    }
}