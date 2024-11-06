package ru.itmo.loveconnect.entity;

import io.hypersistence.utils.hibernate.type.json.JsonType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.Type;
import org.springframework.data.jpa.domain.AbstractPersistable;
import ru.itmo.loveconnect.entity.enums.DatingPurpose;

import java.util.List;
import java.util.UUID;

@Getter
@Setter
@ToString
@Entity
@Table(name = "profile")
public class ProfileEntity extends AbstractPersistable<UUID> {

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "avatar_url")
    private String avatarUrl;

    @Type(JsonType.class)
    @Column(columnDefinition = "jsonb")
    private List<String> photos;

    @Column(name = "age", nullable = false)
    private Short age;

    @ManyToOne
    @JoinColumn(name = "faculty_id")
    private FacultyEntity faculty;

    @Column(name = "course")
    private Short course;

    @Column(name = "about")
    private String about;

    @Enumerated(EnumType.STRING)
    @Column(name = "dating_purpose", nullable = false)
    private DatingPurpose datingPurpose;

    @OneToMany(mappedBy = "profile")
    @ToString.Exclude
    private List<UserSocialNetworkEntity> socialNetworks;
}
