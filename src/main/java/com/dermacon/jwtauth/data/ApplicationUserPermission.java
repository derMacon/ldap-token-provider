package com.dermacon.jwtauth.data;

public enum ApplicationUserPermission {
    APP_READ("person:read"),
    APP_WRITE("person:write");

    private final String permission;

    ApplicationUserPermission(String permission) {
        this.permission = permission;
    }

    public String getPermission() {
        return permission;
    }
}