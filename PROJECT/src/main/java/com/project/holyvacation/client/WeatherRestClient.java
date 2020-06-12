package com.project.holyvacation.client;

import com.project.holyvacation.dto.weatherDto.WeatherDTO;

public interface WeatherRestClient {
    WeatherDTO getWeatherByLatLon(double lat, double lon);
}
