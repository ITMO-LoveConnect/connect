package ru.itmo.loveconnect.security.jwt;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.jetbrains.annotations.Nullable;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;
import ru.itmo.loveconnect.entity.UserEntity;
import ru.itmo.loveconnect.repo.UserRepository;
import ru.itmo.loveconnect.security.auth.UserToAuthenticatedUserMapper;
import ru.itmo.loveconnect.security.auth.principal.AuthenticatedUser;

import java.io.IOException;
import java.util.Optional;
import java.util.UUID;

@Slf4j
@RequiredArgsConstructor
@Component
public class JwtTokenAuthenticationFilter extends OncePerRequestFilter {

    private static final String AUTHORIZATION_HEADER = "Authorization";
    private static final String BEARER_PREFIX = "Bearer ";

    private final UserToAuthenticatedUserMapper userMapper;
    private final JwtTokenProvider jwtTokenProvider;
    private final UserRepository userRepository;

    @SuppressWarnings("NullableProblems")
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws ServletException, IOException {
        try {
            String jwtToken = extractBearerToken(request);

            if (jwtToken != null) {
                var userToken = jwtTokenProvider.validateTokenAndGetJws(jwtToken);
                if (userToken.isPresent()) {
                    var jws = userToken.get();

                    UUID userId = UUID.fromString(jws.getBody().get("id", String.class));

                    UserEntity user = userRepository.findById(userId).orElseThrow();
                    AuthenticatedUser principal = userMapper.map(user);

                    AuthenticatedUserAuthenticationToken authentication = new AuthenticatedUserAuthenticationToken(principal);
                    authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                    SecurityContextHolder.getContext().setAuthentication(authentication);
                }
            }
        } catch (Exception e) {
            log.warn("Authorization exception: {}", e.getMessage());
        }
        chain.doFilter(request, response);
    }

    @Nullable
    private String extractBearerToken(HttpServletRequest request) {
        return getTokenOrEmpty(request)
                .filter(header -> header.startsWith(BEARER_PREFIX))
                .map(header -> header.substring(BEARER_PREFIX.length()))
                .orElse(null);
    }

    private Optional<String> getTokenOrEmpty(HttpServletRequest request) {
        String tokenHeader = request.getHeader(AUTHORIZATION_HEADER);
        if (StringUtils.hasText(tokenHeader)) {
            return Optional.of(tokenHeader);
        }
        return Optional.empty();
    }
}