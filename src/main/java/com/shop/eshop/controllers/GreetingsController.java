package com.shop.eshop.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api/v1/greetings")
@RestController
public class GreetingsController {


    @GetMapping
    public ResponseEntity<String> sayHello(){
        return ResponseEntity.ok("hello world!");
    }

    @GetMapping("/goodbye")
    public ResponseEntity<String> sayGoodbye(){
        return ResponseEntity.ok("goodbye!");
    }


}
