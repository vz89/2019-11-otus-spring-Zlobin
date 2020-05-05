package com.project.holyvacation.client;

import com.project.holyvacation.dto.NewsDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

@Service
@RequiredArgsConstructor
public class NewsRestClientImpl implements NewsRestClient {

    private final RestTemplate restTemplate;

    @Value("${api.news.serverUrl}")
    private String serverUrl;

    @Value("${api.news.apiKey}")
    private String apiKey;

    @Override
    public NewsDTO getAllNewsByIso(String iso) {
        HttpHeaders headers = getHttpHeaders();
        UriComponentsBuilder builder = getUriComponentsBuilder(iso);
        HttpEntity<?> entity = new HttpEntity<>(headers);
        ResponseEntity<NewsDTO> response = getNewsDTOResponseEntity(builder, entity);
        return response.getBody();
    }

    private ResponseEntity<NewsDTO> getNewsDTOResponseEntity(UriComponentsBuilder builder, HttpEntity<?> entity) {
        return restTemplate.exchange(
                    builder.toUriString(),
                    HttpMethod.GET,
                    entity,
                    NewsDTO.class
            );
    }

    private UriComponentsBuilder getUriComponentsBuilder(String iso) {
        return UriComponentsBuilder
                    .fromHttpUrl(serverUrl)
                    .queryParam("country",iso);
    }

    private HttpHeaders getHttpHeaders() {
        HttpHeaders headers = new HttpHeaders();
        headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);
        headers.set("X-Api-Key", apiKey);
        return headers;
    }
}
