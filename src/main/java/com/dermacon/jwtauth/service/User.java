package com.dermacon.jwtauth.service;

import com.dermacon.jwtauth.data.UserRole;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
@Builder
public class User implements Serializable {
    private String username;
    private String email;
    private UserRole role = UserRole.ROLE_USER;
}