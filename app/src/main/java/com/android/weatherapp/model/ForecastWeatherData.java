package com.android.weatherapp.model;

import java.util.List;

/**
 * Custom Object with the Data required for the Forecast Weather Data with list of
 * {@link ForecastWeather}.
 */
public class ForecastWeatherData {

    private String forecastCityName;

    private List<ForecastWeather> forecastWeather;

    public String getForecastCityName() {
        return forecastCityName;
    }

    public void setForecastCityName(String forecastCityName) {
        this.forecastCityName = forecastCityName;
    }

    public List<ForecastWeather> getForecastWeather() {
        return forecastWeather;
    }

    public void setForecastWeather(List<ForecastWeather> forecastWeather) {
        this.forecastWeather = forecastWeather;
    }
}
