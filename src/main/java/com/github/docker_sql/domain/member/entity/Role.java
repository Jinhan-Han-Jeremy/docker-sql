package com.github.docker_sql.domain.member.entity;


import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Collectors;

@RequiredArgsConstructor
public enum Role {
    USER(Arrays.asList("ROLE_USER")),
    ADMIN(Arrays.asList("ROLE_USER", "ROLE_ADMIN"));

    @Getter
    private final Collection<String> roles;

    public Collection<? extends GrantedAuthority> getAuthorities() {
        return roles.stream().map(SimpleGrantedAuthority::new).collect(Collectors.toList());
    }
}