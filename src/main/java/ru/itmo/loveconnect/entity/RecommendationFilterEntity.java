package ru.itmo.loveconnect.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.jpa.domain.AbstractPersistable;
import ru.itmo.loveconnect.entity.enums.Gender;

import java.time.LocalDate;
import java.util.UUID;

@Getter
@Setter
@ToString
@Entity
@Table(name = "recommendation_filter")
public class RecommendationFilterEntity extends AbstractPersistable<UUID> {

    @Column(name = "min_birth_day")
    private LocalDate minBirthDay;

    @Column(name = "max_birth_day")
    private LocalDate maxBirthDay;

    @Column(name = "preferred_gender")
    private Gender preferredGender;
}
