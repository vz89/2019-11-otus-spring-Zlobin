package com.project.holyvacation.service;

import com.project.holyvacation.client.WeatherRestClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class WeatherServiceImpl implements WeatherService {

    private final WeatherRestClient weatherRestClient;

    @Override
    public String getWeatherByLatLon(double lat, double lon) {
        return weatherRestClient.getWeatherByLatLon(lat,lon);
    }
}
