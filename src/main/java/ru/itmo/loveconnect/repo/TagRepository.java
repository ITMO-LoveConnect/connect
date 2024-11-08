package ru.itmo.loveconnect.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.itmo.loveconnect.entity.TagEntity;

import java.util.Optional;
import java.util.UUID;

public interface TagRepository extends JpaRepository<TagEntity, UUID> {
    Optional<TagEntity> findByName(String name);
}
