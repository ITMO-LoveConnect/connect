package ru.itmo.loveconnect.controller;

import org.springframework.http.HttpStatus;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import ru.itmo.loveconnect.dto.ProfileDto;
import ru.itmo.loveconnect.entity.ProfileEntity;
import ru.itmo.loveconnect.entity.UserEntity;
import ru.itmo.loveconnect.entity.mapper.ProfileMapper;
import ru.itmo.loveconnect.security.auth.principal.AuthenticatedUser;
import ru.itmo.loveconnect.service.ProfileService;
import ru.itmo.loveconnect.service.UserService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/profile")
public class ProfileController {
    private final ProfileMapper mapper;
    private final ProfileService profileService;

    @GetMapping("/{uuid}")
    public ProfileDto getProfile(@PathVariable("uuid") String uuid) {
        return mapper.toDto(profileService.getProfile(uuid));
    }

    @PatchMapping("/{uuid}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void updateProfile(@PathVariable("uuid") String uuid, @RequestBody ProfileDto profileDto) {
        ProfileEntity updatedEntity = mapper.toEntity(profileDto);
        profileService.updateProfile(uuid, updatedEntity);
    }
}
