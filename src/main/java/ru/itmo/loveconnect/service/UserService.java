package ru.itmo.loveconnect.service;

import ru.itmo.loveconnect.entity.UserEntity;

import java.util.UUID;

public interface UserService {

    UserEntity getUserById(final UUID id);

    UserEntity getUserByLogin(final String login);
}
