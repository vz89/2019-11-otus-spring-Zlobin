package com.project.holyvacation.client;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

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

        return restTemplate.getForObject(serverUrl + "?" + "lat=" + lat + "&" + "lon=" + lon + "&" + "exclude=minutely,hourly" + "&" + "appid=" + apiKey, Object.class);
    }

}
