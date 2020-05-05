package com.project.holyvacation.client;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

@Service
@RequiredArgsConstructor
public class WeatherRestClientImpl implements WeatherRestClient {

    private final RestTemplate restTemplate;

    @Value("${api.weather.serverUrl}")
    private String serverUrl;

    @Value("${api.weather.apiKey}")
    private String apiKey;

    @Override
    public Object getWeatherByLatLon(double lat, double lon) {
        UriComponentsBuilder builder = getUriComponentsBuilder(lat, lon, apiKey);
        ResponseEntity<Object> response = getNewsDTOResponseEntity(builder);
        return response.getBody();
    }


    private ResponseEntity<Object> getNewsDTOResponseEntity(UriComponentsBuilder builder) {
        return restTemplate.exchange(
                builder.toUriString(),
                HttpMethod.GET,
                null,
                Object.class
        );
    }

    private UriComponentsBuilder getUriComponentsBuilder(double lat, double lon, String apiKey) {
        return UriComponentsBuilder
                .fromHttpUrl(serverUrl)
                .queryParam("lat", lat)
                .queryParam("lon", lon)
                .queryParam("appid", apiKey);
    }

}
