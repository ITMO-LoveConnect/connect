package ru.itmo.loveconnect.service.impl;

import org.springframework.stereotype.Service;
import ru.itmo.loveconnect.entity.UserEntity;
import ru.itmo.loveconnect.repo.UserRepository;
import ru.itmo.loveconnect.service.RecommendationService;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Service
public class RecommendationServiceImpl implements RecommendationService {

    private final UserRepository userRepository;

    public RecommendationServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<UserEntity> getRecommendationsByUserId(UUID userId, Short maxLastActiveDays, int numberOfUsers) {
        LocalDateTime timeNow = LocalDateTime.now();
        return userRepository.getRecommendationsByUserId(userId, timeNow, maxLastActiveDays, numberOfUsers);
    }
}
