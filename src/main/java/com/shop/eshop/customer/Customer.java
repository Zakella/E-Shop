package com.shop.eshop.customer;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity (name = "customers")
@Table(name = "customers")
public class Customer {

    @Id
//    @SequenceGenerator(name = "sequence_customer",
//            sequenceName = "sequence_customer",
//            allocationSize = 1)
//    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence_customer")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="id", updatable = false)
    private Long id;
    @NotBlank//запрещены пустые значения json
    @Column(nullable = false, columnDefinition = "TEXT")
    private  String name;

    @Column(name = "lastname", nullable = false, columnDefinition = "TEXT")
    private  String lastname;
//    @Digits(integer = 8, fraction = 0)
    private  String phone;
//    @Email(regexp = "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$", message = "email is not valid!")//валидация на почту
//    @NotBlank
//    @Column(nullable = false, columnDefinition = "TEXT")
    private  String email;
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private  String password;


    public Customer(String name, String lastName, String phone, String email, String password) {
        this.name = name;
        this.lastname = lastName;
        this.phone = phone;
        this.email = email;
        this.password = password;

    }

    public Customer() {}

    @JsonIgnore
    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getLastname() {
        return lastname;
    }

    public String getPhone() {
        return phone;
    }

//    @JsonProperty("e-mail")
    public String getEmail() {
        return email;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", lastName='" + lastname + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
