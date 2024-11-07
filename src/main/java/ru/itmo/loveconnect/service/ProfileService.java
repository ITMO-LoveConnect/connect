package ru.itmo.loveconnect.service;

import java.util.*;

import ru.itmo.loveconnect.entity.ProfileEntity;

public interface ProfileService {
    ProfileEntity getProfile(String uuid);

    UUID createProfile(ProfileEntity entity);

    void updateProfile(String uuid, ProfileEntity entity);
}
