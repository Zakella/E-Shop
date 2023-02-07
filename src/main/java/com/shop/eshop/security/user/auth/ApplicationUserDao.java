package com.shop.eshop.security.user.auth;

import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public interface ApplicationUserDao  {
     Optional<ApplicationUser> selectApplicationUserByUserName(String username);

}
