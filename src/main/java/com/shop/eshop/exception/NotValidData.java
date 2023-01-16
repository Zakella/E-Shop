package com.shop.eshop.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;


public class NotValidData extends RuntimeException{
    public NotValidData(String message) {
        super(message);
    }
}