package ru.itmo.loveconnect.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.jpa.domain.AbstractPersistable;
import ru.itmo.loveconnect.entity.enums.SocialNetworkType;

import java.util.UUID;

@Getter
@Setter
@ToString
@Entity
@Table(
        name = "user_social_network",
        uniqueConstraints = {
            @UniqueConstraint(
                    columnNames = {"user", "type"},
                    name = "user_social_network_user_id_type_unq")
        })
public class UserSocialNetworkEntity extends AbstractPersistable<UUID> {

    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserEntity user;

    private SocialNetworkType type;

    private String profileId;
}
