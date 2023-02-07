package com.shop.eshop.security.user.auth;

import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

import static com.shop.eshop.security.basicAuth.ApplicationUserRole.ADMIN;
import static com.shop.eshop.security.basicAuth.ApplicationUserRole.USER;

@Repository("fake")
public class FakeApplicationDaoUserService implements ApplicationUserDao{

    private final PasswordEncoder passwordEncoder;

    @Autowired
    public FakeApplicationDaoUserService(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public Optional<ApplicationUser> selectApplicationUserByUserName(String username) {
        return getApplicationUsers().stream()
                .filter(applicationUser -> username.equals(applicationUser.getUsername()))
                .findFirst();
    }

    private List<ApplicationUser> getApplicationUsers(){
        List<ApplicationUser> applicationUsers = Lists.newArrayList(
                new ApplicationUser(
                        ADMIN.getGrantedAuthorities(),
                        this.passwordEncoder.encode("456"),
                        "Slava",
                        true,
                        true,
                        true,
                        true
                        ),

                new ApplicationUser(
                        USER.getGrantedAuthorities(),
                        this.passwordEncoder.encode("456"),
                        "Maria",
                        true,
                        true,
                        true,
                        true
                )

        );

        return applicationUsers;
    }
}
