package ru.itmo.loveconnect.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.itmo.loveconnect.entity.UserEntity;

import java.util.UUID;

public interface UserRepository extends JpaRepository<UserEntity, UUID> {
}