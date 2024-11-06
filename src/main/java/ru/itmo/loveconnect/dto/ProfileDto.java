package ru.itmo.loveconnect.dto;

import lombok.Value;
import ru.itmo.loveconnect.entity.enums.DatingPurpose;

import java.util.List;
import java.util.UUID;

/**
 * DTO for {@link ru.itmo.loveconnect.entity.ProfileEntity}
 */
@Value
public class ProfileDto {
    UUID id;
    String name;
    String avatarUrl;
    List<String> photos;
    Short age;
    FacultyDto faculty;
    Short course;
    String about;
    DatingPurpose datingPurpose;
    List<UserSocialNetworkDto> socialNetworks;
}