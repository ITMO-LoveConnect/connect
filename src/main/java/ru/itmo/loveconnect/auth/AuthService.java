package ru.itmo.loveconnect.auth;

import com.github.benmanes.caffeine.cache.Cache;
import com.github.benmanes.caffeine.cache.Caffeine;
import jakarta.mail.MessagingException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.itmo.loveconnect.entity.UserEntity;
import ru.itmo.loveconnect.mail.MailService;
import ru.itmo.loveconnect.security.auth.UserToAuthenticatedUserMapper;
import ru.itmo.loveconnect.security.auth.principal.AuthenticatedUser;
import ru.itmo.loveconnect.security.jwt.JwtTokenProvider;

import java.time.Duration;
import java.util.Objects;
import java.util.concurrent.ThreadLocalRandom;

@Service
@RequiredArgsConstructor
public final class AuthService {

    private final Cache<Integer, Integer> confirmationCodesCache =
            Caffeine.newBuilder()
                    .expireAfterWrite(Duration.ofHours(3))
                    .build();

    private final MailService mailService;
    private final JwtTokenProvider jwtTokenProvider;
    private final UserToAuthenticatedUserMapper userToAuthenticatedUserMapper;

    public void sendConfirmationCode(Integer isuNumber) {
        if (confirmationCodesCache.getIfPresent(isuNumber) != null) {
            // isu code already sent
            return;
        }

        String email = isuNumber.toString().concat("@nuiitmo.ru");
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

    public String generateTokenIfOtpCodeValid(Integer isuNumber, Integer otpCode) {
        Integer storedOtpCode = confirmationCodesCache.getIfPresent(isuNumber);
        if (!Objects.equals(storedOtpCode, otpCode)) {
            throw new IllegalStateException("Illegal otp code");
        }
        // TODO get or create user
        UserEntity user = null;
        AuthenticatedUser principal = userToAuthenticatedUserMapper.map(user);
        return jwtTokenProvider.generate(principal);
    }

}
