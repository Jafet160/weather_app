package com.project.weatherApp.models;

import java.util.List;

public class Weather {

    //City name
    private String name;

    //Timestamp
    private Long dt;

    //Timezone
    private Long timezone;

    //Nested temp
    private Main main;

    //Nested description
    private List<WeatherDescription> weather;

    //Nested country, sunrise, sunset
    private Sys sys;

    // Getters and setters for Weather class
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getDt() {
        return dt;
    }

    public void setDT(Long dt){
        this.dt = dt;
    }

    public Long getTimezone() {
        return timezone;
    }

    public void setTimezone(Long timezone){
        this.timezone = timezone;
    }

    public Main getMain() {
        return main;
    }

    public void setMain(Main main) {
        this.main = main;
    }

    public List<WeatherDescription> getWeather() {
        return weather;
    }

    public void setWeather(List<WeatherDescription> weather) {
        this.weather = weather;
    }

    public Sys getSys() {
        return sys;
    }

    public void setSys(Sys sys) {
        this.sys = sys;
    }

    // Nested Main class
    public static class Main {
        private Double temp;

        public Double getTemp() {
            return temp;
        }

        public void setTemp(Double temp) {
            this.temp = temp;
        }
    }

    // Nested WeatherDescription class
    public static class WeatherDescription {
        private String description;

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }
    }

    // Nested Sys class
    public static class Sys {
        private String country;
        private Long sunrise;
        private Long sunset;

        public String getCountry() {
            return country;
        }

        public void setCountry(String country) {
            this.country = country;
        }

        public Long getSunrise() {
            return sunrise;
        }

        public void setSunrise(Long sunrise) {
            this.sunrise = sunrise;
        }

        public Long getSunset() {
            return sunset;
        }

        public void setSunset(Long sunset) {
            this.sunset = sunset;
        }
    }
}
