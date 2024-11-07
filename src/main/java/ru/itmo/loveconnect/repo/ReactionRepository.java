package ru.itmo.loveconnect.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ru.itmo.loveconnect.dto.GetReactionDto;
import ru.itmo.loveconnect.entity.LikeEntity;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ReactionRepository extends JpaRepository<LikeEntity, UUID> {

    @Query(
            value = "SELECT new ru.itmo.loveconnect.dto.GetReactionDto( "
                    + "     l1.likedBy.id,  "
                    + "     CASE  "
                    + "         WHEN (l2.id IS NOT NULL) THEN ru.itmo.loveconnect.entity.enums.LikeStatus.MUTUAL "
                    + "         ELSE ru.itmo.loveconnect.entity.enums.LikeStatus.RECEIVED "
                    + "     END, "
                    + "     l1.likedBy.profile.avatarUrl, "
                    + "     l1.viewed, "
                    + "     l1.likedTime "
                    + " ) "
                    + " FROM LikeEntity l1 "
                    + " LEFT JOIN LikeEntity l2  "
                    + "     ON l1.likedBy.id = l2.liked.id  "
                    + "     AND l1.liked.id = l2.likedBy.id "
                    + "     AND l2.type = 'LIKE' "
                    + " LEFT JOIN l1.likedBy.profile p "
                    + " WHERE l1.liked.id = :userId "
                    + "   AND l1.type = 'LIKE' "
                    + " ORDER BY l1.likedTime DESC")
    List<GetReactionDto> getAllUserLikes(final UUID userId);

    @Query(value = "select lk from LikeEntity lk where lk.liked.id = :likedId and lk.likedBy.id = :likedById")
    Optional<LikeEntity> findByLikedAndLikedBy(final UUID likedById, final UUID likedId);
}
