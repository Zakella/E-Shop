package com.shop.eshop.customer;

import com.shop.eshop.exception.NotValidData;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

@Service
public class CustomerValidator {

   List<Gender> GENDERS = Arrays.asList(Gender.Female, Gender.Male);

    public CustomerValidator() {
        // TODO document why this constructor is empty
    }



    public void validateCustomerBeforeSaving(Customer customer) {

        this.validateName(customer.getName());
        this.validateName(customer.getLastName());
        this.validateName(customer.getPatronymic());
        this.validateGender(customer.getGender());
        this.validatePhone(customer.getPhone());
        this.ValidateDateOfBirth(customer.getDateOfBirth());


    }

    private void validateGender(Gender gender) {

        if (!GENDERS.contains(gender)){
            throw new NotValidData(
                    String.format("not valid gender %s!", gender.name()));
        }
    }


    private void ValidateDateOfBirth(String dateOfBirth) {

        if (dateOfBirth == null) {
            throw new NotValidData("date can not be null!");
        }

        if (patternMatches(dateOfBirth, "^(0[1-9]|[12][0-9]|3[01])-(0[1-9]|1[012])-[0-9]{4}$")) {
            throw new NotValidData(
                    String.format("invalid format date %s, must be \"dd-mm-yyy\"!", dateOfBirth));
        }

    }


    public void validateName(String name) {

        if (name == null) {
            throw new NotValidData("name can not be null!");
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
            throw new NotValidData("phone can be null!");
        }

        String regexPattern = "^\\d{0,9}$";

        if (patternMatches(phone, regexPattern)) {
            throw new NotValidData(
                    String.format("invalid phone number %s !", phone));
        }

    }


    public static boolean patternMatches(String value, String regexPattern) {
        return !Pattern.compile(regexPattern)
                .matcher(value)
                .matches();
    }

}
