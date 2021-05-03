package com.dermacon.jwtauth.exception;

public class CredentialsException extends RuntimeException {

    public CredentialsException() {
        this("Invalid Credentials");
    }

    public CredentialsException(String message) {
        super(message);
    }
}
