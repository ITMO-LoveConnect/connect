package ru.itmo.loveconnect.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface FilterRepository extends JpaRepository<FilterRepository, UUID> {
}
