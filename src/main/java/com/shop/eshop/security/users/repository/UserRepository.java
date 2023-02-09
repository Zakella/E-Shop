package com.shop.eshop.security.users.repository;

import com.shop.eshop.security.users.model.UserData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserData, Long> {
    UserData findByEmail(String email);
}
