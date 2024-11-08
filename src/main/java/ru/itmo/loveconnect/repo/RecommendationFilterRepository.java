package ru.itmo.loveconnect.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.itmo.loveconnect.entity.RecommendationFilterEntity;

import java.util.UUID;

public interface RecommendationFilterRepository extends JpaRepository<RecommendationFilterEntity, UUID> {
}
