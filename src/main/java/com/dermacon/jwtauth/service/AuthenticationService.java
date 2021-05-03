package com.dermacon.jwtauth.service;

import com.dermacon.jwtauth.data.Credentials;
import com.dermacon.jwtauth.response.JWTTokenResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class AuthenticationService {

    @Autowired
    private LdapService ldapService;

    @Autowired
    private JwtTokenService jwtTokenService;

    public JWTTokenResponse generateJWTToken(Credentials credentials) {
        User user = ldapService.findUser(credentials);
        return new JWTTokenResponse(jwtTokenService.generateToken(user));
    }

}
