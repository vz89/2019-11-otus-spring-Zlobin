package com.project.holyvacation.service;

import com.project.holyvacation.dto.weatherDto.WeatherDTO;

public interface WeatherService {
    WeatherDTO getWeatherByLatLon(double lat, double lon);

}
