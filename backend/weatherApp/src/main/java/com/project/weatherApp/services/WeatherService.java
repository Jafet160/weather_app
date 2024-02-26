package com.project.weatherApp.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import com.project.weatherApp.models.Coordinates;
import com.project.weatherApp.models.Weather;



@Service
public class WeatherService {

    private final RestTemplate restTemplate;

	public WeatherService(RestTemplateBuilder restTemplateBuilder) {
		this.restTemplate = restTemplateBuilder.build();
	}

    @Autowired
    private CoordsService coordsService;

    @Value("${API_KEY}")
    private String apiKey;

    @Value("${weather.api.url}")
    private String weatherApiUrl;

    

    public Weather getDefaultWeather() throws RestClientException {
        
        Coordinates coordinates = coordsService.getDefaultCoordinates();
        //Format url
        String url = String.format("%slat=%s&lon=%s&appid=%s&units=imperial", weatherApiUrl, coordinates.getLat(), coordinates.getLon(), apiKey);

        ResponseEntity<Weather> response = restTemplate.getForEntity(url, Weather.class);
        
        if (response.getStatusCode().is2xxSuccessful()) {
            return response.getBody();
        } else {
            // Handle error response
            throw new RestClientException("Failed to fetch weather data: " + response.getStatusCode());
        }
    }
    public Weather getUpdatedWeather(String city, String country) throws RestClientException {

        Coordinates coordinates = coordsService.getCoordinates(city, country);
        //Format url
        String url = String.format("%slat=%s&lon=%s&appid=%s&units=imperial", weatherApiUrl, coordinates.getLat(), coordinates.getLon(), apiKey);

        ResponseEntity<Weather> response = restTemplate.getForEntity(url, Weather.class);
        
        if (response.getStatusCode().is2xxSuccessful()) {
            return response.getBody();
        } else {
            // Handle error response
            throw new RestClientException("Failed to fetch weather data: " + response.getStatusCode());
        }
    }
    
}
