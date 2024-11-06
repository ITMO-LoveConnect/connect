package ru.itmo.loveconnect.service;

import ru.itmo.loveconnect.entity.UserEntity;

import java.util.List;
import java.util.UUID;

public interface RecomendationService {
    List<UserEntity> getRecomendationsByUserId(UUID userId, int numberOfUsers);
}
