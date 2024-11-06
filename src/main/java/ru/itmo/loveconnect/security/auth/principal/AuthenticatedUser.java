package ru.itmo.loveconnect.security.auth.principal;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.UUID;

public interface AuthenticatedUser {

    @NotNull UUID getUserId();

    @Nullable String getEmail();

    @NotNull String getIsuNumber();

}
