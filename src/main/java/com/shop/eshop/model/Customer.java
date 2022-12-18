package com.shop.eshop.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.Digits;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

public class Customer {

    private final Long id;
    @NotBlank//запрещены пустые значения
    private final String name;
    private final String lastName;
    @Digits(integer = 8, fraction = 0)
    private final String phone;
    @Email(regexp = "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$", message = "email is not valid!")//валидация на почту
    @NotBlank
    private final String email;
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private final String password;


    public Customer(Long id, String name, String lastName, String phone, String email, String password) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.phone = phone;
        this.email = email;
        this.password = password;
    }

    @JsonIgnore
    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPhone() {
        return phone;
    }

    @JsonProperty("e-mail")
    public String getEmail() {
        return email;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
