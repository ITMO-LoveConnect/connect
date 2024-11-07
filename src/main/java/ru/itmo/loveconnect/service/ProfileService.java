package ru.itmo.loveconnect.service;

import java.util.*;

import ru.itmo.loveconnect.entity.ProfileEntity;
import ru.itmo.loveconnect.entity.UserEntity;

public interface ProfileService {
    ProfileEntity getProfile(String uuid);

    @Deprecated
    UUID createProfile(ProfileEntity entity, UserEntity user);

    void updateProfile(String uuid, ProfileEntity entity);
}
