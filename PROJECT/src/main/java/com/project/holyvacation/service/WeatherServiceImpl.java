package com.project.holyvacation.service;

import com.project.holyvacation.client.WeatherRestClient;
import com.project.holyvacation.dto.WeatherDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class WeatherServiceImpl implements WeatherService {

    private final WeatherRestClient weatherRestClient;

    @Override
    public WeatherDTO getWeatherByLatLon(double lat, double lon) {
        return weatherRestClient.getWeatherByLatLon(lat,lon);
    }
}
