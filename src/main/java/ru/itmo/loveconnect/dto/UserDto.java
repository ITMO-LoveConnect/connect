package ru.itmo.loveconnect.dto;

import lombok.Value;

import java.time.LocalDateTime;
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
    LocalDateTime lastLogin;
    LocalDateTime lastActive;
    LocalDateTime archived;
}