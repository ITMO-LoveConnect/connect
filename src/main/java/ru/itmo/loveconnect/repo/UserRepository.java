package ru.itmo.loveconnect.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ru.itmo.loveconnect.entity.UserEntity;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

public interface UserRepository extends JpaRepository<UserEntity, UUID> {
    @Query(value =
            "SELECT u FROM app_user u " +
            "JOIN user_profiles p ON u.profile_id = p.id " +
            "JOIN filter f ON u.filter_id = f.id " +
            "LEFT JOIN reaction r ON r.liked_id = u.id AND r.liked_by_id = :userId " +
            "WHERE r.id IS NULL " +  // Пользователь не был лайкнут userId
            "WHERE AGE(:timeNow, last_active) last_active_period < INTERVAL '10 days' " +
            "AND (p.gender = f.preferred_gender1 OR (f.preferred_gender2 IS NOT NULL AND p.gender = f.preferred_gender2))" +
            "AND p.age BETWEEN f.minAge AND f.maxAge" +
            "ORDER BY last_active_period ASC" +
            "LIMIT :numberOfUsers",
            nativeQuery = true)
    List<UserEntity> getRecomendationsByUserId(@Param("userId") UUID userId,
                                               @Param("timeNow") LocalDateTime timeNow,
                                               @Param("numberOfUsers") int numberOfUsers);
}