package com.shop.eshop.customer;

import com.shop.eshop.customer.Customer;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.swing.text.html.Option;
import javax.transaction.Transactional;
import java.util.Optional;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

    @Query("SELECT c FROM customers c WHERE c.phone = ?1 ")
    Optional<Customer> findCustomerByPhone(String phone);

    @Query("SELECT c FROM customers c WHERE c.email = :email")
//так тоже можно
    Optional<Customer> findCustomerByEmail(@Param("email") String email);

    @Transactional
    @Modifying // указывает на то что не надо возвращать сущность, а только модифицировать ее в базе данных ;
    @Query("DELETE FROM customers c WHERE c.id = ?1")
    void deleteCustomerById(Long id);


}
