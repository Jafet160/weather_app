package com.project.weatherApp.services;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import com.project.weatherApp.models.Coordinates;


@Service
public class CoordsService {

    private final RestTemplate restTemplate;

	public CoordsService(RestTemplateBuilder restTemplateBuilder) {
		this.restTemplate = restTemplateBuilder.build();
	}
    @Value("${city}")
    private String city;

    @Value("${country}")
    private String country;

    @Value("${API_KEY}")
    private String apiKey;

    @Value("${coords.api.url}")
    private String apiUrl;

    private String url;

    //Uses city and country from application.properties
    public Coordinates getDefaultCoordinates(){
        return getCoordinates(city, country);
    }

    public Coordinates getCoordinates(String city, String country) throws RestClientException {
        
        //Format url, limit=5 retrieves 5 same named cities (5 max)
        if (country == null) {
            url = String.format("%s%s&limit=1&appid=%s", apiUrl, city, apiKey);
        } else {
            url = String.format("%s%s,%s&limit=1&appid=%s", apiUrl, city, country, apiKey);
        }
        //JSON is in an array, need to convert to fetch data
        ResponseEntity<Coordinates[]> response = restTemplate.getForEntity(url, Coordinates[].class);
        
        if (response.getStatusCode().is2xxSuccessful()) {
            Coordinates[] coordsArray = response.getBody();
            Coordinates coordinateResponse = Arrays.asList(coordsArray).get(0);
            return coordinateResponse;
        } else {
            // Handle error response
            throw new RestClientException("Failed to fetch coordinates: " + response.getStatusCode());
        }
    }

    
}
