package com.shop.eshop.utils;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

public class PhoneNumberValidatorTest {

    private PhoneNumberValidator underTest;

    @BeforeEach
    void setUp() {
        underTest = new PhoneNumberValidator();
    }


    @DisplayName("Should fail when not valid")
    @ParameterizedTest
    @CsvSource({"+37379294107 , TRUE",
                "+17379294107, FALSE"} )
    void itShouldValidatePhoneNumber(String phoneNumber, boolean expected) {
        //Given
        //When
       boolean isValid =  underTest.test(phoneNumber);
        //Then

        assertThat(isValid).isEqualTo(expected);

    }
}
