package ru.itmo.loveconnect;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.itmo.loveconnect.entity.FacultyEntity;
import ru.itmo.loveconnect.entity.ProfileEntity;
import ru.itmo.loveconnect.entity.RecommendationFilterEntity;
import ru.itmo.loveconnect.entity.UserEntity;
import ru.itmo.loveconnect.entity.enums.AlcoholPreference;
import ru.itmo.loveconnect.entity.enums.DatingPurpose;
import ru.itmo.loveconnect.entity.enums.Gender;
import ru.itmo.loveconnect.entity.enums.PhysicalActivity;
import ru.itmo.loveconnect.entity.enums.RelationshipStatus;
import ru.itmo.loveconnect.entity.enums.SmokePreference;
import ru.itmo.loveconnect.repo.FacultyRepository;
import ru.itmo.loveconnect.repo.RecommendationFilterRepository;
import ru.itmo.loveconnect.repo.TagRepository;
import ru.itmo.loveconnect.repo.UserRepository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.util.Set;

@Configuration
public class DatabaseLoader {

    private final UserRepository userRepository;
    private final FacultyRepository facultyRepository;
    private final RecommendationFilterRepository recommendationFilterRepository;
    private final TagRepository tagRepository;

    public DatabaseLoader(UserRepository userRepository,
                          FacultyRepository facultyRepository,
                          RecommendationFilterRepository recommendationFilterRepository,
                          TagRepository tagRepository) {
        this.userRepository = userRepository;
        this.facultyRepository = facultyRepository;
        this.recommendationFilterRepository = recommendationFilterRepository;
        this.tagRepository = tagRepository;
    }

