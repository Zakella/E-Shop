package com.shop.eshop.security.basic_auth;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class BasicAuthenticationConfig {

//    public SecurityConfig(JpaUserDetailsService myUserDetailsService) {
//        this.myUserDetailsService = myUserDetailsService;
//    }
    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http
                .csrf().disable()
                .authorizeHttpRequests((authz) -> authz
                        .requestMatchers("/","index","/css/*","/js/*").permitAll()
                        .anyRequest().authenticated()
                )
//                .userDetailsService(myUserDetailsService)
//                .headers(headers -> headers.frameOptions().sameOrigin())
                .httpBasic(withDefaults())
                .formLogin()
                .loginPage("/login").permitAll()
                .defaultSuccessUrl("/cabinet", true)
                .and()
                .build();
    }


}
