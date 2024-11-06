package ru.itmo.loveconnect.entity;

import io.hypersistence.utils.hibernate.type.json.JsonType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.Type;
import org.springframework.data.jpa.domain.AbstractPersistable;
import ru.itmo.loveconnect.entity.enums.profile.DatingPurpose;
import ru.itmo.loveconnect.entity.enums.profile.Gender;
import ru.itmo.loveconnect.entity.enums.profile.AlcoholPreference;
import ru.itmo.loveconnect.entity.enums.profile.PhysicalActivity;
import ru.itmo.loveconnect.entity.enums.profile.RelationshipStatus;
import ru.itmo.loveconnect.entity.enums.profile.SmokePreference;

import java.util.List;
import java.util.Set;
import java.util.UUID;

@Getter
@Setter
@ToString
@Entity
@Table(name = "profile")
public class ProfileEntity extends AbstractPersistable<UUID> {

    @Column(name = "name", nullable = false)
    private String name;

    @Enumerated(EnumType.STRING)
    @Column(name = "gender", nullable = false)
    private Gender gender;

    @Column(name = "avatar_url")
    private String avatarUrl;

    @Type(JsonType.class)
    @Column(columnDefinition = "jsonb")
    private List<String> photos;

    @Column(name = "age")
    private Short age;

    @Column(name = "height")
    private Short height;

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

    @Enumerated(EnumType.STRING)
    private RelationshipStatus relationshipStatus;

    @Enumerated(EnumType.STRING)
    private AlcoholPreference alcoholPreference;

    @Enumerated(EnumType.STRING)
    private SmokePreference smokePreference;

    @Enumerated(EnumType.STRING)
    private PhysicalActivity physicalActivity;

    @ManyToMany
    @JoinTable(
            name = "profile_tag",  // Название промежуточной таблицы
            joinColumns = @JoinColumn(name = "profile_id"),  // Колонка для profile
            inverseJoinColumns = @JoinColumn(name = "tag_id")  // Колонка для tag
    )
    private Set<TagEntity> tags;

    @OneToMany(mappedBy = "profile")
    @ToString.Exclude
    private List<UserSocialNetworkEntity> socialNetworks;
}
