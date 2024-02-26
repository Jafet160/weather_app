package com.project.weatherApp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClientException;

import com.project.weatherApp.models.Weather;
import com.project.weatherApp.services.WeatherService;


@RestController
public class WeatherController {

    private final WeatherService weatherService;

    public WeatherController(WeatherService weatherService) {
        this.weatherService = weatherService;
    }

    @Autowired
    WeatherService weathersService;

    @CrossOrigin(origins = "http://localhost:3000") //Permission to client to fetch data
    @GetMapping("/weather/default")
    public ResponseEntity<Weather> getDefaultWeather() {
        try {
            Weather weather = weatherService.getDefaultWeather();
            return ResponseEntity.ok(weather);
        } catch (RestClientException e) {
            // Log the error or handle it as appropriate
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }
    @CrossOrigin(origins = "http://localhost:3000") //Permission to client to fetch data
    @GetMapping("/weather")
    public ResponseEntity<Weather> getUpdatedWeather(@RequestParam("city") String city, 
                                    @RequestParam(value ="country", required = false) String country){
        try {
            Weather weather = weatherService.getUpdatedWeather(city, country);
            return ResponseEntity.ok(weather);
        } catch (RestClientException e) {
            // Log the error or handle it as appropriate
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }
}
