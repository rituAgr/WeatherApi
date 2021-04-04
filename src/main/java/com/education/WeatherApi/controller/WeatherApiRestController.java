package com.education.WeatherApi.controller;

import com.education.WeatherApi.model.Weather;
import com.education.WeatherApi.service.LocationService;
import com.education.WeatherApi.service.WeatherService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WeatherApiRestController {

    private LocationService locationService;
    private WeatherService weatherService;

    WeatherApiRestController(LocationService locationService,WeatherService weatherService){
        this.locationService = locationService;
        this.weatherService=weatherService;
    }

    @PostMapping("/weather")
    public ResponseEntity<Weather> addWeather(@RequestBody Weather weather) {

        Long id = weather.getId();
        if(weatherService.fetch(id))
            return new ResponseEntity<Weather>(HttpStatus.BAD_REQUEST);
        Weather responseWeather = weatherService.add(weather);
        ResponseEntity<Weather> responseEntity = new ResponseEntity<Weather>(responseWeather, HttpStatus.CREATED);
        return responseEntity;
    }
}
