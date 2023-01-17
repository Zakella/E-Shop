package com.shop.eshop.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

import java.time.ZonedDateTime;

@AllArgsConstructor
@Getter

public class ApiException  {
    private final String message;
    private final HttpStatus httpStatus;
    private final ZonedDateTime timestamp ;

}
