package ru.itmo.loveconnect.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.itmo.loveconnect.dto.GetRecommendationDto;
import ru.itmo.loveconnect.service.RecommendationService;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/recommendations")
@RequiredArgsConstructor
public class RecommendationController {

    private final RecommendationService recommendationService;

    @RequestMapping("/{userId}/{maxLastActiveDays}/{numberOfUsers}")
    public ResponseEntity<List<GetRecommendationDto>> getRecommendations(@PathVariable UUID userId,
                                                                         @PathVariable Short maxLastActiveDays,
                                                                         @PathVariable Integer numberOfUsers) {
        return ResponseEntity.ok(
                recommendationService.getRecommendationsByUserId(
                userId,
                maxLastActiveDays,
                numberOfUsers)
        );
    }
}
