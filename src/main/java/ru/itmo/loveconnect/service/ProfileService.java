package ru.itmo.loveconnect.service;

import ru.itmo.loveconnect.entity.ProfileEntity;

public interface ProfileService {
    ProfileEntity getProfile(String uuid);

    void updateProfile(String uuid, ProfileEntity entity);
}
