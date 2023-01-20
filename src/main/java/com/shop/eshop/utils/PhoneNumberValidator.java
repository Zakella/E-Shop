package com.shop.eshop.utils;

import java.util.function.Predicate;

public class PhoneNumberValidator implements Predicate<String> {

    @Override
    public boolean test(String phoneNumber) {
        if (phoneNumber.startsWith("+373")){
            return true;
        }
        return false;
    }

}
