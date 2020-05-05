package com.project.holyvacation.client;

public interface WeatherRestClient {
    Object getWeatherByLatLon(double lat, double lon);
}
