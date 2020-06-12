package com.project.holyvacation.dto.weatherDto;

import lombok.Data;

import java.util.List;

@Data
public class WeatherDTO {
    private CurrentWeatherDTO current;
    private List<DailyWeatherDTO> daily;
}
