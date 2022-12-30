package com.shop.eshop.basket;

import com.shop.eshop.customer.Customer;
import com.shop.eshop.product.Product;
import org.springframework.beans.factory.annotation.Qualifier;

import javax.persistence.*;

@Entity(name = "Basket")
//@Table(name = "basket",
//        uniqueConstraints = {
//        @UniqueConstraint(name = "basket_customer_unique", columnNames = {customerID})
//        })

@Table (name = "basket")

public class Basket {

    @Id
    @SequenceGenerator(name = "sequence_basket",
            sequenceName = "sequence_basket",
            allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence_basket")

    @Column(name ="id", updatable = false)
    private Long id;

    @OneToOne()
    @JoinColumn(name = "id")
    private Customer customer;

//    private Product product;


//    private

}
