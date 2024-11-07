package ru.itmo.loveconnect.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ru.itmo.loveconnect.dto.FacultyDto;
import ru.itmo.loveconnect.dto.GetRecommendationDto;
import ru.itmo.loveconnect.dto.UserSocialNetworkDto;
import ru.itmo.loveconnect.entity.UserEntity;
import ru.itmo.loveconnect.entity.enums.AlcoholPreference;
import ru.itmo.loveconnect.entity.enums.DatingPurpose;
import ru.itmo.loveconnect.entity.enums.Gender;
import ru.itmo.loveconnect.entity.enums.PhysicalActivity;
import ru.itmo.loveconnect.entity.enums.RelationshipStatus;
import ru.itmo.loveconnect.entity.enums.SmokePreference;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface UserRepository extends JpaRepository<UserEntity, UUID> {

    @Query("SELECT u FROM UserEntity u " +
            "JOIN FETCH u.profile p " +
            "JOIN u.recommendationFilter f " +
            "LEFT JOIN LikeEntity r ON r.liked = u AND r.likedBy.id = :userId " +
            "WHERE r.id IS NULL " + // Пользователь не был лайкнут userId
            "    AND (function('AGE', :timeNow, u.lastActive) < :maxLastActiveDays) " + // Фильтрация по времени активности
            "    AND (f.preferredGender IS NULL OR p.gender = f.preferredGender) " + // Фильтрация по предпочтению пола
            "    AND p.age BETWEEN f.minAge AND f.maxAge " + // Фильтрация по возрасту
            "ORDER BY u.lastActive DESC " + // Сортировка по времени последней активности
            "LIMIT :numberOfUsers")
    List<UserEntity> getRecommendationsByUserId(@Param("userId") UUID userId,
                                                          @Param("timeNow") LocalDateTime timeNow,
                                                          @Param("maxLastActiveDays") Short maxLastActiveDays,
                                                          @Param("numberOfUsers") int numberOfUsers);

    Optional<UserEntity> findByIsuNumber(final String isuNumber);
}