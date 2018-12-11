
package com.android.weatherapp.model.weatherbit.currentweather.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "wind_cdir",
    "rh",
    "pod",
    "lon",
    "pres",
    "timezone",
    "ob_time",
    "country_code",
    "clouds",
    "vis",
    "solar_rad",
    "state_code",
    "wind_spd",
    "lat",
    "wind_cdir_full",
    "slp",
    "datetime",
    "ts",
    "station",
    "h_angle",
    "dewpt",
    "snow",
    "uv",
    "dni",
    "wind_dir",
    "elev_angle",
    "ghi",
    "dhi",
    "precip",
    "city_name",
    "weather",
    "sunset",
    "temp",
    "sunrise",
    "app_temp"
})
public class Data {

    @JsonProperty("wind_cdir")
    private String windCdir;

    @JsonProperty("rh")
    private int rh;

    @JsonProperty("pod")
    private String pod;

    @JsonProperty("lon")
    private double lon;

    @JsonProperty("pres")
    private double pres;

    @JsonProperty("timezone")
    private String timezone;

    @JsonProperty("ob_time")
    private String obTime;

    @JsonProperty("country_code")
    private String countryCode;

    @JsonProperty("clouds")
    private int clouds;

    @JsonProperty("vis")
    private double vis;

    @JsonProperty("solar_rad")
    private int solarRad;

    @JsonProperty("state_code")
    private String stateCode;

    @JsonProperty("wind_spd")
    private int windSpd;

    @JsonProperty("lat")
    private double lat;

    @JsonProperty("wind_cdir_full")
    private String windCdirFull;

    @JsonProperty("slp")
    private double slp;

    @JsonProperty("datetime")
    private String datetime;

    @JsonProperty("ts")
    private int ts;

    @JsonProperty("station")
    private String station;

    @JsonProperty("h_angle")
    private int hAngle;

    @JsonProperty("dewpt")
    private double dewpt;

    @JsonProperty("snow")
    private int snow;

    @JsonProperty("uv")
    private int uv;

    @JsonProperty("dni")
    private int dni;

    @JsonProperty("wind_dir")
    private int windDir;

    @JsonProperty("elev_angle")
    private double elevAngle;

    @JsonProperty("ghi")
    private int ghi;

    @JsonProperty("dhi")
    private int dhi;

    @JsonProperty("precip")
    private double precip;

    @JsonProperty("city_name")
    private String cityName;

    @JsonProperty("weather")
    private Weather weather;

    @JsonProperty("sunset")
    private String sunset;

    @JsonProperty("temp")
    private int temp;

    @JsonProperty("sunrise")
    private String sunrise;

    @JsonProperty("app_temp")
    private int feelLikeTemp;

    @JsonProperty("wind_cdir")
    public String getWindCdir() {
        return windCdir;
    }

    @JsonProperty("wind_cdir")
    public void setWindCdir(String windCdir) {
        this.windCdir = windCdir;
    }

    @JsonProperty("rh")
    public int getRh() {
        return rh;
    }

    @JsonProperty("rh")
    public void setRh(int rh) {
        this.rh = rh;
    }

    @JsonProperty("pod")
    public String getPod() {
        return pod;
    }

    @JsonProperty("pod")
    public void setPod(String pod) {
        this.pod = pod;
    }

    @JsonProperty("lon")
    public double getLon() {
        return lon;
    }

    @JsonProperty("lon")
    public void setLon(double lon) {
        this.lon = lon;
    }

    @JsonProperty("pres")
    public double getPres() {
        return pres;
    }

    @JsonProperty("pres")
    public void setPres(double pres) {
        this.pres = pres;
    }

    @JsonProperty("timezone")
    public String getTimezone() {
        return timezone;
    }

    @JsonProperty("timezone")
    public void setTimezone(String timezone) {
        this.timezone = timezone;
    }

    @JsonProperty("ob_time")
    public String getObTime() {
        return obTime;
    }

    @JsonProperty("ob_time")
    public void setObTime(String obTime) {
        this.obTime = obTime;
    }

    @JsonProperty("country_code")
    public String getCountryCode() {
        return countryCode;
    }

    @JsonProperty("country_code")
    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    @JsonProperty("clouds")
    public int getClouds() {
        return clouds;
    }

    @JsonProperty("clouds")
    public void setClouds(int clouds) {
        this.clouds = clouds;
    }

    @JsonProperty("vis")
    public double getVis() {
        return vis;
    }

    @JsonProperty("vis")
    public void setVis(double vis) {
        this.vis = vis;
    }

    @JsonProperty("solar_rad")
    public int getSolarRad() {
        return solarRad;
    }

    @JsonProperty("solar_rad")
    public void setSolarRad(int solarRad) {
        this.solarRad = solarRad;
    }

