package ru.itmo.loveconnect.service;

import ru.itmo.loveconnect.entity.UserEntity;

import java.util.List;
import java.util.UUID;

public interface RecommendationService {
    List<UserEntity> getRecommendationsByUserId(UUID userId, Short maxLastActiveDays, int numberOfUsers);
}
