package ru.itmo.loveconnect.dto;

import lombok.Value;
import ru.itmo.loveconnect.entity.enums.userSocialNetwork.SocialNetworkType;

import java.util.UUID;

/**
 * DTO for {@link ru.itmo.loveconnect.entity.UserSocialNetworkEntity}
 */
@Value
public class UserSocialNetworkDto {
    UUID id;
    SocialNetworkType type;
    String profileId;
}