
package com.android.weatherapp.model.weatherbit.forecastweather.response;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "data",
    "city_name",
    "lon",
    "timezone",
    "lat",
    "country_code",
    "state_code"
})
public class WeatherBitForecastWeather {

    @JsonProperty("data")
    private List<WeatherBitForecastData> data = null;
    @JsonProperty("city_name")
    private String cityName;
    @JsonProperty("lon")
    private String lon;
    @JsonProperty("timezone")
    private String timezone;
    @JsonProperty("lat")
    private String lat;
    @JsonProperty("country_code")
    private String countryCode;
    @JsonProperty("state_code")
    private String stateCode;

    @JsonProperty("data")
    public List<WeatherBitForecastData> getData() {
        return data;
    }

    @JsonProperty("data")
    public void setData(List<WeatherBitForecastData> data) {
        this.data = data;
    }

    @JsonProperty("city_name")
    public String getCityName() {
        return cityName;
    }

    @JsonProperty("city_name")
    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    @JsonProperty("lon")
    public String getLon() {
        return lon;
    }

    @JsonProperty("lon")
    public void setLon(String lon) {
        this.lon = lon;
    }

    @JsonProperty("timezone")
    public String getTimezone() {
        return timezone;
    }

    @JsonProperty("timezone")
    public void setTimezone(String timezone) {
        this.timezone = timezone;
    }

    @JsonProperty("lat")
    public String getLat() {
        return lat;
    }

    @JsonProperty("lat")
    public void setLat(String lat) {
        this.lat = lat;
    }

    @JsonProperty("country_code")
    public String getCountryCode() {
        return countryCode;
    }

    @JsonProperty("country_code")
    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    @JsonProperty("state_code")
    public String getStateCode() {
        return stateCode;
    }

    @JsonProperty("state_code")
    public void setStateCode(String stateCode) {
        this.stateCode = stateCode;
    }

}
