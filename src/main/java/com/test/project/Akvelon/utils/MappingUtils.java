package com.test.project.Akvelon.utils;

import com.test.project.Akvelon.entity.Weather;
import com.test.project.Akvelon.entity.WeatherDto;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class MappingUtils {

    private MappingUtils(){}

    public static WeatherDto mapToWeatherDta(Weather weather) {

        WeatherDto weatherDto = new WeatherDto();
        weatherDto.setWeatherDescription(
                (String) weather.getWeather().stream()
                .map( mapa -> mapa.get("description")).findFirst().get()
        );
        weatherDto.setName(weather.getName());
        weatherDto.setWindSpeed(weather.getWind().get("speed"));
        weatherDto.setTemperature(weather.getMain().get("temp"));
        weatherDto.setTemperatureMin(weather.getMain().get("temp_min"));
        weatherDto.setTemperatureMax( weather.getMain().get("temp_max"));
        weatherDto.setCountry((String) weather.getSys().get("country"));
        return weatherDto;
    }

}
