package ru.itmo.loveconnect.dto;

import lombok.Value;
import ru.itmo.loveconnect.entity.enums.LikeStatus;

import java.time.LocalDateTime;
import java.util.UUID;

@Value
public class GetReactionDto {
    UUID likedById;
    LikeStatus likeStatus;
    String avatarUrl;
    LocalDateTime viewed;
    LocalDateTime likedTime;
}
