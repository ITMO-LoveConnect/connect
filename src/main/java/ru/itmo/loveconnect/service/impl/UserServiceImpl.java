package ru.itmo.loveconnect.service.impl;

import lombok.RequiredArgsConstructor;
import org.hibernate.ObjectNotFoundException;
import org.springframework.stereotype.Service;
import ru.itmo.loveconnect.entity.UserEntity;
import ru.itmo.loveconnect.repo.UserRepository;
import ru.itmo.loveconnect.service.UserService;

import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public UserEntity getUserById(final UUID id) {
        final Optional<UserEntity> user = userRepository.findById(id);
        return user.orElseThrow(() -> new ObjectNotFoundException(id, UserEntity.class.getName()));
    }

    @Override
    public UserEntity getUserByLogin(final String login) {
        final Optional<UserEntity> user = userRepository.findByIsuNumber(login);
        return user.orElseThrow();
    }

    public Boolean isRegisteredByIsuNumber(String isuNumber) {
        return userRepository.findByIsuNumber(isuNumber).isPresent();
    }

}
