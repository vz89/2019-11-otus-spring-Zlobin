package com.project.holyvacation.client;

public interface WeatherRestClient {
    String getWeatherByLatLon(double lat, double lon);
}
