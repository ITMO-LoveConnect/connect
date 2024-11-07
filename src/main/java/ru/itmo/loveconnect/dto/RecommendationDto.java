package ru.itmo.loveconnect.dto;

import lombok.Value;

import java.time.LocalDateTime;
import java.util.UUID;

/**
 * DTO for {@link ru.itmo.loveconnect.entity.UserEntity}
 */
@Value
public class RecommendationDto {
    UUID id;
    LocalDateTime lastActive;
    ProfileDto profile;
}