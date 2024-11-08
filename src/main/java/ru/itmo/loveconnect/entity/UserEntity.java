package ru.itmo.loveconnect.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.jpa.domain.AbstractPersistable;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@ToString
@Entity
@Table(name = "app_user")
public class UserEntity extends AbstractPersistable<UUID> {

    @Column(name = "isu_number", unique = true)
    private String isuNumber;

    private String email;

    @Column(nullable = false)
    private Boolean verified = false;

    private LocalDateTime lastLogin;

    @Column(name = "last_active")
    private LocalDateTime lastActive;

    private LocalDateTime archived;

    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "profile_id")
    private ProfileEntity profile;

    @OneToOne
    @JoinColumn(name = "recommendation_filter_id")
    private RecommendationFilterEntity recommendationFilter;
}
