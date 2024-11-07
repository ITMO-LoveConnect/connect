package ru.itmo.loveconnect.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.itmo.loveconnect.entity.FacultyEntity;

import java.util.UUID;

public interface FacultyRepository extends JpaRepository<FacultyEntity, UUID> {
}
