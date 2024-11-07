package ru.itmo.loveconnect.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.itmo.loveconnect.dto.GetReactionDto;
import ru.itmo.loveconnect.dto.PostReactionDto;
import ru.itmo.loveconnect.entity.LikeEntity;
import ru.itmo.loveconnect.entity.UserEntity;
import ru.itmo.loveconnect.entity.enums.LikeType;
import ru.itmo.loveconnect.repo.ReactionRepository;
import ru.itmo.loveconnect.service.ReactionService;
import ru.itmo.loveconnect.service.UserService;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ReactionServiceImpl implements ReactionService {

    private ReactionRepository reactionRepository;
    private UserService userService;

    @Override
    public List<GetReactionDto> getAllUserLikes(final UUID userId) {
        return reactionRepository.getAllUserLikes(userId);
    }

    @Override
    public LikeEntity saveReaction(final UUID userId, final PostReactionDto userReaction) {
        final UserEntity likedByUser = userService.getUserById(userId);
        final UserEntity likedUser = userService.getUserById(userReaction.getLikedUserId());

        final Optional<LikeEntity> reactionFromDB =
                reactionRepository.findByLikedAndLikedBy(likedByUser.getId(), likedUser.getId());

        final LikeEntity likeEntity = reactionFromDB.orElseGet(LikeEntity::new);
        likeEntity.setLiked(likedUser);
        likeEntity.setLikedBy(likedByUser);
        likeEntity.setLikedTime(LocalDateTime.now());
        likeEntity.setType(userReaction.getType());
        likeEntity.setViewed(null);
        if (LikeType.LIKE.equals(userReaction.getType())) {
            likeEntity.setMessage(userReaction.getMessage());
        }
        return reactionRepository.save(likeEntity);
    }
}
