package ru.itmo.loveconnect.service;

import ru.itmo.loveconnect.dto.GetReactionDto;
import ru.itmo.loveconnect.dto.PostReactionDto;
import ru.itmo.loveconnect.entity.LikeEntity;

import java.util.List;
import java.util.UUID;

public interface ReactionService {

    List<GetReactionDto> getAllUserLikes(final UUID userId);

    LikeEntity saveReaction(UUID userId, PostReactionDto userReaction);

}
