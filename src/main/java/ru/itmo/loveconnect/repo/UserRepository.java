package ru.itmo.loveconnect.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ru.itmo.loveconnect.entity.UserEntity;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface UserRepository extends JpaRepository<UserEntity, UUID> {

    @Query(value = "SELECT u FROM UserEntity u " +
            "JOIN FETCH u.profile p " +
            "JOIN u.recommendationFilter f " +
            "LEFT JOIN LikeEntity r ON r.liked = u AND r.likedBy.id = :userId " +
            "WHERE r.id IS NULL " + // Пользователь не был лайкнут userId
            "    AND u.lastActive > :maxLastActive " +
            "    AND (f.preferredGender IS NULL OR p.gender = f.preferredGender) " + // Фильтрация по предпочтению пола
            "    AND (EXTRACT(year from function('AGE', p.birthDay)) BETWEEN f.minAge AND f.maxAge)" + // Фильтрация по возрасту
            "ORDER BY u.lastActive DESC " + // Сортировка по времени последней активности
            "LIMIT :numberOfUsers")
    List<UserEntity> getRecommendationsByUserId(@Param("userId") UUID userId,
                                                @Param("maxLastActive") LocalDateTime maxLastActive,
                                                @Param("numberOfUsers") int numberOfUsers);

    Optional<UserEntity> findByIsuNumber(final String isuNumber);
}
