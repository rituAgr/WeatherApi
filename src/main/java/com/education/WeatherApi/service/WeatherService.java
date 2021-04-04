package com.education.WeatherApi.service;

import com.education.WeatherApi.model.Weather;

public interface WeatherService {
    Weather add(Weather weather);

    boolean fetch(Long id);
}
