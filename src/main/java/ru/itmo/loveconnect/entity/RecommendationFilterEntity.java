package ru.itmo.loveconnect.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.jpa.domain.AbstractPersistable;
import ru.itmo.loveconnect.entity.enums.Gender;

import java.util.UUID;

@Getter
@Setter
@ToString
@Entity
@Table(name = "recommendation_filter")
public class RecommendationFilterEntity extends AbstractPersistable<UUID> {

    @Column(name = "min_age")
    private Short minAge;

    @Column(name = "max_age")
    private Short maxAge;

    @Column(name = "preferred_gender", nullable = true)
    private Gender preferredGender;
}
