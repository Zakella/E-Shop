package com.shop.eshop.customer;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class CustomerValidatorTest {

    CustomerValidator underTest;


    @BeforeEach
    void setUp() {

        this.underTest = new CustomerValidator();
    }


    @Test
    void itShouldThrowExceptionInvalidNameWhenNameIsToBig() {

        //Given
        List<Customer> customers = List.of(
                new Customer("JonJonyJonzZoooooooooooJonJonyJonzZoooooooooooJonJonyJonzZoooooooooooJonJonyJonzZooooooooooo", "Lop",
                        "14778787878", "joe@gmail.com", "454545"),
                new Customer("Jon", "JonJonyJonzZoooooooooooJonJonyJonzZoooooooooooJonJonyJonzZoooooooooooJonJonyJonzZooooooooooo",
                        "14778787878", "joe@gmail.com", "454545")
        );

        //When

        //Then
        customers.forEach(this::throwValidationException);

    }

    @Test
    void itShouldCheckLatinSymbolsOnly() {
        //Given
        List<Customer> customers = List.of(
                new Customer("Cлава", "Lop",
                        "079222222", "joe@gmail.com", "454545"),
                new Customer("JoeИРР", "Doe",
                        "079222223", "joe@gmail.com", "454545"),
                new Customer("Slava", "Доу",
                        "079222223", "joe@gmail.com", "454545"),
                new Customer("Jony", "DoeТест",
                        "079222223", "joe@gmail.com", "454545"),
                new Customer("Joe1", "Lop",
                        "14778787878", "joe@gmail.com", "454545"),
                new Customer("Joe1", "2Dany1",
                        "14778787878", "joe@gmail.com", "454545"),
                new Customer("Joe", "2Dany1",
                        "14778787878", "joe@gmail.com", "454545"),
                new Customer(null, "2Dany1",
                        "14778787878", "joe@gmail.com", "454545"),
                new Customer("Joe", null,
                        "14778787878", "joe@gmail.com", "454545")
        );


        //When

        //Then
        customers.forEach(this::throwValidationException);

    }

    @Test
    void itShouldPassAll() {
        //Given

        List<Customer> customers = List.of(
                new Customer("Joe", "Doe",
                        "07929107", "joe@gmail.com", "454545"),
                new Customer("Lisaaaa", "Brooo",
                        "061029934", "doe@gmail.com", "454545")
        );

        //When
        //Then
        customers.forEach(this::doesNotThrow);

    }

    void throwValidationException(Customer customer) {


        assertThatThrownBy(() ->
                this.underTest.startValidation(customer))
                .isInstanceOf(IllegalStateException.class);
    }

    void doesNotThrow(Customer customer) {

        CustomerValidator customerValidator = new CustomerValidator();
        assertDoesNotThrow(
                () -> customerValidator.startValidation(customer)
        );
    }

    @Test
    void itShouldThrowExceptionWhenPhoneIsNotValid() {
        //Given
        List<Customer> customers = List.of(
                new Customer("Joe", "Doe",
                        "14778787878", "joe@gmail.com", "454545"),
                new Customer("Lisaaaa", "Brooo",
                        "czz048787887", "joe@gmail.com", "454545"),
                new Customer("Lisaaaa", "Brooo",
                        null, "joe@gmail.com", "454545")
        );
        //When

        //Then

        customers.forEach(this::throwValidationException);

    }

    @Test
    void itShouldThrowExceptionIfEmailIsInvalid() {
        //Given
        List<Customer> customers = List.of(
                new Customer("", "",
                        "", "joegmail.com", ""),
                new Customer("", "",
                        "", "joegmailcom", ""),

                new Customer("", "",
                        "", null, "")
        );
        //When
        //Then
        customers.forEach(this::throwValidationException);

    }

    @Test
    void itShouldTest() {
        //Given
        
        //When
        //Then

    }
}