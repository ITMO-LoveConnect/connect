package ru.itmo.loveconnect.service.impl;

import java.util.*;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import ru.itmo.loveconnect.entity.ProfileEntity;
import ru.itmo.loveconnect.entity.UserEntity;
import ru.itmo.loveconnect.repo.ProfileRepository;
import ru.itmo.loveconnect.service.ProfileService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProfileServiceImpl implements ProfileService {
    private final ProfileRepository profileRepository;

    @Override
    public ProfileEntity getProfile(String uuid) {
        return profileRepository.findById(UUID.fromString(uuid)).orElseThrow();
    }

    @Override
    public void updateProfile(String uuid, ProfileEntity updatedProfile) {
        ProfileEntity toUpdate = profileRepository.getReferenceById(UUID.fromString(uuid));
        BeanUtils.copyProperties(updatedProfile, toUpdate);
        profileRepository.save(toUpdate);
    }
}
