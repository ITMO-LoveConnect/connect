package ru.itmo.loveconnect.dto;

import lombok.Value;
import ru.itmo.loveconnect.entity.enums.profile.AlcoholPreference;
import ru.itmo.loveconnect.entity.enums.profile.DatingPurpose;
import ru.itmo.loveconnect.entity.enums.profile.Gender;
import ru.itmo.loveconnect.entity.enums.profile.PhysicalActivity;
import ru.itmo.loveconnect.entity.enums.profile.RelationshipStatus;
import ru.itmo.loveconnect.entity.enums.profile.SmokePreference;

import java.util.List;
import java.util.UUID;

/**
 * DTO for {@link ru.itmo.loveconnect.entity.ProfileEntity}
 */
@Value
public class ProfileDto {
    UUID id;
    String name;
    Gender gender;
    String avatarUrl;
    List<String> photos;
    Short age;
    FacultyDto faculty;
    Short course;
    String about;
    DatingPurpose datingPurpose;
    List<UserSocialNetworkDto> socialNetworks;
    Short height;
    RelationshipStatus relationshipStatus;
    AlcoholPreference alcoholPreference;
    SmokePreference smokePreference;
    PhysicalActivity physicalActivity;
}