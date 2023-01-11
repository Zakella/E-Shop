package com.shop.eshop.customer;

import org.springframework.stereotype.Service;

import java.util.regex.Pattern;

@Service
public class CustomerValidator {

    public CustomerValidator() {
        // TODO document why this constructor is empty
    }

    public void startValidation(Customer customer) {

        this.validateName(customer.getName());
        this.validateName(customer.getLastname());
        this.validatePhone(customer.getPhone());
        this.validateEmail(customer.getEmail());

    }


    public void validateName(String name) {

        if (name == null){
            throw new IllegalStateException("name can be null!");
        }

        if (name.length() > 50) {
            throw new IllegalStateException(
                    String.format("name %s is invalid! To long!", name));
        }


        if (patternMatches(name, "[A-Za-z]+")) {
            throw new IllegalStateException(
                    String.format("name %s must be in latin letters only!", name));
        }

    }

    public void validatePhone(String phone) {

        if (phone == null){
            throw new IllegalStateException("phone can be null!");
        }

        String regexPattern = "^\\d{0,9}$";

        if (patternMatches(phone, regexPattern)) {
            throw new IllegalStateException(
                    String.format("invalid phone number %s is valid!", phone));
        }

    }

    public void validateEmail(String email) {

        if (email == null){
            throw new IllegalStateException("email can be null!");
        }

        String isValidEmail = "^(?=.{1,64}@)[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*@"
                + "[^-][A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$";

        if (patternMatches(email, isValidEmail)) {
            throw new IllegalStateException(
                    String.format(String.format("invalid email %s is valid!", email)));
        }
        ;
    }

    public static boolean patternMatches(String value, String regexPattern) {
        return !Pattern.compile(regexPattern)
                .matcher(value)
                .matches();
    }

}
