package ru.itmo.loveconnect.service;

import ru.itmo.loveconnect.dto.GetRecommendationDto;

import java.util.List;
import java.util.UUID;

public interface RecommendationService {
    List<GetRecommendationDto> getRecommendationsByUserId(UUID userId, Short maxLastActiveDays, int numberOfUsers);
}
