package com.project.holyvacation.dto;

import com.project.holyvacation.utils.WeatherConverter;
import lombok.Data;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.List;

@Data
public class WeatherDTO {
    private CurrentWeatherDTO current;
    private List<DailyWeatherDTO> daily;

    @Data
    private static class WeatherDescriptionDTO {
        private int id;
        private String main;
        private String description;
    }

    @Data
    private static class DailyWeatherDTO {
        private long dt;
        private TempDTO temp;
        private List<WeatherDescriptionDTO> weather;

        private LocalDate date;

        public LocalDate getDate() {
            return Instant.ofEpochSecond(this.dt).atZone(ZoneId.systemDefault()).toLocalDate();
        }
    }

    @Data
    private static class TempDTO {
        private double day;
        private double max;
        private double min;
        private double night;

        public double getDay() {
            return WeatherConverter.kelvinToCelsiusConverter(this.day);
        }

        public double getMax() {
            return WeatherConverter.kelvinToCelsiusConverter(this.max);
        }

        public double getMin() {
            return WeatherConverter.kelvinToCelsiusConverter(this.min);
        }

        public double getNight() {
            return WeatherConverter.kelvinToCelsiusConverter(this.night);
        }
    }

    @Data
    private static class CurrentWeatherDTO {
        private long dt;
        private double temp;
        private List<WeatherDescriptionDTO> weather;
        private LocalDate date;

        public LocalDate getDate() {
            return Instant.ofEpochSecond(this.dt).atZone(ZoneId.systemDefault()).toLocalDate();
        }

        public double getTemp() {
            return WeatherConverter.kelvinToCelsiusConverter(this.temp);
        }
    }
}
