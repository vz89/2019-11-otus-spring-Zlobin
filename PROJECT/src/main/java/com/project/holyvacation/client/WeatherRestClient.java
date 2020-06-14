package com.project.holyvacation.client;

import com.project.holyvacation.dto.WeatherDTO;

public interface WeatherRestClient {
    WeatherDTO getWeatherByLatLon(double lat, double lon);
}
