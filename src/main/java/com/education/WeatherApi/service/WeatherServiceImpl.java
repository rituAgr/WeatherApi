package com.education.WeatherApi.service;

import com.education.WeatherApi.model.Weather;
import com.education.WeatherApi.repository.WeatherRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class WeatherServiceImpl implements WeatherService {
    private WeatherRepository repository;

    public WeatherServiceImpl(WeatherRepository repository){
        this.repository = repository;
    }


    public Weather add(Weather weather) {
        return repository.save(weather);
    }

    public boolean fetch(Long id) {
        boolean res = repository.exists(id);
        return res;
    }

    @Override
    public List<Weather> getAllWeather() {
        return (List<Weather>) repository.findAll();
    }
}
