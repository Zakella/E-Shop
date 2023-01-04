package com.shop.eshop.basket;

import com.shop.eshop.customer.Customer;
import com.shop.eshop.product.Product;
import org.springframework.beans.factory.annotation.Qualifier;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "Basket")
//@Table(name = "basket",
//        uniqueConstraints = {
//        @UniqueConstraint(name = "basket_customer_unique", columnNames = {customerID})
//        })

@Table(name = "basket")

public class Basket {

    @Id
//    @SequenceGenerator(name = "sequence_basket",
//            sequenceName = "sequence_basket",
//            allocationSize = 1)
    // @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence_basket")

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false)
    private Long id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "customer_id",
            referencedColumnName = "id",
            foreignKey = @ForeignKey(name = "customer_id_fk"))
    private Customer customer;

    @OneToMany(mappedBy = "basket",
            cascade = CascadeType.ALL,
            orphanRemoval = true,
            fetch = FetchType.EAGER)//подтягивает все продукты корзины
    private final List<Product> products = new ArrayList<>();

    public Basket() {
    }

    public Long getId() {
        return id;
    }


    public Customer getCustomer() {
        return customer;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}
