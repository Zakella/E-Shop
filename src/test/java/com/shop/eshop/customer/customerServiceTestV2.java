package com.shop.eshop.customer;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;
import static org.mockito.Mockito.never;

class customerServiceTestV2 {

    private CustomerService underTest;

    @Mock
    private CustomerRepository customerRepository;

    @Captor
    private ArgumentCaptor<Customer> customerArgumentCaptor;


    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        this.underTest = new CustomerService(customerRepository);
    }

    @Test
    void itShouldSaveNewCustomer() {
        //given
        String phone = "79294106";
        Customer customer = new Customer("Slava", "Zapolschi", phone,
                "zapolski@gmail.com", "123");

        CustomerRegistrationRequest request = new CustomerRegistrationRequest(customer);

        given(customerRepository.findCustomerByPhone(phone))
                .willReturn(Optional.empty());

        //when
        underTest.registerNewCustomer(request);

        //then
        then(customerRepository).should().save(customerArgumentCaptor.capture());
        Customer customerArgumentCaptorValue = customerArgumentCaptor.getValue();

        assertThat(customerArgumentCaptorValue).isEqualTo(customer);

    }

    @Test
    void itShouldNotSaveCustomerIfExists() {
        //Given
        String phone = "79294106";
        Customer customer = new Customer("Slava", "Zapolschi", phone,
                "zapolski@gmail.com", "123");

        CustomerRegistrationRequest request = new CustomerRegistrationRequest(customer);

        given(customerRepository.findCustomerByPhone(phone))
                .willReturn(Optional.of(customer));


        //When
        underTest.registerNewCustomer(request);
        //Then
        then(customerRepository).should(never()).save(any());

    }

    @Test
    void itShouldThrownWhenPhoneIsTaken() {
        //Given
        String phone = "79294106";
        Customer customer = new Customer("Slava", "Zapolschi", phone,
                "zapolski@gmail.com", "123");

        Customer customerTwo = new Customer("Maria", "Zapolschi", phone,
                "zapolski@gmail.com", "123");
        CustomerRegistrationRequest request = new CustomerRegistrationRequest(customer);

        given(customerRepository.findCustomerByPhone(phone))
                .willReturn(Optional.of(customerTwo));

        //When

        //Then


        assertThatThrownBy(() -> underTest.registerNewCustomer(request))
                .isInstanceOf(IllegalStateException.class)
                .hasMessageContaining(String.format("Phone number %s is taken", phone));

        then(customerRepository).should(never()).save(any(Customer.class));

    }
}