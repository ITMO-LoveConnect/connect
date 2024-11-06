package ru.itmo.loveconnect.security.jwt;

import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;
import io.jsonwebtoken.security.SignatureException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import ru.itmo.loveconnect.security.auth.principal.AuthenticatedUser;

import java.time.Clock;
import java.time.ZonedDateTime;
import java.util.Date;
import java.util.Optional;
import java.util.UUID;

@Slf4j
@Component
public class JwtTokenProvider {

    public static final String TOKEN_TYPE = "JWT";
    public static final String TOKEN_ISSUER = "itmo-loveconnect";

    @Value("${app.jwt.secret}")
    private String jwtSecret;

    public String generate(AuthenticatedUser authenticatedUser) {
        byte[] signingKey = jwtSecret.getBytes();

        return Jwts.builder()
                .setHeaderParam("typ", TOKEN_TYPE)
                .signWith(Keys.hmacShaKeyFor(signingKey), SignatureAlgorithm.HS512)
                .setExpiration(Date.from(ZonedDateTime
                        .now(Clock.systemUTC())
                        .plusDays(180)
                        .toInstant()))
                .setIssuedAt(Date.from(ZonedDateTime.now(Clock.systemUTC()).toInstant()))
                .setId(UUID.randomUUID().toString())
                .setIssuer(TOKEN_ISSUER)
                .setSubject(authenticatedUser.getEmail())
                .claim("id", authenticatedUser.getUserId())
                .claim("email", authenticatedUser.getEmail())
                .claim("isu_number", authenticatedUser.getIsuNumber())
                .compact();
    }

    public Optional<Jws<Claims>> validateTokenAndGetJws(String token) {
        try {
            byte[] signingKey = jwtSecret.getBytes();

            Jws<Claims> jws = Jwts.parserBuilder()
                    .setSigningKey(signingKey)
                    .build()
                    .parseClaimsJws(token);

            return Optional.of(jws);
        } catch (ExpiredJwtException exception) {
            log.warn("Request to parse expired JWT : {} failed : {}", token, exception.getMessage());
        } catch (UnsupportedJwtException exception) {
            log.warn("Request to parse unsupported JWT : {} failed : {}", token, exception.getMessage());
        } catch (MalformedJwtException ignored) {

        } catch (SignatureException exception) {
            log.warn("Request to parse JWT with invalid signature : {} failed : {}", token, exception.getMessage());
        } catch (IllegalArgumentException exception) {
            log.warn("Request to parse empty or null JWT : {} failed : {}", token, exception.getMessage());
        }
        return Optional.empty();
    }

}