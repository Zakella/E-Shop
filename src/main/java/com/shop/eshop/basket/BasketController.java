package com.shop.eshop.basket;

import com.shop.eshop.customer.CustomerRepository;
import com.shop.eshop.customer.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "api/v1/basket")
public class BasketController {

    private final BasketService basketService;
    private final BasketRepository basketRepository;


    public BasketController(BasketService basketService, BasketRepository basketRepository) {
        this.basketService = basketService;
        this.basketRepository = basketRepository;
    }

}
