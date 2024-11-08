package ru.itmo.loveconnect.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.itmo.loveconnect.dto.GetRecommendationDto;
import ru.itmo.loveconnect.security.auth.principal.AuthenticatedUser;
import ru.itmo.loveconnect.service.RecommendationService;

import java.util.List;

@RestController
@RequestMapping("recommendations")
@RequiredArgsConstructor
public class RecommendationController {
    private final RecommendationService recommendationService;

    @GetMapping
    public ResponseEntity<List<GetRecommendationDto>> getRecommendations(@AuthenticationPrincipal AuthenticatedUser user,
                                                                         @RequestParam Short maxLastActiveDays,
                                                                         @RequestParam Integer numberOfUsers) {
        return ResponseEntity.ok(
                recommendationService.getRecommendationsByUserId(
                user.getUserId(),
                maxLastActiveDays,
                numberOfUsers)
        );
    }
}
