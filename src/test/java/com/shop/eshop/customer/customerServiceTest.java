package com.shop.eshop.customer;

import com.shop.eshop.exception.NotFoundException;
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

class customerServiceTest {

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

    @Test
    void itShouldReturnCustomerNumber() {
        //Given
        String phone = "079294106";
        Customer customer = new Customer("Slava", "Zapolschi", "079294106",
                "zapolski@gmail.com", "123");

        given(customerRepository.findCustomerByPhone(phone)).willReturn(Optional.of(customer));
        //When
        Customer customerByPhone = underTest.getCustomerByPhone(phone);
        //Then
        assertThat(phone).isEqualTo(customerByPhone.getPhone());


    }


    @Test
    void itShouldThrowNotFoundExceptionWhenPhoneNotFound() {
        //Given
        String phone = "079294107";
        given(customerRepository.findCustomerByPhone(phone)).willReturn(Optional.empty());

        //When

        //Then
        assertThatThrownBy(() -> underTest.getCustomerByPhone(phone))
                .isInstanceOf(NotFoundException.class)
                .hasMessageContaining(String.format("Customer width id %s not found", phone));
    }

    @Test
    void itShouldReturnCustomerByEmailOrTrowException() {
        //Given

        String email = "zapolski@gmail.com";
        Customer customer = new Customer("Slava", "Zapolschi", "079294106",
                "zapolski@gmail.com", "123");

        given(customerRepository.findCustomerByEmail(email)).willReturn(Optional.of(customer));
        //When

        Optional<Customer> customerByEmail = customerRepository.findCustomerByEmail(email);

        //Then

        assertThat(email).isEqualTo(customerByEmail
                .get().getEmail());


    }

    @Test
    void itShouldThrowExceptionWhenEmailNotFound() {

        String email = "zapolski@gmail.com";
        given(customerRepository.findCustomerByEmail(email)).willReturn(Optional.empty());

        //When

        //Then
        assertThatThrownBy(() -> underTest.getCustomerByEmail(email))
                .isInstanceOf(NotFoundException.class)
                .hasMessageContaining(String.format("Customer width id %s not found", email));

    }
}