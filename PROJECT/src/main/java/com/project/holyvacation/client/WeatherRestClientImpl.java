package com.project.holyvacation.client;

import com.project.holyvacation.dto.WeatherDTO;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class WeatherRestClientImpl implements WeatherRestClient {

    private final RestTemplate restTemplate;
    private final String serverUrl;
    private final String apiKey;

    public WeatherRestClientImpl(RestTemplate restTemplate, @Value("${api.weather.serverUrl}") String serverUrl, @Value("${api.weather.apiKey}") String apiKey) {
        this.restTemplate = restTemplate;
        this.serverUrl = serverUrl;
        this.apiKey = apiKey;
    }

    @Override
    public WeatherDTO getWeatherByLatLon(double lat, double lon) {
        return restTemplate.getForObject(serverUrl + "?" + "lat=" + lat + "&" + "lon=" + lon + "&" + "exclude=minutely,hourly" + "&" + "appid=" + apiKey, WeatherDTO.class);
    }

}
