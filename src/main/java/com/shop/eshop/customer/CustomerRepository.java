package com.shop.eshop.customer;

import com.shop.eshop.customer.Customer;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.swing.text.html.Option;
import java.util.Optional;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

  @Query("select c from customers c where c.phone = ?1 ")
  Optional <Customer> findCustomerByPhone(String phone);

  @Query("select c from customers c where c.email = ?1")
  Optional <Customer> findCustomerByEmail(String email);



}
