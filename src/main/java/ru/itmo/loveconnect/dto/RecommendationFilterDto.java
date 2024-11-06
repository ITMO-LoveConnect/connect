package ru.itmo.loveconnect.dto;

import lombok.Value;
import ru.itmo.loveconnect.entity.enums.profile.Gender;

import java.util.UUID;

/**
 * DTO for {@link ru.itmo.loveconnect.entity.RecommendationFilterEntity}
 */
@Value
public class RecommendationFilterDto {
    UUID id;
    Short minAge;
    Short maxAge;
    Gender preferredGender;
}
