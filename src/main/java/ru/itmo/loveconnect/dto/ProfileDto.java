package ru.itmo.loveconnect.dto;

import lombok.*;
import lombok.experimental.FieldDefaults;
import ru.itmo.loveconnect.entity.enums.AlcoholPreference;
import ru.itmo.loveconnect.entity.enums.DatingPurpose;
import ru.itmo.loveconnect.entity.enums.Gender;
import ru.itmo.loveconnect.entity.enums.PhysicalActivity;
import ru.itmo.loveconnect.entity.enums.RelationshipStatus;
import ru.itmo.loveconnect.entity.enums.SmokePreference;

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