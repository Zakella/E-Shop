package com.shop.eshop.security.JWT.auth;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthenticationController {

  private final com.shop.eshop.security.JWT.auth.AuthenticationService service;

  @PostMapping("/register")
  public ResponseEntity<com.shop.eshop.security.JWT.auth.AuthenticationResponse> register(
      @RequestBody com.shop.eshop.security.JWT.auth.RegisterRequest request
  ) {
    return ResponseEntity.ok(service.register(request));
  }
  @PostMapping("/authenticate")
  public ResponseEntity<com.shop.eshop.security.JWT.auth.AuthenticationResponse> authenticate(
      @RequestBody com.shop.eshop.security.JWT.auth.AuthenticationRequest request
  ) {
    return ResponseEntity.ok(service.authenticate(request));
  }


}
