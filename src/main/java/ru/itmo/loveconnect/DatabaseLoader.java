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

import java.time.LocalDate;
import java.time.Month;
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
            RecommendationFilterEntity recommendationFilterElonMusk1 = new RecommendationFilterEntity();
            RecommendationFilterEntity recommendationFilterElonMusk2 = new RecommendationFilterEntity();
            RecommendationFilterEntity recommendationFilterElonMusk3 = new RecommendationFilterEntity();
            RecommendationFilterEntity recommendationFilterElonMusk4 = new RecommendationFilterEntity();

            // ART
            TagEntity tagPhotography = new TagEntity();
            tagPhotography.setName("photography");
            tagPhotography.setEmoji("\uD83D\uDCF7");
            tagPhotography.setCategory(TagCategory.ART);

            TagEntity tagVideography = new TagEntity();
            tagVideography.setName("videography");
            tagVideography.setEmoji("\uD83D\uDCF9");
            tagVideography.setCategory(TagCategory.ART);

            TagEntity tagDesign = new TagEntity();
            tagDesign.setName("design");
            tagDesign.setEmoji("\uD83D\uDD8C");
            tagDesign.setCategory(TagCategory.ART);

            TagEntity tagMakeup = new TagEntity();
            tagMakeup.setName("makeup");
            tagMakeup.setEmoji("\uD83D\uDC84");
            tagMakeup.setCategory(TagCategory.ART);

            TagEntity tagCrafting = new TagEntity();
            tagCrafting.setName("crafting");
            tagCrafting.setEmoji("\uD83E\uDDFD");
            tagCrafting.setCategory(TagCategory.ART);

            TagEntity tagDancing = new TagEntity();
            tagDancing.setName("dancing");
            tagDancing.setEmoji("\uD83D\uDC83");
            tagDancing.setCategory(TagCategory.ART);

            TagEntity tagSinging = new TagEntity();
            tagSinging.setName("singing");
            tagSinging.setEmoji("\uD83C\uDFA4");
            tagSinging.setCategory(TagCategory.ART);

            TagEntity tagMusicArt = new TagEntity();
            tagMusicArt.setName("music");
            tagMusicArt.setEmoji("\uD83C\uDFB6");
            tagMusicArt.setCategory(TagCategory.ART);

            TagEntity tagBlogging = new TagEntity();
            tagBlogging.setName("blogging");
            tagBlogging.setEmoji("\uD83D\uDCF0");
            tagBlogging.setCategory(TagCategory.ART);

            TagEntity tagDrawing = new TagEntity();
            tagDrawing.setName("drawing");
            tagDrawing.setEmoji("\uD83D\uDD8D");
            tagDrawing.setCategory(TagCategory.ART);

            // ACTIVE_LIFESTYLE
            TagEntity tagRunning = new TagEntity();
            tagRunning.setName("running");
            tagRunning.setEmoji("\uD83C\uDFC3");
            tagRunning.setCategory(TagCategory.ACTIVE_LIFESTYLE);

            TagEntity tagFitness = new TagEntity();
            tagFitness.setName("fitness");
            tagFitness.setEmoji("\uD83D\uDCAA");
            tagFitness.setCategory(TagCategory.ACTIVE_LIFESTYLE);

            TagEntity tagBicycle = new TagEntity();
            tagBicycle.setName("bicycle");
            tagBicycle.setEmoji("\uD83D\uDEB4\u200D♂\uFE0F");
            tagBicycle.setCategory(TagCategory.ACTIVE_LIFESTYLE);

            TagEntity tagHorseRiding = new TagEntity();
            tagHorseRiding.setName("horse riding");
            tagHorseRiding.setEmoji("\uD83D\uDC0E");
            tagHorseRiding.setCategory(TagCategory.ACTIVE_LIFESTYLE);

            TagEntity tagSkiing = new TagEntity();
            tagSkiing.setName("skiing");
            tagSkiing.setEmoji("\uD83C\uDFBF");
            tagSkiing.setCategory(TagCategory.ACTIVE_LIFESTYLE);

            TagEntity tagYoga = new TagEntity();
            tagYoga.setName("yoga");
            tagYoga.setEmoji("\uD83E\uDD38");
            tagYoga.setCategory(TagCategory.ACTIVE_LIFESTYLE);

            TagEntity tagPilates = new TagEntity();
            tagPilates.setName("pilates");
            tagPilates.setEmoji("\uD83E\uDD47");
            tagPilates.setCategory(TagCategory.ACTIVE_LIFESTYLE);

            TagEntity tagSnowboarding = new TagEntity();
            tagSnowboarding.setName("snowboarding");
            tagSnowboarding.setEmoji("\uD83C\uDFC2");
            tagSnowboarding.setCategory(TagCategory.ACTIVE_LIFESTYLE);

            TagEntity tagRollerSkating = new TagEntity();
            tagRollerSkating.setName("roller skating");
            tagRollerSkating.setEmoji("\uD83D\uDEB6");
            tagRollerSkating.setCategory(TagCategory.ACTIVE_LIFESTYLE);

            TagEntity tagSkateboarding = new TagEntity();
            tagSkateboarding.setName("skateboarding");
            tagSkateboarding.setEmoji("\uD83D\uDEB4");
            tagSkateboarding.setCategory(TagCategory.ACTIVE_LIFESTYLE);

            TagEntity tagScooter = new TagEntity();
            tagScooter.setName("scooter");
            tagScooter.setEmoji("\uD83D\uDEF4");
            tagScooter.setCategory(TagCategory.ACTIVE_LIFESTYLE);

            // FOOD
            TagEntity tagPizza = new TagEntity();
            tagPizza.setName("pizza");
            tagPizza.setEmoji("\uD83C\uDF55");
            tagPizza.setCategory(TagCategory.FOOD);

            TagEntity tagSushi = new TagEntity();
            tagSushi.setName("sushi");
            tagSushi.setEmoji("\uD83C\uDF63");
            tagSushi.setCategory(TagCategory.FOOD);

            TagEntity tagBurger = new TagEntity();
            tagBurger.setName("burger");
            tagBurger.setEmoji("\uD83C\uDF54");
            tagBurger.setCategory(TagCategory.FOOD);

            TagEntity tagHealthyEating = new TagEntity();
            tagHealthyEating.setName("healthy eating");
            tagHealthyEating.setEmoji("\uD83E\uDD66");
            tagHealthyEating.setCategory(TagCategory.FOOD);

            TagEntity tagVegan = new TagEntity();
            tagVegan.setName("vegan");
            tagVegan.setEmoji("\uD83E\uDDC9");
            tagVegan.setCategory(TagCategory.FOOD);

            TagEntity tagVegetarian = new TagEntity();
            tagVegetarian.setName("vegetarian");
            tagVegetarian.setEmoji("\uD83E\uDD51");
            tagVegetarian.setCategory(TagCategory.FOOD);

            TagEntity tagCoffee = new TagEntity();
            tagCoffee.setName("coffee");
            tagCoffee.setEmoji("\u2615");
            tagCoffee.setCategory(TagCategory.FOOD);

            TagEntity tagTea = new TagEntity();
            tagTea.setName("tea");
            tagTea.setEmoji("\uD83C\uDF75");
            tagTea.setCategory(TagCategory.FOOD);

            TagEntity tagPastries = new TagEntity();
            tagPastries.setName("pastries");
            tagPastries.setEmoji("\uD83E\uDD50");
            tagPastries.setCategory(TagCategory.FOOD);

            TagEntity tagSweets = new TagEntity();
            tagSweets.setName("sweets");
            tagSweets.setEmoji("\uD83C\uDF6B");
            tagSweets.setCategory(TagCategory.FOOD);

            TagEntity tagHomeCooking = new TagEntity();
            tagHomeCooking.setName("home cooking");
            tagHomeCooking.setEmoji("\uD83C\uDF73");
            tagHomeCooking.setCategory(TagCategory.FOOD);

            // SOCIAL_LIFE
            TagEntity tagCinema = new TagEntity();
            tagCinema.setName("cinema");
            tagCinema.setEmoji("\uD83C\uDF7F");
            tagCinema.setCategory(TagCategory.SOCIAL_LIFE);

            TagEntity tagConcert = new TagEntity();
            tagConcert.setName("concert");
            tagConcert.setEmoji("\uD83C\uDF89");
            tagConcert.setCategory(TagCategory.SOCIAL_LIFE);

            TagEntity tagMuseum = new TagEntity();
            tagMuseum.setName("museum");
            tagMuseum.setEmoji("\uD83C\uDFE0");
            tagMuseum.setCategory(TagCategory.SOCIAL_LIFE);

            TagEntity tagTheater = new TagEntity();
            tagTheater.setName("theater");
            tagTheater.setEmoji("\uD83C\uDFAD");
            tagTheater.setCategory(TagCategory.SOCIAL_LIFE);

            TagEntity tagOutdoor = new TagEntity();
            tagOutdoor.setName("outdoor recreation");
            tagOutdoor.setEmoji("\uD83C\uDFD6");
            tagOutdoor.setCategory(TagCategory.SOCIAL_LIFE);

            TagEntity tagFestival = new TagEntity();
            tagFestival.setName("festival");
            tagFestival.setEmoji("\uD83C\uDFA8");
            tagFestival.setCategory(TagCategory.SOCIAL_LIFE);

            TagEntity tagParty = new TagEntity();
            tagParty.setName("party");
            tagParty.setEmoji("\uD83C\uDF7E");
            tagParty.setCategory(TagCategory.SOCIAL_LIFE);

            TagEntity tagVolunteering = new TagEntity();
            tagVolunteering.setName("volunteering");
            tagVolunteering.setEmoji("\uD83D\uDC4D");
            tagVolunteering.setCategory(TagCategory.SOCIAL_LIFE);

            TagEntity tagRestaurant = new TagEntity();
            tagRestaurant.setName("restaurant");
            tagRestaurant.setEmoji("\uD83C\uDF74");
            tagRestaurant.setCategory(TagCategory.SOCIAL_LIFE);

            TagEntity tagTravel = new TagEntity();
            tagTravel.setName("travel");
            tagTravel.setEmoji("\u2708");
            tagTravel.setCategory(TagCategory.SOCIAL_LIFE);

            TagEntity tagShopping = new TagEntity();
            tagShopping.setName("shopping");
            tagShopping.setEmoji("\uD83D\uDC5C");
            tagShopping.setCategory(TagCategory.SOCIAL_LIFE);

            TagEntity tagFriends = new TagEntity();
            tagFriends.setName("meeting friends");
            tagFriends.setEmoji("\uD83D\uDC6A");
            tagFriends.setCategory(TagCategory.SOCIAL_LIFE);

            TagEntity tagArt = new TagEntity();
            tagArt.setName("art");
            tagArt.setEmoji("\uD83C\uDF3F");
            tagArt.setCategory(TagCategory.SOCIAL_LIFE);

            // PETS
            TagEntity tagCats = new TagEntity();
            tagCats.setName("cats");
            tagCats.setEmoji("\uD83D\uDC31");
            tagCats.setCategory(TagCategory.PETS);

            TagEntity tagDogs = new TagEntity();
            tagDogs.setName("dogs");
            tagDogs.setEmoji("\uD83D\uDC36");
            tagDogs.setCategory(TagCategory.PETS);

            TagEntity tagBirds = new TagEntity();
            tagBirds.setName("birds");
            tagBirds.setEmoji("\uD83D\uDC26");
            tagBirds.setCategory(TagCategory.PETS);

            TagEntity tagFish = new TagEntity();
            tagFish.setName("fish");
            tagFish.setEmoji("\uD83D\uDC1F");
            tagFish.setCategory(TagCategory.PETS);

            TagEntity tagRabbits = new TagEntity();
            tagRabbits.setName("rabbits");
            tagRabbits.setEmoji("\uD83D\uDC30");
            tagRabbits.setCategory(TagCategory.PETS);

            TagEntity tagTurtles = new TagEntity();
            tagTurtles.setName("turtles");
            tagTurtles.setEmoji("\uD83D\uDC22");
            tagTurtles.setCategory(TagCategory.PETS);

            TagEntity tagSnakes = new TagEntity();
            tagSnakes.setName("snakes");
            tagSnakes.setEmoji("\uD83D\uDC0D");
            tagSnakes.setCategory(TagCategory.PETS);

            TagEntity tagLizards = new TagEntity();
            tagLizards.setName("lizards");
            tagLizards.setEmoji("\uD83E\uDD8E");
            tagLizards.setCategory(TagCategory.PETS);

            TagEntity tagHamsters = new TagEntity();
            tagHamsters.setName("hamsters");
            tagHamsters.setEmoji("\uD83D\uDC39");
            tagHamsters.setCategory(TagCategory.PETS);

            // SPORTS
            TagEntity tagFootball = new TagEntity();
            tagFootball.setName("football");
            tagFootball.setEmoji("\u26BD");
            tagFootball.setCategory(TagCategory.SPORTS);

            TagEntity tagSwimming = new TagEntity();
            tagSwimming.setName("swimming");
            tagSwimming.setEmoji("\uD83C\uDFCA");
            tagSwimming.setCategory(TagCategory.SPORTS);

            TagEntity tagCycling = new TagEntity();
            tagCycling.setName("cycling");
            tagCycling.setEmoji("\uD83D\uDEB2");
            tagCycling.setCategory(TagCategory.SPORTS);

            TagEntity tagVolleyball = new TagEntity();
            tagVolleyball.setName("volleyball");
            tagVolleyball.setEmoji("\uD83C\uDFD0");
            tagVolleyball.setCategory(TagCategory.SPORTS);

            TagEntity tagBasketball = new TagEntity();
            tagBasketball.setName("basketball");
            tagBasketball.setEmoji("\uD83C\uDFC0");
            tagBasketball.setCategory(TagCategory.SPORTS);

            TagEntity tagHockey = new TagEntity();
            tagHockey.setName("hockey");
            tagHockey.setEmoji("\uD83C\uDFD2");
            tagHockey.setCategory(TagCategory.SPORTS);

            TagEntity tagAthletics = new TagEntity();
            tagAthletics.setName("track and field");
            tagAthletics.setEmoji("\uD83C\uDFC3");
            tagAthletics.setCategory(TagCategory.SPORTS);

            TagEntity tagWeightlifting = new TagEntity();
            tagWeightlifting.setName("weightlifting");
            tagWeightlifting.setEmoji("\uD83C\uDFC8");
            tagWeightlifting.setCategory(TagCategory.SPORTS);

            TagEntity tagBoxing = new TagEntity();
            tagBoxing.setName("boxing");
            tagBoxing.setEmoji("\uD83E\uDD4A");
            tagBoxing.setCategory(TagCategory.SPORTS);

            TagEntity tagFigureSkating = new TagEntity();
            tagFigureSkating.setName("figure skating");
            tagFigureSkating.setEmoji("\u26F8");
            tagFigureSkating.setCategory(TagCategory.SPORTS);

            TagEntity tagGymnastics = new TagEntity();
            tagGymnastics.setName("gymnastics");
            tagGymnastics.setEmoji("\uD83C\uDFCB");
            tagGymnastics.setCategory(TagCategory.SPORTS);

            TagEntity tagSkiRacing = new TagEntity();
            tagSkiRacing.setName("ski racing");
            tagSkiRacing.setEmoji("\uD83C\uDFBF");
            tagSkiRacing.setCategory(TagCategory.SPORTS);

            TagEntity tagEsports = new TagEntity();
            tagEsports.setName("esports");
            tagEsports.setEmoji("\uD83C\uDFAE");
            tagEsports.setCategory(TagCategory.SPORTS);

            TagEntity tagYoYo = new TagEntity();
            tagYoYo.setName("yo-yo");
            tagYoYo.setEmoji("\uD83E\uDE80");
            tagYoYo.setCategory(TagCategory.SPORTS);

            // TIME_AT_HOME
            TagEntity tagVideoGames = new TagEntity();
            tagVideoGames.setName("video games");
            tagVideoGames.setEmoji("\uD83C\uDFAE");
            tagVideoGames.setCategory(TagCategory.TIME_AT_HOME);

            TagEntity tagCooking = new TagEntity();
            tagCooking.setName("cooking");
            tagCooking.setEmoji("\uD83C\uDF73");
            tagCooking.setCategory(TagCategory.TIME_AT_HOME);

            TagEntity tagBoardGames = new TagEntity();
            tagBoardGames.setName("board games");
            tagBoardGames.setEmoji("\uD83C\uDFB2");
            tagBoardGames.setCategory(TagCategory.TIME_AT_HOME);

            TagEntity tagMoviesSeries = new TagEntity();
            tagMoviesSeries.setName("movies and series");
            tagMoviesSeries.setEmoji("\uD83C\uDFA5");
            tagMoviesSeries.setCategory(TagCategory.TIME_AT_HOME);

            TagEntity tagGardening = new TagEntity();
            tagGardening.setName("gardening");
            tagGardening.setEmoji("\uD83C\uDF3B");
            tagGardening.setCategory(TagCategory.TIME_AT_HOME);

            TagEntity tagFashionBeauty = new TagEntity();
            tagFashionBeauty.setName("fashion and beauty");
            tagFashionBeauty.setEmoji("\uD83D\uDC57");
            tagFashionBeauty.setCategory(TagCategory.TIME_AT_HOME);

            TagEntity tagBooks = new TagEntity();
            tagBooks.setName("books");
            tagBooks.setEmoji("\uD83D\uDCDA");
            tagBooks.setCategory(TagCategory.TIME_AT_HOME);

            TagEntity tagIT = new TagEntity();
            tagIT.setName("IT and technology");
            tagIT.setEmoji("\uD83E\uDDE0");
            tagIT.setCategory(TagCategory.TIME_AT_HOME);

            TagEntity tagCars = new TagEntity();
            tagCars.setName("cars");
            tagCars.setEmoji("\uD83D\uDE97");
            tagCars.setCategory(TagCategory.TIME_AT_HOME);

            // TRAVELING
            TagEntity tagCountryTrips = new TagEntity();
            tagCountryTrips.setName("country trips");
            tagCountryTrips.setEmoji("\uD83C\uDFD6");
            tagCountryTrips.setCategory(TagCategory.TRAVELING);

            TagEntity tagHiking = new TagEntity();
            tagHiking.setName("hiking");
            tagHiking.setEmoji("\uD83E\uDDD6");
            tagHiking.setCategory(TagCategory.TRAVELING);

            TagEntity tagExcursions = new TagEntity();
            tagExcursions.setName("excursions");
            tagExcursions.setEmoji("\uD83C\uDFD4");
            tagExcursions.setCategory(TagCategory.TRAVELING);

            TagEntity tagBeachVacation = new TagEntity();
            tagBeachVacation.setName("beach vacation");
            tagBeachVacation.setEmoji("\uD83C\uDFD6");
            tagBeachVacation.setCategory(TagCategory.TRAVELING);

            TagEntity tagHuntingFishing = new TagEntity();
            tagHuntingFishing.setName("hunting and fishing");
            tagHuntingFishing.setEmoji("\uD83C\uDFA3");
            tagHuntingFishing.setCategory(TagCategory.TRAVELING);

            TagEntity tagCruises = new TagEntity();
            tagCruises.setName("cruises");
            tagCruises.setEmoji("\uD83D\uDEA2");
            tagCruises.setCategory(TagCategory.TRAVELING);

            TagEntity tagMountains = new TagEntity();
            tagMountains.setName("mountains");
            tagMountains.setEmoji("\uD83C\uDF04");
            tagMountains.setCategory(TagCategory.TRAVELING);

            TagEntity tagEvents = new TagEntity();
            tagEvents.setName("events and concerts");
            tagEvents.setEmoji("\uD83C\uDF7F");
            tagEvents.setCategory(TagCategory.TRAVELING);

            // MOVIES
            TagEntity tagComedy = new TagEntity();
            tagComedy.setName("comedy");
            tagComedy.setEmoji("\uD83D\uDE03");
            tagComedy.setCategory(TagCategory.MOVIES);

            TagEntity tagCartoons = new TagEntity();
            tagCartoons.setName("cartoons");
            tagCartoons.setEmoji("\uD83C\uDF80");
            tagCartoons.setCategory(TagCategory.MOVIES);

            TagEntity tagHistorical = new TagEntity();
            tagHistorical.setName("historical");
            tagHistorical.setEmoji("\uD83C\uDF2D");
            tagHistorical.setCategory(TagCategory.MOVIES);

            TagEntity tagDetective = new TagEntity();
            tagDetective.setName("detective");
            tagDetective.setEmoji("\uD83D\uDD0E");
            tagDetective.setCategory(TagCategory.MOVIES);

            TagEntity tagAdventure = new TagEntity();
            tagAdventure.setName("adventure");
            tagAdventure.setEmoji("\uD83C\uDFD5");
            tagAdventure.setCategory(TagCategory.MOVIES);

            TagEntity tagHorror = new TagEntity();
            tagHorror.setName("horror");
            tagHorror.setEmoji("\uD83D\uDC7B");
            tagHorror.setCategory(TagCategory.MOVIES);

            TagEntity tagDrama = new TagEntity();
            tagDrama.setName("drama");
            tagDrama.setEmoji("\uD83D\uDE22");
            tagDrama.setCategory(TagCategory.MOVIES);

            TagEntity tagMelodrama = new TagEntity();
            tagMelodrama.setName("melodrama");
            tagMelodrama.setEmoji("\uD83E\uDD70");
            tagMelodrama.setCategory(TagCategory.MOVIES);

            TagEntity tagThriller = new TagEntity();
            tagThriller.setName("thriller");
            tagThriller.setEmoji("\uD83D\uDE21");
            tagThriller.setCategory(TagCategory.MOVIES);

            TagEntity tagAction = new TagEntity();
            tagAction.setName("action");
            tagAction.setEmoji("\uD83D\uDCA5");
            tagAction.setCategory(TagCategory.MOVIES);

            // MUSIC
            TagEntity tagPop = new TagEntity();
            tagPop.setName("pop music");
            tagPop.setEmoji("\uD83C\uDF08");
            tagPop.setCategory(TagCategory.MUSIC);

            TagEntity tagHipHop = new TagEntity();
            tagHipHop.setName("hip-hop");
            tagHipHop.setEmoji("\uD83D\uDD78");
            tagHipHop.setCategory(TagCategory.MUSIC);

            TagEntity tagElectronic = new TagEntity();
            tagElectronic.setName("electronic");
            tagElectronic.setEmoji("\uD83D\uDCBF");
            tagElectronic.setCategory(TagCategory.MUSIC);

            TagEntity tagRock = new TagEntity();
            tagRock.setName("rock");
            tagRock.setEmoji("\uD83C\uDFB8");
            tagRock.setCategory(TagCategory.MUSIC);

            TagEntity tagRap = new TagEntity();
            tagRap.setName("rap");
            tagRap.setEmoji("\uD83C\uDFA4");
            tagRap.setCategory(TagCategory.MUSIC);

            TagEntity tagClassical = new TagEntity();
            tagClassical.setName("classical");
            tagClassical.setEmoji("\uD83C\uDFB6");
            tagClassical.setCategory(TagCategory.MUSIC);

            TagEntity tagMetal = new TagEntity();
            tagMetal.setName("metal");
            tagMetal.setEmoji("\uD83D\uDE80");
            tagMetal.setCategory(TagCategory.MUSIC);

            TagEntity tagTechno = new TagEntity();
            tagTechno.setName("techno");
            tagTechno.setEmoji("\uD83C\uDFA7");
            tagTechno.setCategory(TagCategory.MUSIC);

            TagEntity tagBlues = new TagEntity();
            tagBlues.setName("blues");
            tagBlues.setEmoji("\uD83C\uDFBC");
            tagBlues.setCategory(TagCategory.MUSIC);

            TagEntity tagMusicLover = new TagEntity();
            tagMusicLover.setName("music lover");
            tagMusicLover.setEmoji("\uD83C\uDFB5");
            tagMusicLover.setCategory(TagCategory.MUSIC);

            // creating ManyToMany connection between Profiles and Tags
            profileElonMusk.setTags(Set.of(tagDesign, tagFitness));
            profileElonMusk1.setTags(Set.of(tagDesign, tagBlues));
            profileElonMusk2.setTags(Set.of(tagTechno, tagMusicLover));
            profileElonMusk3.setTags(Set.of(tagClassical, tagDrama));
            profileElonMusk4.setTags(Set.of(tagBasketball, tagExcursions));

            // creating Users
            UserEntity userElonMusk = new UserEntity();
            userElonMusk.setEmail("elonmusk@gmail.com");
            userElonMusk.setVerified(false);
            userElonMusk.setProfile(profileElonMusk);
            userElonMusk.setRecommendationFilter(recommendationFilterElonMusk);

            UserEntity userElonMusk1 = new UserEntity();
            userElonMusk1.setEmail("elonmusk@gmail.com");
            userElonMusk1.setVerified(false);
            userElonMusk1.setProfile(profileElonMusk1);
            userElonMusk1.setRecommendationFilter(recommendationFilterElonMusk1);

            UserEntity userElonMusk2 = new UserEntity();
            userElonMusk2.setEmail("elonmusk@gmail.com");
            userElonMusk2.setVerified(false);
            userElonMusk2.setProfile(profileElonMusk2);
            userElonMusk2.setRecommendationFilter(recommendationFilterElonMusk2);

            UserEntity userElonMusk3 = new UserEntity();
            userElonMusk3.setEmail("elonmusk@gmail.com");
            userElonMusk3.setVerified(false);
            userElonMusk3.setProfile(profileElonMusk3);
            userElonMusk3.setRecommendationFilter(recommendationFilterElonMusk3);

            UserEntity userElonMusk4 = new UserEntity();
            userElonMusk4.setEmail("elonmusk@gmail.com");
            userElonMusk4.setVerified(false);
            userElonMusk4.setProfile(profileElonMusk4);
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

            // adding tags
            tagRepository.save(tagPhotography);
            tagRepository.save(tagVideography);
            tagRepository.save(tagDesign);
            tagRepository.save(tagMakeup);
            tagRepository.save(tagCrafting);
            tagRepository.save(tagDancing);
            tagRepository.save(tagSinging);
            tagRepository.save(tagBlogging);
            tagRepository.save(tagDrawing);
            tagRepository.save(tagMusicArt);

            tagRepository.save(tagRunning);
            tagRepository.save(tagFitness);
            tagRepository.save(tagBicycle);
            tagRepository.save(tagHorseRiding);
            tagRepository.save(tagSkiing);
            tagRepository.save(tagYoga);
            tagRepository.save(tagPilates);
            tagRepository.save(tagSnowboarding);
            tagRepository.save(tagRollerSkating);
            tagRepository.save(tagSkateboarding);
            tagRepository.save(tagScooter);

            tagRepository.save(tagPizza);
            tagRepository.save(tagSushi);
            tagRepository.save(tagBurger);
            tagRepository.save(tagHealthyEating);
            tagRepository.save(tagVegan);
            tagRepository.save(tagVegetarian);
            tagRepository.save(tagCoffee);
            tagRepository.save(tagTea);
            tagRepository.save(tagPastries);
            tagRepository.save(tagSweets);
            tagRepository.save(tagHomeCooking);
            tagRepository.save(tagCinema);
            tagRepository.save(tagConcert);
            tagRepository.save(tagMuseum);
            tagRepository.save(tagTheater);
            tagRepository.save(tagOutdoor);
            tagRepository.save(tagFestival);
            tagRepository.save(tagParty);
            tagRepository.save(tagVolunteering);
            tagRepository.save(tagRestaurant);
            tagRepository.save(tagTravel);
            tagRepository.save(tagShopping);
            tagRepository.save(tagFriends);
            tagRepository.save(tagArt);

            tagRepository.save(tagCats);
            tagRepository.save(tagDogs);
            tagRepository.save(tagBirds);
            tagRepository.save(tagFish);
            tagRepository.save(tagRabbits);
            tagRepository.save(tagTurtles);
            tagRepository.save(tagSnakes);
            tagRepository.save(tagLizards);
            tagRepository.save(tagHamsters);

            tagRepository.save(tagFootball);
            tagRepository.save(tagSwimming);
            tagRepository.save(tagCycling);
            tagRepository.save(tagVolleyball);
            tagRepository.save(tagBasketball);
            tagRepository.save(tagHockey);
            tagRepository.save(tagAthletics);
            tagRepository.save(tagWeightlifting);
            tagRepository.save(tagBoxing);
            tagRepository.save(tagFigureSkating);
            tagRepository.save(tagGymnastics);
            tagRepository.save(tagSkiRacing);
            tagRepository.save(tagEsports);
            tagRepository.save(tagYoYo);

            tagRepository.save(tagVideoGames);
            tagRepository.save(tagCooking);
            tagRepository.save(tagBoardGames);
            tagRepository.save(tagMoviesSeries);
            tagRepository.save(tagGardening);
            tagRepository.save(tagFashionBeauty);
            tagRepository.save(tagBooks);
            tagRepository.save(tagIT);
            tagRepository.save(tagCars);

            tagRepository.save(tagCountryTrips);
            tagRepository.save(tagHiking);
            tagRepository.save(tagExcursions);
            tagRepository.save(tagBeachVacation);
            tagRepository.save(tagHuntingFishing);
            tagRepository.save(tagCruises);
            tagRepository.save(tagMountains);
            tagRepository.save(tagEvents);

            tagRepository.save(tagComedy);
            tagRepository.save(tagCartoons);
            tagRepository.save(tagHistorical);
            tagRepository.save(tagDetective);
            tagRepository.save(tagAdventure);
            tagRepository.save(tagHorror);
            tagRepository.save(tagDrama);
            tagRepository.save(tagMelodrama);
            tagRepository.save(tagThriller);
            tagRepository.save(tagAction);

            tagRepository.save(tagPop);
            tagRepository.save(tagHipHop);
            tagRepository.save(tagElectronic);
            tagRepository.save(tagRock);
            tagRepository.save(tagRap);
            tagRepository.save(tagClassical);
            tagRepository.save(tagMetal);
            tagRepository.save(tagTechno);
            tagRepository.save(tagBlues);
            tagRepository.save(tagMusicLover);

            // adding profiles
            profileRepository.save(profileElonMusk);
            profileRepository.save(profileElonMusk1);
            profileRepository.save(profileElonMusk2);
            profileRepository.save(profileElonMusk3);
            profileRepository.save(profileElonMusk4);
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
