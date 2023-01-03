package com.shop.eshop.fakeData;

import com.github.javafaker.Faker;
import com.shop.eshop.basket.Basket;
import com.shop.eshop.basket.BasketRepository;
import com.shop.eshop.customer.Customer;
import com.shop.eshop.customer.CustomerRepository;
import com.shop.eshop.customer.CustomerService;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class FakeCustomers {


    private final CustomerRepository customerRepository;
//    private final BasketRepository basketRepository;

    public FakeCustomers(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }



    public void generateRandomCustomers() {
        Faker faker = new Faker();

        List<Customer> customerList = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            String name = faker.name().firstName();
            String lastname = faker.name().lastName();
            String email = String.format("%s.%s@gmail.com", name, lastname);
            Customer customer = new Customer(
                    name,
                    lastname,
                    String.valueOf(faker.number().numberBetween(7, 1000000)),
                    email,
                    "some pass");

//            Basket basket = new Basket(customer);
//            customerRepository.save(customer);

            customerList.add(customer);
            System.out.println(customer);


        }
       customerRepository.saveAll(customerList);

    }
}
