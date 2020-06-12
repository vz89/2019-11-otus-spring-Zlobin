package com.project.holyvacation.dto.weatherDto;

import com.project.holyvacation.utils.WeatherConverter;
import lombok.Data;

@Data
public class TempDTO {
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
