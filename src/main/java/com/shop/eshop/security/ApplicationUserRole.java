package com.shop.eshop.security;

import com.google.common.collect.Sets;

import java.util.Set;

import static com.shop.eshop.security.ApplicationUserPermission.CUSTOMER_READ;
import static com.shop.eshop.security.ApplicationUserPermission.CUSTOMER_WRITE;

public enum ApplicationUserRole {
    ADMIN(Sets.newHashSet(
            CUSTOMER_READ,
            CUSTOMER_WRITE
    )),
    USER (Sets.newHashSet());

    private final Set<ApplicationUserPermission> permissions;

    ApplicationUserRole(Set<ApplicationUserPermission> permissions) {
        this.permissions = permissions;
    }
}
