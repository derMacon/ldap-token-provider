package com.dermacon.jwtauth.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.ldap.core.LdapTemplate;
import org.springframework.ldap.core.support.LdapContextSource;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class ConfigSettings {

    @Bean
    public PasswordEncoder encoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public LdapContextSource contextSource(){
        LdapContextSource contextSource = new LdapContextSource();
        contextSource.setUrl("ldap://ldap.forumsys.com:389/");
        contextSource.setBase("dc=example,dc=com");
        contextSource.setUserDn("cn=read-only-admin,dc=example,dc=com");
        contextSource.setPassword("password");
        return contextSource;
    }

    @Bean
    public LdapTemplate ldapTemplate(){
        return new LdapTemplate(contextSource());
    }

    @Bean
    public UserAttributeMapper userAttributeMapper() {
        return new UserAttributeMapper();
    }

}