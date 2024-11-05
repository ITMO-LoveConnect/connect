package ru.itmo.loveconnect.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.jpa.domain.AbstractPersistable;

import java.time.OffsetDateTime;
import java.util.UUID;

@Getter
@Setter
@ToString
@Entity
@Table(name = "app_user")
public class UserEntity extends AbstractPersistable<UUID> {

    private String isuNumber;

    private String email;

    @Column(nullable = false)
    private Boolean verified = false;

    private OffsetDateTime lastLogin;

    private OffsetDateTime lastActive;

    private OffsetDateTime archived;

    @OneToOne
    @JoinColumn(name = "profile_id")
    private ProfileEntity profile;
}
