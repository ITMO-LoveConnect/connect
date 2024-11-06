package ru.itmo.loveconnect.security.auth;

import org.springframework.stereotype.Service;
import ru.itmo.loveconnect.entity.UserEntity;
import ru.itmo.loveconnect.security.auth.principal.AuthenticatedLocalUser;
import ru.itmo.loveconnect.security.auth.principal.AuthenticatedUser;

import java.util.List;

@Service
public class UserToAuthenticatedUserMapper {

    public AuthenticatedUser map(UserEntity user) {
        AuthenticatedLocalUser localUser = new AuthenticatedLocalUser();
        localUser.setUserId(user.getId());
        localUser.setEmail(user.getEmail());
        localUser.setIsuNumber(user.getIsuNumber());

        localUser.setAuthorities(List.of());

        return localUser;
    }
}
