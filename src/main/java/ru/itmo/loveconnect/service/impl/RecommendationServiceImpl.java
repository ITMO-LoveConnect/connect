package ru.itmo.loveconnect.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.itmo.loveconnect.dto.GetRecommendationDto;
import ru.itmo.loveconnect.entity.UserEntity;
import ru.itmo.loveconnect.entity.mapper.ProfileMapper;
import ru.itmo.loveconnect.repo.UserRepository;
import ru.itmo.loveconnect.service.RecommendationService;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class RecommendationServiceImpl implements RecommendationService {

    private final UserRepository userRepository;
    private final ProfileMapper profileMapper;

    public List<GetRecommendationDto> getRecommendationsByUserId(UUID userId, Short maxLastActiveDays, int numberOfUsers) {
        LocalDateTime maxLastActive = LocalDateTime.now().minusDays(maxLastActiveDays);
        List<UserEntity> users = userRepository.getRecommendationsByUserId(userId, maxLastActive, numberOfUsers);
        return users.stream()
                .map(user -> new GetRecommendationDto(
                        user.getId(),
                        user.getLastActive(),
                        profileMapper.toDto(user.getProfile())
                ))
                .collect(Collectors.toList());
    }
}
