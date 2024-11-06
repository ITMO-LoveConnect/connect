package ru.itmo.loveconnect.dto;

import lombok.Value;

import java.time.OffsetDateTime;
import java.util.UUID;

/**
 * DTO for {@link ru.itmo.loveconnect.entity.UserEntity}
 */
@Value
public class UserDto {
    UUID id;
    String isuNumber;
    String email;
    boolean verified;
    OffsetDateTime lastLogin;
    OffsetDateTime lastActive;
    OffsetDateTime archived;
}