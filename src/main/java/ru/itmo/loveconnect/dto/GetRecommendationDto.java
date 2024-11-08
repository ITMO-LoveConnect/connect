package ru.itmo.loveconnect.dto;

import lombok.Value;
import ru.itmo.loveconnect.entity.FacultyEntity;
import ru.itmo.loveconnect.entity.ProfileEntity;
import ru.itmo.loveconnect.entity.UserSocialNetworkEntity;
import ru.itmo.loveconnect.entity.enums.AlcoholPreference;
import ru.itmo.loveconnect.entity.enums.DatingPurpose;
import ru.itmo.loveconnect.entity.enums.Gender;
import ru.itmo.loveconnect.entity.enums.PhysicalActivity;
import ru.itmo.loveconnect.entity.enums.RelationshipStatus;
import ru.itmo.loveconnect.entity.enums.SmokePreference;
import ru.itmo.loveconnect.entity.mapper.ProfileMapper;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

/**
 * DTO for {@link ru.itmo.loveconnect.entity.UserEntity}
 */
@Value
public class GetRecommendationDto {
    UUID id;
    LocalDateTime lastActive;
    ProfileDto profile;
}