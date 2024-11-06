package ru.itmo.loveconnect.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.jpa.domain.AbstractPersistable;
import ru.itmo.loveconnect.entity.enums.LikeType;

import java.util.UUID;

@Getter
@Setter
@ToString
@Entity
@Table(name = "like")
public class LikeEntity extends AbstractPersistable<UUID> {

    @ManyToOne
    @JoinColumn(name = "liked_id")
    private UserEntity liked;

    @ManyToOne
    @JoinColumn(name = "liked_by_id")
    private UserEntity likedBy;

    private LikeType type;

}
