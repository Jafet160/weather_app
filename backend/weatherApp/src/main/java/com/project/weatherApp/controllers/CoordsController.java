package com.project.weatherApp.controllers;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.project.weatherApp.models.Coordinates;
import com.project.weatherApp.services.CoordsService;


@RestController
public class CoordsController {

    private final CoordsService coordsService;

    public CoordsController(CoordsService coordsService) {
        this.coordsService = coordsService;
    }

    @CrossOrigin(origins = "http://localhost:3000") //Permission to client to fetch data
    @GetMapping("/coordinates")
    public Coordinates getCoordinates(@RequestParam("city") String city,
                                     @RequestParam(value = "country", required = false) String country) {
        return coordsService.getCoordinates(city, country);
    }




   
}
