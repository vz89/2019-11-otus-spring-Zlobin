package com.project.holyvacation.dto.weatherDto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.project.holyvacation.utils.WeatherConverter;
import lombok.Data;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.List;

@Data
public class CurrentWeatherDTO {
    @JsonIgnore
    private long dt;
    private double temp;
    private List<WeatherDescriptionDTO> weather;
    private LocalDate date;

    public LocalDate getDate() {
        return Instant.ofEpochSecond(dt).atZone(ZoneId.systemDefault()).toLocalDate();
    }

    public double getTemp() {
        return WeatherConverter.kelvinToCelsiusConverter(this.temp);
    }
}