    @JsonProperty("state_code")
    public String getStateCode() {
        return stateCode;
    }

    @JsonProperty("state_code")
    public void setStateCode(String stateCode) {
        this.stateCode = stateCode;
    }

    @JsonProperty("wind_spd")
    public int getWindSpd() {
        return windSpd;
    }

    @JsonProperty("wind_spd")
    public void setWindSpd(int windSpd) {
        this.windSpd = windSpd;
    }

    @JsonProperty("lat")
    public double getLat() {
        return lat;
    }

    @JsonProperty("lat")
    public void setLat(double lat) {
        this.lat = lat;
    }

    @JsonProperty("wind_cdir_full")
    public String getWindCdirFull() {
        return windCdirFull;
    }

    @JsonProperty("wind_cdir_full")
    public void setWindCdirFull(String windCdirFull) {
        this.windCdirFull = windCdirFull;
    }

    @JsonProperty("slp")
    public double getSlp() {
        return slp;
    }

    @JsonProperty("slp")
    public void setSlp(double slp) {
        this.slp = slp;
    }

    @JsonProperty("datetime")
    public String getDatetime() {
        return datetime;
    }

    @JsonProperty("datetime")
    public void setDatetime(String datetime) {
        this.datetime = datetime;
    }

    @JsonProperty("ts")
    public int getTs() {
        return ts;
    }

    @JsonProperty("ts")
    public void setTs(int ts) {
        this.ts = ts;
    }

    @JsonProperty("station")
    public String getStation() {
        return station;
    }

    @JsonProperty("station")
    public void setStation(String station) {
        this.station = station;
    }

    @JsonProperty("h_angle")
    public int getHAngle() {
        return hAngle;
    }

    @JsonProperty("h_angle")
    public void setHAngle(int hAngle) {
        this.hAngle = hAngle;
    }

    @JsonProperty("dewpt")
    public double getDewpt() {
        return dewpt;
    }

    @JsonProperty("dewpt")
    public void setDewpt(double dewpt) {
        this.dewpt = dewpt;
    }

    @JsonProperty("snow")
    public int getSnow() {
        return snow;
    }

    @JsonProperty("snow")
    public void setSnow(int snow) {
        this.snow = snow;
    }

    @JsonProperty("uv")
    public int getUv() {
        return uv;
    }

    @JsonProperty("uv")
    public void setUv(int uv) {
        this.uv = uv;
    }

    @JsonProperty("dni")
    public int getDni() {
        return dni;
    }

    @JsonProperty("dni")
    public void setDni(int dni) {
        this.dni = dni;
    }

    @JsonProperty("wind_dir")
    public int getWindDir() {
        return windDir;
    }

    @JsonProperty("wind_dir")
    public void setWindDir(int windDir) {
        this.windDir = windDir;
    }

    @JsonProperty("elev_angle")
    public double getElevAngle() {
        return elevAngle;
    }

    @JsonProperty("elev_angle")
    public void setElevAngle(double elevAngle) {
        this.elevAngle = elevAngle;
    }

    @JsonProperty("ghi")
    public int getGhi() {
        return ghi;
    }

    @JsonProperty("ghi")
    public void setGhi(int ghi) {
        this.ghi = ghi;
    }

    @JsonProperty("dhi")
    public int getDhi() {
        return dhi;
    }

    @JsonProperty("dhi")
    public void setDhi(int dhi) {
        this.dhi = dhi;
    }

    @JsonProperty("precip")
    public double getPrecip() {
        return precip;
    }

    @JsonProperty("precip")
    public void setPrecip(double precip) {
        this.precip = precip;
    }

    @JsonProperty("city_name")
    public String getCityName() {
        return cityName;
    }

    @JsonProperty("city_name")
    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    @JsonProperty("weather")
    public Weather getWeather() {
        return weather;
    }

    @JsonProperty("weather")
    public void setWeather(Weather weather) {
        this.weather = weather;
    }

    @JsonProperty("sunset")
    public String getSunset() {
        return sunset;
    }

    @JsonProperty("sunset")
    public void setSunset(String sunset) {
        this.sunset = sunset;
    }

    @JsonProperty("temp")
    public int getTemp() {
        return temp;
    }

    @JsonProperty("temp")
    public void setTemp(int temp) {
        this.temp = temp;
    }

    @JsonProperty("sunrise")
    public String getSunrise() {
        return sunrise;
    }

    @JsonProperty("sunrise")
    public void setSunrise(String sunrise) {
        this.sunrise = sunrise;
    }

    @JsonProperty("app_temp")
    public int getFeelLikeTemp() {
        return feelLikeTemp;
    }

    @JsonProperty("app_temp")
    public void setFeelLikeTemp(int feelLikeTemp) {
        this.feelLikeTemp = feelLikeTemp;
    }

}
