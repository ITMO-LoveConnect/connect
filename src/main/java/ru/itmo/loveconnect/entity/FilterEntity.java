package ru.itmo.loveconnect.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
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
@Table(name = "filter")
public class FilterEntity extends AbstractPersistable<UUID> {

    @Column(name = "min_age")
    private Short minAge;

    @Column(name = "max_age")
    private Short maxAge;

    @Column(name = "preferred_gender1", nullable = false)
    private Gender preferredGender1;

    // Обязательно занулять второй gender, если его нет!
    @Enumerated(EnumType.STRING)
    @Column(name = "preferred_gender2", nullable = true)
    private Gender preferredGender2;
}
