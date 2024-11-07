package ru.itmo.loveconnect.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.jpa.domain.AbstractPersistable;
import ru.itmo.loveconnect.entity.enums.LikeType;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@ToString
@Entity
@Table(
        name = "reaction",
        uniqueConstraints = {@UniqueConstraint(columnNames = {"liked", "likedBy"})})
public class LikeEntity extends AbstractPersistable<UUID> {

    @ManyToOne
    @JoinColumn(name = "liked_id")
    private UserEntity liked;

    @ManyToOne
    @JoinColumn(name = "liked_by_id")
    private UserEntity likedBy;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private LikeType type;

    private String message;

    private LocalDateTime viewed;

    @Column(name = "liked_time", nullable = false)
    private LocalDateTime likedTime;
}
