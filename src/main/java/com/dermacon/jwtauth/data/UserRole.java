package com.dermacon.jwtauth.data;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import static com.dermacon.jwtauth.data.ApplicationUserPermission.*;

public enum UserRole {
    ROLE_ANONYMOUS(),
    ROLE_USER(APP_READ),
    ROLE_MANAGER(APP_READ, APP_WRITE),
    ROLE_ADMIN(APP_READ, APP_WRITE, APP_READ, APP_WRITE);

    private final Set<ApplicationUserPermission> permissions;

    UserRole(ApplicationUserPermission... permissions) {
        this.permissions = new HashSet<>(Arrays.asList(permissions));
    }

    public Set<ApplicationUserPermission> getPermissions() {
        return permissions;
    }
}