package ru.itmo.loveconnect.security.jwt;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;

@RequiredArgsConstructor
@Getter
public enum CustomAuthority implements GrantedAuthority {
    USER("user");

    private final String authority;
}
