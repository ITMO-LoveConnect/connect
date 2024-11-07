package ru.itmo.loveconnect.isu;

import com.fasterxml.jackson.databind.node.ObjectNode;
import jakarta.annotation.PostConstruct;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestClient;

import java.util.concurrent.TimeUnit;

@Service
@RequiredArgsConstructor
public class IsuTokenProvider {

    private final RestClient restClient = RestClient.create();

    private @Getter String accessToken;

    @Value("${app.isu-refresh-token}")
    public String refreshToken;

    @Scheduled(fixedRate = 10, timeUnit = TimeUnit.MINUTES)
    public void updateAccessToken() {
        doUpdate();
    }

    @PostConstruct
    private void doUpdate() {
        MultiValueMap<String, String> map= new LinkedMultiValueMap<>();
        map.add("grant_type", "refresh_token");
        map.add("client_id", "student-personal-cabinet");
        map.add("refresh_token", refreshToken);

        var response = restClient.post()
                .uri("https://id.itmo.ru/auth/realms/itmo/protocol/openid-connect/token")
                .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                .body(map)
                .retrieve()
                .toEntity(ObjectNode.class);
        if (!response.getStatusCode().is2xxSuccessful() || response.getBody() == null) {
            throw new IllegalStateException("Cannot update access token: " + response);
        }
        accessToken = response.getBody().path("access_token").textValue();
    }

}
