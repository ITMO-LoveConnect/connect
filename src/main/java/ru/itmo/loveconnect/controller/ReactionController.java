package ru.itmo.loveconnect.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.itmo.loveconnect.dto.GetReactionDto;
import ru.itmo.loveconnect.dto.GetReactionListDto;
import ru.itmo.loveconnect.dto.PostReactionDto;
import ru.itmo.loveconnect.entity.LikeEntity;
import ru.itmo.loveconnect.security.auth.principal.AuthenticatedUser;
import ru.itmo.loveconnect.service.ReactionService;

import java.util.List;

@RestController
@RequestMapping(path = "likes")
@RequiredArgsConstructor
public class ReactionController {

    private final ReactionService reactionService;

    @GetMapping
    ResponseEntity<GetReactionListDto> getAllLikes(@AuthenticationPrincipal final AuthenticatedUser user) {
        final List<GetReactionDto> allUserLikes = reactionService.getAllUserLikes(user.getUserId());
        return ResponseEntity.ok(new GetReactionListDto(allUserLikes));
    }

    @PostMapping
    ResponseEntity<LikeEntity> likeUser(
            @AuthenticationPrincipal final AuthenticatedUser user, final PostReactionDto reactionDto) {
        final LikeEntity reaction = reactionService.saveReaction(user.getUserId(), reactionDto);
        return ResponseEntity.ok(reaction);
    }
}
