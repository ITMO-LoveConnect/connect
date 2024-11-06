package ru.itmo.loveconnect.security.jwt;

import org.springframework.security.authentication.AbstractAuthenticationToken;
import ru.itmo.loveconnect.security.auth.principal.AuthenticatedUser;

import java.util.List;

public final class AuthenticatedUserAuthenticationToken extends AbstractAuthenticationToken {

    private final AuthenticatedUser user;

    public AuthenticatedUserAuthenticationToken(AuthenticatedUser user) {
        super(List.of(CustomAuthority.USER));
        this.user = user;
    }

    @Override
    public AuthenticatedUser getCredentials() {
        return user;
    }

    @Override
    public AuthenticatedUser getPrincipal() {
        return user;
    }

}
