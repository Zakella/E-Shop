package com.shop.eshop.security.users.service;

import com.shop.eshop.security.users.dto.UserRegistrationDto;
import com.shop.eshop.security.users.model.Role;
import com.shop.eshop.security.users.model.UserData;
import com.shop.eshop.security.users.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.Arrays;

@AllArgsConstructor
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;


    @Override
    public User save(UserRegistrationDto registrationDto) {
      UserData user =  UserData.builder()
                .firstname(registrationDto.getFirstName())
                .lastname(registrationDto.getLastName())
                .email(registrationDto.getEmail())
                .password( passwordEncoder.encode(registrationDto.getPassword()))
                .build();

        userRepository.save(user);
        return null;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return null;
    }
}
