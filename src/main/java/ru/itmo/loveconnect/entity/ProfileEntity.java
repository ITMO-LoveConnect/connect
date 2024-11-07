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
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.Type;
import org.springframework.data.jpa.domain.AbstractPersistable;
import ru.itmo.loveconnect.entity.enums.DatingPurpose;
import ru.itmo.loveconnect.entity.enums.Gender;
import ru.itmo.loveconnect.entity.enums.AlcoholPreference;
import ru.itmo.loveconnect.entity.enums.PhysicalActivity;
import ru.itmo.loveconnect.entity.enums.RelationshipStatus;
import ru.itmo.loveconnect.entity.enums.SmokePreference;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;
import java.util.UUID;

@Getter
@Setter
@ToString
@Entity
@Table(name = "profile")
public class ProfileEntity extends AbstractPersistable<UUID> {

    @OneToOne(mappedBy = "profile")
    private UserEntity user;

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

    @Column(name = "birth_day")
    private LocalDate birthDay;

    @Column(name = "height")
    private Short height;

    @ManyToOne(cascade = CascadeType.ALL)
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

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "profile_tag",  // Название промежуточной таблицы
            joinColumns = @JoinColumn(name = "profile_id"),  // Колонка для profile
            inverseJoinColumns = @JoinColumn(name = "tag_id")  // Колонка для tag
    )
    private Set<TagEntity> tags;

    @OneToMany(mappedBy = "profile", cascade = CascadeType.ALL)
    @ToString.Exclude
    private List<UserSocialNetworkEntity> socialNetworks;
}
