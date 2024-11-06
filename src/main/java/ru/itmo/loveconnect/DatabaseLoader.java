package ru.itmo.loveconnect;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.itmo.loveconnect.entity.ProfileEntity;
import ru.itmo.loveconnect.entity.RecommendationFilterEntity;
import ru.itmo.loveconnect.entity.TagEntity;
import ru.itmo.loveconnect.entity.UserEntity;
import ru.itmo.loveconnect.entity.enums.DatingPurpose;
import ru.itmo.loveconnect.entity.enums.Gender;
import ru.itmo.loveconnect.entity.enums.TagCategory;
import ru.itmo.loveconnect.repo.ProfileRepository;
import ru.itmo.loveconnect.repo.RecommendationFilterRepository;
import ru.itmo.loveconnect.repo.TagRepository;
import ru.itmo.loveconnect.repo.UserRepository;

import java.util.Set;

@Configuration
public class DatabaseLoader {
    @Bean
    CommandLineRunner init(UserRepository userRepository,
                           ProfileRepository profileRepository,
                           RecommendationFilterRepository recommendationFilterRepository,
                           TagRepository tagRepository) {
        // creating Profiles
        ProfileEntity profileElonMusk = new ProfileEntity();
        profileElonMusk.setName("Elon");
        profileElonMusk.setGender(Gender.MALE);
        profileElonMusk.setDatingPurpose(DatingPurpose.FREERELATIONSHIP);

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
        userElonMusk.setProfile(profileElonMusk);
        userElonMusk.setRecommendationFilter(recommendationFilterElonMusk);

        return args -> {
            // adding tagRepository
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
        };
    }
}
