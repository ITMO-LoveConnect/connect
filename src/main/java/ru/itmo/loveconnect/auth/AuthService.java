package ru.itmo.loveconnect.auth;

import com.github.benmanes.caffeine.cache.Cache;
import com.github.benmanes.caffeine.cache.Caffeine;
import jakarta.mail.MessagingException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.itmo.loveconnect.dto.ProfileDto;
import ru.itmo.loveconnect.entity.UserEntity;
import ru.itmo.loveconnect.entity.mapper.ProfileMapper;
import ru.itmo.loveconnect.entity.mapper.ProfileMapperImpl;
import ru.itmo.loveconnect.mail.MailService;
import ru.itmo.loveconnect.repo.UserRepository;
import ru.itmo.loveconnect.security.auth.UserToAuthenticatedUserMapper;
import ru.itmo.loveconnect.security.auth.principal.AuthenticatedUser;
import ru.itmo.loveconnect.security.jwt.JwtTokenProvider;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Objects;
import java.util.concurrent.ThreadLocalRandom;

@Service
@RequiredArgsConstructor
public final class AuthService {

    private final Cache<String, Integer> confirmationCodesCache =
            Caffeine.newBuilder()
                    .expireAfterWrite(Duration.ofHours(3))
                    .build();

    private final MailService mailService;
    private final JwtTokenProvider jwtTokenProvider;
    private final UserToAuthenticatedUserMapper userToAuthenticatedUserMapper;
    private final UserRepository userRepository;
    private final ProfileMapper profileMapper;

    public void sendConfirmationCode(String isuNumber) {
        if (confirmationCodesCache.getIfPresent(isuNumber) != null) {
            // isu code already sent
            return;
        }

        String email = isuNumber.concat("@niuitmo.ru");
        int otpCode = ThreadLocalRandom
                .current()
                .nextInt(1_000_000 - 100_000) + 100_000;
        confirmationCodesCache.put(isuNumber, otpCode);

        try {
            mailService.sendLoginConfirmationCode(email, String.valueOf(otpCode));
        } catch (MessagingException e) {
            throw new IllegalStateException("Cannot send confirmation code", e);
        }
    }

    public boolean isOtpCodeValid(String isuNumber, Integer otpCode) {
        Integer storedOtpCode = confirmationCodesCache.getIfPresent(isuNumber);
        return Objects.equals(storedOtpCode, otpCode);
    }

    public String loginUserIfOtpCodeValid(String isuNumber, Integer otpCode) {
        Integer storedOtpCode = confirmationCodesCache.getIfPresent(isuNumber);
        if (!Objects.equals(storedOtpCode, otpCode)) {
            throw new IllegalStateException("Illegal otp code");
        }

        UserEntity user = userRepository.findByIsuNumber(isuNumber).orElseThrow();
        AuthenticatedUser principal = userToAuthenticatedUserMapper.map(user);
        return jwtTokenProvider.generate(principal);
    }

    public String registerUserIfOtpCodeValid(String isuNumber,
                                             Integer otpCode,
                                             ProfileDto profile) {
        Integer storedOtpCode = confirmationCodesCache.getIfPresent(isuNumber);
        if (!Objects.equals(storedOtpCode, otpCode)) {
            throw new IllegalStateException("Illegal otp code");
        }

        UserEntity user = new UserEntity();
        user.setIsuNumber(isuNumber);
        user.setEmail(isuNumber + "@niuitmo.ru");
        user.setProfile(profileMapper.toEntity(profile));
        user.setLastLogin(LocalDateTime.now());
        user.setLastActive(LocalDateTime.now());
        user.setVerified(true);

        UserEntity registeredUser = userRepository.saveAndFlush(user);

        AuthenticatedUser principal = userToAuthenticatedUserMapper.map(registeredUser);
        return jwtTokenProvider.generate(principal);
    }

}