    private void initData() {
        // Логику инициализации базы данных
        if (userRepository.count() == 0) {
            // Добавление данные, если таблицы пусты
            // creating Faculty
            FacultyEntity faculty1 = new FacultyEntity();
            faculty1.setShortName("Мегафакультет компьютерных технологий и управления");
            FacultyEntity faculty2 = new FacultyEntity();
            faculty2.setShortName("Физико-технический мегафакультет");
            FacultyEntity faculty3 = new FacultyEntity();
            faculty3.setShortName("Мегафакультет трансляционных информационных технологий");
            FacultyEntity faculty4 = new FacultyEntity();
            faculty4.setShortName("Мегафакультет наук о жизни");
            FacultyEntity faculty5 = new FacultyEntity();
            faculty5.setShortName("Институт международного развития и партнерства");
            FacultyEntity faculty6 = new FacultyEntity();
            faculty6.setShortName("Факультет технологического менеджмента и инноваций");
            FacultyEntity faculty7 = new FacultyEntity();
            faculty7.setShortName("Институт \"Высшая инженерно-техническая школа\"");
            FacultyEntity faculty8 = new FacultyEntity();
            faculty8.setShortName("Образовательный центр \"Энергоэффективные инженерные системы\"");

            // creating Profiles
            ProfileEntity profileElonMusk = new ProfileEntity();
            profileElonMusk.setName("Elon");
            profileElonMusk.setGender(Gender.MALE);
            profileElonMusk.setBirthDay(LocalDate.of(1971, Month.JUNE, 17));
            profileElonMusk.setHeight((short) 188);
            profileElonMusk.setFaculty(faculty2);
            profileElonMusk.setCourse((short) 4);
            profileElonMusk.setAbout("Привет, меня зовут Илон Маск. Я инженер, предприниматель и мечтатель, посвятивший жизнь созданию технологий, которые могут изменить будущее человечества.");
            profileElonMusk.setDatingPurpose(DatingPurpose.NEW_EXPRESSION);
            profileElonMusk.setRelationshipStatus(RelationshipStatus.COMPLICATED);
            profileElonMusk.setAlcoholPreference(AlcoholPreference.RARELY);
            profileElonMusk.setSmokePreference(SmokePreference.SMOKE);
            profileElonMusk.setPhysicalActivity(PhysicalActivity.HATER);

            ProfileEntity profileElonMusk1 = new ProfileEntity();
            profileElonMusk1.setName("Elon");
            profileElonMusk1.setGender(Gender.MALE);
            profileElonMusk1.setBirthDay(LocalDate.of(1971, Month.JUNE, 17));
            profileElonMusk1.setHeight((short) 188);
            profileElonMusk1.setFaculty(faculty2);
            profileElonMusk1.setCourse((short) 4);
            profileElonMusk1.setAbout("Привет, меня зовут Илон Маск. Я инженер, предприниматель и мечтатель, посвятивший жизнь созданию технологий, которые могут изменить будущее человечества.");
            profileElonMusk1.setDatingPurpose(DatingPurpose.NEW_EXPRESSION);
            profileElonMusk1.setRelationshipStatus(RelationshipStatus.COMPLICATED);
            profileElonMusk1.setAlcoholPreference(AlcoholPreference.RARELY);
            profileElonMusk1.setSmokePreference(SmokePreference.SMOKE);
            profileElonMusk1.setPhysicalActivity(PhysicalActivity.HATER);

            ProfileEntity profileElonMusk2 = new ProfileEntity();
            profileElonMusk2.setName("Elon");
            profileElonMusk2.setGender(Gender.MALE);
            profileElonMusk2.setBirthDay(LocalDate.of(1971, Month.JUNE, 17));
            profileElonMusk2.setHeight((short) 188);
            profileElonMusk2.setFaculty(faculty2);
            profileElonMusk2.setCourse((short) 4);
            profileElonMusk2.setAbout("Привет, меня зовут Илон Маск. Я инженер, предприниматель и мечтатель, посвятивший жизнь созданию технологий, которые могут изменить будущее человечества.");
            profileElonMusk2.setDatingPurpose(DatingPurpose.NEW_EXPRESSION);
            profileElonMusk2.setRelationshipStatus(RelationshipStatus.COMPLICATED);
            profileElonMusk2.setAlcoholPreference(AlcoholPreference.RARELY);
            profileElonMusk2.setSmokePreference(SmokePreference.SMOKE);
            profileElonMusk2.setPhysicalActivity(PhysicalActivity.HATER);

            ProfileEntity profileElonMusk3 = new ProfileEntity();
            profileElonMusk3.setName("Elon");
            profileElonMusk3.setGender(Gender.MALE);
            profileElonMusk3.setBirthDay(LocalDate.of(1971, Month.JUNE, 17));
            profileElonMusk3.setHeight((short) 188);
            profileElonMusk3.setFaculty(faculty2);
            profileElonMusk3.setCourse((short) 4);
            profileElonMusk3.setAbout("Привет, меня зовут Илон Маск. Я инженер, предприниматель и мечтатель, посвятивший жизнь созданию технологий, которые могут изменить будущее человечества.");
            profileElonMusk3.setDatingPurpose(DatingPurpose.NEW_EXPRESSION);
            profileElonMusk3.setRelationshipStatus(RelationshipStatus.COMPLICATED);
            profileElonMusk3.setAlcoholPreference(AlcoholPreference.RARELY);
            profileElonMusk3.setSmokePreference(SmokePreference.SMOKE);
            profileElonMusk3.setPhysicalActivity(PhysicalActivity.HATER);

            ProfileEntity profileElonMusk4 = new ProfileEntity();
            profileElonMusk4.setName("Elon");
            profileElonMusk4.setGender(Gender.MALE);
            profileElonMusk4.setBirthDay(LocalDate.of(1971, Month.JUNE, 17));
            profileElonMusk4.setHeight((short) 188);
            profileElonMusk4.setFaculty(faculty2);
            profileElonMusk4.setCourse((short) 4);
            profileElonMusk4.setAbout("Привет, меня зовут Илон Маск. Я инженер, предприниматель и мечтатель, посвятивший жизнь созданию технологий, которые могут изменить будущее человечества.");
            profileElonMusk4.setDatingPurpose(DatingPurpose.NEW_EXPRESSION);
            profileElonMusk4.setRelationshipStatus(RelationshipStatus.COMPLICATED);
            profileElonMusk4.setAlcoholPreference(AlcoholPreference.RARELY);
            profileElonMusk4.setSmokePreference(SmokePreference.SMOKE);
            profileElonMusk4.setPhysicalActivity(PhysicalActivity.HATER);

            // creating RecommendationFilter
            RecommendationFilterEntity recommendationFilterElonMusk = new RecommendationFilterEntity();
            recommendationFilterElonMusk.setMinAge((short) 18);
            recommendationFilterElonMusk.setMaxAge((short) 70);
            RecommendationFilterEntity recommendationFilterElonMusk1 = new RecommendationFilterEntity();
            recommendationFilterElonMusk1.setMinAge((short) 18);
            recommendationFilterElonMusk1.setMaxAge((short) 70);
            RecommendationFilterEntity recommendationFilterElonMusk2 = new RecommendationFilterEntity();
            recommendationFilterElonMusk2.setMinAge((short) 18);
            recommendationFilterElonMusk2.setMaxAge((short) 70);
            RecommendationFilterEntity recommendationFilterElonMusk3 = new RecommendationFilterEntity();
            recommendationFilterElonMusk3.setMinAge((short) 18);
            recommendationFilterElonMusk3.setMaxAge((short) 70);
            RecommendationFilterEntity recommendationFilterElonMusk4 = new RecommendationFilterEntity();
            recommendationFilterElonMusk4.setMinAge((short) 18);
            recommendationFilterElonMusk4.setMaxAge((short) 70);

            // creating ManyToMany connection between Profiles and Tags
            profileElonMusk.setTags(Set.of(tagRepository.findByName("design").get(), tagRepository.findByName("fitness").get()));
            profileElonMusk1.setTags(Set.of(tagRepository.findByName("design").get(), tagRepository.findByName("blues").get()));
            profileElonMusk2.setTags(Set.of(tagRepository.findByName("techno").get(), tagRepository.findByName("music lover").get()));
            profileElonMusk3.setTags(Set.of(tagRepository.findByName("classical").get(), tagRepository.findByName("drama").get()));
            profileElonMusk4.setTags(Set.of(tagRepository.findByName("basketball").get(), tagRepository.findByName("excursions").get()));

            // creating Users
            UserEntity userElonMusk = new UserEntity();
            userElonMusk.setEmail("elonmusk@gmail.com");
            userElonMusk.setVerified(false);
            userElonMusk.setProfile(profileElonMusk);
            userElonMusk.setLastActive(LocalDateTime.now());
            userElonMusk.setRecommendationFilter(recommendationFilterElonMusk);

            UserEntity userElonMusk1 = new UserEntity();
            userElonMusk1.setEmail("elonmusk@gmail.com");
            userElonMusk1.setVerified(false);
            userElonMusk1.setProfile(profileElonMusk1);
            userElonMusk1.setLastActive(LocalDateTime.now());
            userElonMusk1.setRecommendationFilter(recommendationFilterElonMusk1);

            UserEntity userElonMusk2 = new UserEntity();
            userElonMusk2.setEmail("elonmusk@gmail.com");
            userElonMusk2.setVerified(false);
            userElonMusk2.setProfile(profileElonMusk2);
            userElonMusk2.setLastActive(LocalDateTime.now());
            userElonMusk2.setRecommendationFilter(recommendationFilterElonMusk2);

            UserEntity userElonMusk3 = new UserEntity();
            userElonMusk3.setEmail("elonmusk@gmail.com");
            userElonMusk3.setVerified(false);
            userElonMusk3.setProfile(profileElonMusk3);
            userElonMusk3.setLastActive(LocalDateTime.now());
            userElonMusk3.setRecommendationFilter(recommendationFilterElonMusk3);

            UserEntity userElonMusk4 = new UserEntity();
            userElonMusk4.setEmail("elonmusk@gmail.com");
            userElonMusk4.setVerified(false);
            userElonMusk4.setProfile(profileElonMusk4);
            userElonMusk4.setLastActive(LocalDateTime.now());
            userElonMusk4.setRecommendationFilter(recommendationFilterElonMusk4);


            // adding faculties
            facultyRepository.save(faculty1);
            facultyRepository.save(faculty2);
            facultyRepository.save(faculty3);
            facultyRepository.save(faculty4);
            facultyRepository.save(faculty5);
            facultyRepository.save(faculty6);
            facultyRepository.save(faculty7);
            facultyRepository.save(faculty8);

            // adding filters
            recommendationFilterRepository.save(recommendationFilterElonMusk);
            recommendationFilterRepository.save(recommendationFilterElonMusk1);
            recommendationFilterRepository.save(recommendationFilterElonMusk2);
            recommendationFilterRepository.save(recommendationFilterElonMusk3);
            recommendationFilterRepository.save(recommendationFilterElonMusk4);
            // adding users
            userRepository.save(userElonMusk);
            userRepository.save(userElonMusk1);
            userRepository.save(userElonMusk2);
            userRepository.save(userElonMusk3);
            userRepository.save(userElonMusk4);
        }
    }

    @Bean
    @ConditionalOnProperty(name = "app.init-db", havingValue = "true")
    CommandLineRunner init() {
        return args -> {
            // Инициализация данных из CommandLineRunner
            initData();
        };
    }
}
