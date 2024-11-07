package ru.itmo.loveconnect.dto;

import lombok.Value;
import ru.itmo.loveconnect.entity.enums.LikeType;

import java.time.LocalDateTime;
import java.util.UUID;

@Value
public class PostReactionDto {
    UUID likedUserId;
    LikeType type;
    String message;
    LocalDateTime viewed;
}
