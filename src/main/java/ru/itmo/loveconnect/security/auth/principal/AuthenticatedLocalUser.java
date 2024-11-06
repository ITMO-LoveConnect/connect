package ru.itmo.loveconnect.security.auth.principal;

import lombok.Data;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;
import java.util.Map;
import java.util.UUID;

@Data
public class AuthenticatedLocalUser implements AuthenticatedUser {

    private UUID userId;
    private String email;
    private String isuNumber;
    private Collection<? extends GrantedAuthority> authorities;
    private Map<String, Object> attributes;

}