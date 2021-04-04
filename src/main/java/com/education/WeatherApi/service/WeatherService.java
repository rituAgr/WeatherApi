package com.education.WeatherApi.service;

import com.education.WeatherApi.model.Weather;

import java.util.List;

public interface WeatherService {
    Weather add(Weather weather);

    boolean fetch(Long id);

    List<Weather> getAllWeather();
}
