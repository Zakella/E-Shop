package com.shop.eshop.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;

import java.util.concurrent.TimeUnit;

import static com.shop.eshop.security.ApplicationUserRole.ADMIN;
import static com.shop.eshop.security.ApplicationUserRole.USER;
import static org.springframework.security.config.Customizer.withDefaults;

@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class ApplicationSecurityConfig  {

    private final PasswordEncoder passwordEncoder;

    @Autowired
    public ApplicationSecurityConfig(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                //.csrf().csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse())
//                .and()
                .csrf().disable()
                .authorizeHttpRequests((authz) -> authz
                        .antMatchers("/","index","/css/*","/js/*").permitAll()
//                        .antMatchers("/api/**").hasRole(ADMIN.name())
                        .anyRequest()
                        .authenticated()
                )
                .httpBasic(withDefaults())
                 .formLogin()
                 .loginPage("/login").permitAll()
                .defaultSuccessUrl("/cabinet", true)
                .and()
                .rememberMe().tokenValiditySeconds((int) TimeUnit.DAYS.toSeconds(21))
                .key("somethingverysecured");

        return http.build();
    }

    @Bean
    public UserDetailsService userDetailsService(){
        UserDetails slavaUser = User.builder()
                .username("Slava")
                .password(passwordEncoder.encode("123"))
                .roles(ADMIN.name())
                .build();

        UserDetails mariaUser = User.builder()
                .username("Maria")
                .password(passwordEncoder.encode("123"))
                .roles(USER.name())
                .build();

        return new InMemoryUserDetailsManager(
                slavaUser , mariaUser) {

        };

    }
}
