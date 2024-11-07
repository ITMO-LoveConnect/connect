package ru.itmo.loveconnect.isu;

import com.fasterxml.jackson.databind.node.ObjectNode;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;
import ru.itmo.loveconnect.dto.IsuReportDto;
import ru.itmo.loveconnect.entity.enums.Gender;

@Service
@RequiredArgsConstructor
public class IsuService {

    private final RestClient restClient = RestClient.create();
    private final IsuTokenProvider isuTokenProvider;

    public IsuReportDto getIsuReport(String isuNumber) {
        var response = restClient.get()
                .uri("https://my.itmo.ru/api/personalities/persons/" + isuNumber)
                .accept(MediaType.APPLICATION_JSON)
                .header("Accept-Language", "ru")
                .header("Authorization", "Bearer ".concat(isuTokenProvider.getAccessToken()))
                .retrieve()
                .toEntity(ObjectNode.class);
        if (!response.getStatusCode().is2xxSuccessful() || response.getBody() == null) {
            throw new IllegalStateException("Cannot find ISU profile: " + isuNumber);
        }

        var responseBody = response.getBody();
        var educationNode = responseBody.path("result").path("education").get(0);

        return new IsuReportDto(
                responseBody.path("result").path("fio").textValue(),
                Gender.valueOf(responseBody.path("result").path("gender").textValue().toUpperCase()),
                educationNode.path("faculty_name").textValue(),
                educationNode.path("group").textValue(),
                educationNode.path("course").textValue()
        );
    }

}
