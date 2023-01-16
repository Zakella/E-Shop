package com.shop.eshop.customer;

import com.shop.eshop.exception.NotValidData;
import org.springframework.stereotype.Service;

import java.util.regex.Pattern;

@Service
public class CustomerValidator {

    public CustomerValidator() {
        // TODO document why this constructor is empty
    }

    public void validateCustomerBeforeSaving(Customer customer) {

        this.validateName(customer.getName());
        this.validateName(customer.getLastName());
        this.validateName(customer.getPatronymic());
        this.validateGender(customer.getPatronymic());
        this.validatePhone(customer.getPhone());
        this.ValidateDateOfBirth(customer.getDateOfBirth());

    }


    private void ValidateDateOfBirth(String dateOfBirth) {

    }

    private void validateGender(String patronymic) {

    }


    public void validateName(String name) {

        if (name == null) {
            throw new NotValidData("name can be null!");
        }

        if (name.length() > 50) {
            throw new NotValidData(
                    String.format("name %s is invalid! To long!", name));
        }


        if (patternMatches(name, "[A-Za-z]+")) {
            throw new NotValidData(
                    String.format("name %s must be in latin letters only!", name));
        }

    }

    public void validatePhone(String phone) {

        if (phone == null) {
            throw new IllegalStateException("phone can be null!");
        }

        String regexPattern = "^\\d{0,9}$";

        if (patternMatches(phone, regexPattern)) {
            throw new IllegalStateException(
                    String.format("invalid phone number %s is valid!", phone));
        }

    }


    public static boolean patternMatches(String value, String regexPattern) {
        return !Pattern.compile(regexPattern)
                .matcher(value)
                .matches();
    }

}
