package com.project.weatherApp.models;

public class Coordinates{ 

    private Double lat;

    private Double lon;

    private String city;

    private String country;

    public Double getLat(){
        return lat;
    }
    public void setLat(Double lat){
        this.lat = lat;
    }
    public Double getLon(){
        return lon;
    }
    public void setLon(Double lon){
        this.lon = lon;
    }
    public String getCity(){
        return city;
    }
    public void setCity(String city){
        this.city = city;
    }
    public String getCountry(){
        return country;
    }
    public void setCountry(String country){
        this.country = country;
    }
}
