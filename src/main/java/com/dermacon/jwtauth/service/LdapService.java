package com.dermacon.jwtauth.service;

import com.dermacon.jwtauth.config.UserAttributeMapper;
import com.dermacon.jwtauth.data.Credentials;
import com.dermacon.jwtauth.exception.CredentialsException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ldap.core.LdapTemplate;
import org.springframework.ldap.filter.AndFilter;
import org.springframework.ldap.filter.EqualsFilter;
import org.springframework.stereotype.Service;

@Service
public class LdapService {

    @Autowired
    private LdapTemplate ldapTemplate;

    @Autowired
    private UserAttributeMapper userAttributeMapper;

    public User findUser(Credentials credentials) {
        AndFilter filter = new AndFilter();
        filter.and(new EqualsFilter("uid", credentials.getUsername()));
        filter.and(new EqualsFilter("objectclass", "person"));

        boolean authenticated = ldapTemplate.authenticate("",
                filter.toString(),
                credentials.getPassword());

        if (!authenticated) {
            throw new CredentialsException();
        }

        return (User) ldapTemplate
                .search("", filter.encode(), userAttributeMapper)
                .get(0);
    }

}
