package ru.itmo.loveconnect.service.impl;

import org.springframework.stereotype.Service;
import ru.itmo.loveconnect.entity.UserEntity;
import ru.itmo.loveconnect.repo.UserRepository;
import ru.itmo.loveconnect.service.RecomendationService;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Service
public class RecomendationServiceImpl implements RecomendationService {

    private final UserRepository userRepository;

    public RecomendationServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<UserEntity> getRecomendationsByUserId(UUID userId, int numberOfUsers) {
        LocalDateTime timeNow = LocalDateTime.now();
        return userRepository.getRecomendationsByUserId(userId, timeNow, numberOfUsers);
    }
}
