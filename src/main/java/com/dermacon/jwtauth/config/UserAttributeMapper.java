package com.dermacon.jwtauth.config;

import com.dermacon.jwtauth.data.UserRole;
import com.dermacon.jwtauth.service.User;
import org.springframework.ldap.core.AttributesMapper;

import javax.naming.NamingException;
import javax.naming.directory.Attributes;

public class UserAttributeMapper implements AttributesMapper {

    public Object mapFromAttributes(Attributes attrs) throws NamingException {
        return User.builder()
                .username((String) attrs.get("uid").get())
                .email((String) attrs.get("mail").get())
                .role(UserRole.ROLE_USER)
                .build();
    }

}
