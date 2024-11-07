package ru.itmo.loveconnect.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.itmo.loveconnect.dto.GetRecommendationDto;
import ru.itmo.loveconnect.service.RecommendationService;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("recommendations")
@RequiredArgsConstructor
public class RecommendationController {

    private final RecommendationService recommendationService;

    @GetMapping()
    public ResponseEntity<List<GetRecommendationDto>> getRecommendations(@RequestParam Short maxLastActiveDays,
                                                                         @RequestParam Integer numberOfUsers) {
        UUID userId = getCurrentUserId();
        return ResponseEntity.ok(
                recommendationService.getRecommendationsByUserId(
                userId,
                maxLastActiveDays,
                numberOfUsers)
        );
    }

    private UUID getCurrentUserId() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String userIdStr = authentication.getName(); // Используйте getName, если userId — это subject
        return UUID.fromString(userIdStr);
    }
}
