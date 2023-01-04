package com.shop.eshop.basket;

import com.shop.eshop.customer.Customer;
import com.shop.eshop.product.Product;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BasketService {

    private Customer customer;

    private Product product;

    private Basket basket;

    private BasketRepository basketRepository;

    public BasketService(BasketRepository basketRepository) {
        this.basketRepository = basketRepository;
    }


    public void setCustomer(Customer customer){
        this.basket.setCustomer(customer);
        this.basketRepository.save(this.basket);
    }


    public void addProduct(Product product) {
        List<Product> products = this.basket.getProducts();
        products.add(product);
        this.basketRepository.save(this.basket);
    }

    public void removeProduct(Product product) {
        List<Product> products = this.basket.getProducts();
        products.remove(product);
        this.basketRepository.save(this.basket);
    }

}
