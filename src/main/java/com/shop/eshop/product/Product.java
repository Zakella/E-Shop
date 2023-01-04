package com.shop.eshop.product;

import com.shop.eshop.basket.Basket;

import javax.persistence.*;

@Entity(name = "Product")
@Table(name = "products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false)
    private Long id;

    @Column(nullable = false)
    private String name;

    private String description;

    @ManyToOne()
    @JoinColumn(
            name = "basket_id",
            referencedColumnName = "id",
            foreignKey = @ForeignKey(name = "product_id_fk")
    )
    private Basket basket;


    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public Basket getBasket() {
        return basket;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
