package ru.itmo.loveconnect;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.itmo.loveconnect.entity.FacultyEntity;
import ru.itmo.loveconnect.entity.ProfileEntity;
import ru.itmo.loveconnect.entity.RecommendationFilterEntity;
import ru.itmo.loveconnect.entity.TagEntity;
import ru.itmo.loveconnect.entity.UserEntity;
import ru.itmo.loveconnect.entity.enums.AlcoholPreference;
import ru.itmo.loveconnect.entity.enums.DatingPurpose;
import ru.itmo.loveconnect.entity.enums.Gender;
import ru.itmo.loveconnect.entity.enums.PhysicalActivity;
import ru.itmo.loveconnect.entity.enums.RelationshipStatus;
import ru.itmo.loveconnect.entity.enums.SmokePreference;
import ru.itmo.loveconnect.entity.enums.TagCategory;
import ru.itmo.loveconnect.repo.FacultyRepository;
import ru.itmo.loveconnect.repo.ProfileRepository;
import ru.itmo.loveconnect.repo.RecommendationFilterRepository;
import ru.itmo.loveconnect.repo.TagRepository;
import ru.itmo.loveconnect.repo.UserRepository;

import java.util.Set;

@Configuration
public class DatabaseLoader {

    private final UserRepository userRepository;
    private final ProfileRepository profileRepository;
    private final FacultyRepository facultyRepository;
    private final RecommendationFilterRepository recommendationFilterRepository;
    private final TagRepository tagRepository;

    public DatabaseLoader(UserRepository userRepository,
                          ProfileRepository profileRepository,
                          FacultyRepository facultyRepository,
                          RecommendationFilterRepository recommendationFilterRepository,
                          TagRepository tagRepository) {
        this.userRepository = userRepository;
        this.profileRepository = profileRepository;
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
            profileElonMusk.setAge((short) 53);
            profileElonMusk.setHeight((short) 188);
            profileElonMusk.setFaculty(faculty2);
            profileElonMusk.setCourse((short) 4);
            profileElonMusk.setAbout("Привет, меня зовут Илон Маск. Я инженер, предприниматель и мечтатель, посвятивший жизнь созданию технологий, которые могут изменить будущее человечества.");
            profileElonMusk.setDatingPurpose(DatingPurpose.NEW_EXPRESSION);
            profileElonMusk.setRelationshipStatus(RelationshipStatus.COMPLICATED);
            profileElonMusk.setAlcoholPreference(AlcoholPreference.RARELY);
            profileElonMusk.setSmokePreference(SmokePreference.SMOKE);
            profileElonMusk.setPhysicalActivity(PhysicalActivity.HATER);

            // creating RecommendationFilter
            RecommendationFilterEntity recommendationFilterElonMusk = new RecommendationFilterEntity();

            // creating Tags ART
            TagEntity tagPhoto = new TagEntity();
            tagPhoto.setName("photo");
            tagPhoto.setCategory(TagCategory.ART);

            TagEntity tagVideoShooting = new TagEntity();
            tagVideoShooting.setName("video_shooting");
            tagVideoShooting.setCategory(TagCategory.ART);

            TagEntity tagDesign = new TagEntity();
            tagDesign.setName("design");
            tagDesign.setCategory(TagCategory.ART);

            // creating Tags SPORT
            TagEntity tagRunning = new TagEntity();
            tagRunning.setName("running");
            tagRunning.setCategory(TagCategory.SPORT);

            TagEntity tagFitness = new TagEntity();
            tagFitness.setName("fitness");
            tagFitness.setCategory(TagCategory.SPORT);

            TagEntity tagBicycle = new TagEntity();
            tagBicycle.setName("bicycle");
            tagBicycle.setCategory(TagCategory.SPORT);

            // creating ManyToMany connection between Profiles and Tags
            profileElonMusk.setTags(Set.of(tagDesign, tagFitness));

            // creating Users
            UserEntity userElonMusk = new UserEntity();
            userElonMusk.setEmail("elonmusk@gmail.com");
            userElonMusk.setVerified(false);
            userElonMusk.setProfile(profileElonMusk);
            userElonMusk.setRecommendationFilter(recommendationFilterElonMusk);


            // adding faculties
            facultyRepository.save(faculty1);
            facultyRepository.save(faculty2);
            facultyRepository.save(faculty3);
            facultyRepository.save(faculty4);
            facultyRepository.save(faculty5);
            facultyRepository.save(faculty6);
            facultyRepository.save(faculty7);
            facultyRepository.save(faculty8);

            // adding tags
            tagRepository.save(tagPhoto);
            tagRepository.save(tagVideoShooting);
            tagRepository.save(tagDesign);

            tagRepository.save(tagRunning);
            tagRepository.save(tagFitness);
            tagRepository.save(tagBicycle);
            // adding profiles
            profileRepository.save(profileElonMusk);
            // adding filters
            recommendationFilterRepository.save(recommendationFilterElonMusk);
            // adding users
            userRepository.save(userElonMusk);
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
