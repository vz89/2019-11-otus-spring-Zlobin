package com.project.holyvacation.service;

import com.project.holyvacation.dto.NewsDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Map;

@RequiredArgsConstructor
@Service
public class RestClientServiceImpl implements RestClientService {

    private final RestTemplate restTemplate;


    @Override
    public Object getResponseBody() {
        return null;
    }

    @Override
    public ResponseEntity<?> getResponseEntity(UriComponentsBuilder builder, HttpEntity<?> entity) {
        return restTemplate.exchange(
                builder.toUriString(),
                HttpMethod.GET,
                entity,
                NewsDTO.class
        );
    }

    @Override
    public UriComponentsBuilder getUriComponentsBuilder(String serverUrl, String iso) {
        return UriComponentsBuilder
                .fromHttpUrl(serverUrl)
                .queryParam("country", iso);
    }

    @Override
    public HttpHeaders getHttpHeaders(Map<?, ?> headers) {
        return null;
    }
}
