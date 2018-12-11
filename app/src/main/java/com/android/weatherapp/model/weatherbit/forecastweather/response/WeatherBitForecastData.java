
package com.android.weatherapp.model.weatherbit.forecastweather.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "moonrise_ts",
    "wind_cdir",
    "rh",
    "pres",
    "sunset_ts",
    "ozone",
    "moon_phase",
    "wind_gust_spd",
    "snow_depth",
    "clouds",
    "ts",
    "sunrise_ts",
    "app_min_temp",
    "wind_spd",
    "pop",
    "wind_cdir_full",
    "slp",
    "app_max_temp",
    "vis",
    "dewpt",
    "snow",
    "uv",
    "valid_date",
    "wind_dir",
    "max_dhi",
    "clouds_hi",
    "precip",
    "weather",
    "max_temp",
    "moonset_ts",
    "datetime",
    "temp",
    "min_temp",
    "clouds_mid",
    "clouds_low"
})
public class WeatherBitForecastData {

    @JsonProperty("moonrise_ts")
    private int moonriseTs;
    @JsonProperty("wind_cdir")
    private String windCdir;
    @JsonProperty("rh")
    private int rh;
    @JsonProperty("pres")
    private double pres;
    @JsonProperty("sunset_ts")
    private int sunsetTs;
    @JsonProperty("ozone")
    private double ozone;
    @JsonProperty("moon_phase")
    private double moonPhase;
    @JsonProperty("wind_gust_spd")
    private double windGustSpd;
    @JsonProperty("snow_depth")
    private int snowDepth;
    @JsonProperty("clouds")
    private int clouds;
    @JsonProperty("ts")
    private int ts;
    @JsonProperty("sunrise_ts")
    private int sunriseTs;
    @JsonProperty("app_min_temp")
    private int appMinTemp;
    @JsonProperty("wind_spd")
    private double windSpd;
    @JsonProperty("pop")
    private int pop;
    @JsonProperty("wind_cdir_full")
    private String windCdirFull;
    @JsonProperty("slp")
    private double slp;
    @JsonProperty("app_max_temp")
    private double appMaxTemp;
    @JsonProperty("vis")
    private double vis;
    @JsonProperty("dewpt")
    private double dewpt;
    @JsonProperty("snow")
    private int snow;
    @JsonProperty("uv")
    private double uv;
    @JsonProperty("valid_date")
    private String validDate;
    @JsonProperty("wind_dir")
    private int windDir;
    @JsonProperty("max_dhi")
    private Object maxDhi;
    @JsonProperty("clouds_hi")
    private int cloudsHi;
    @JsonProperty("precip")
    private double precip;
    @JsonProperty("weather")
    private Weather weather;
    @JsonProperty("max_temp")
    private int maxTemp;
    @JsonProperty("moonset_ts")
    private int moonsetTs;
    @JsonProperty("datetime")
    private String datetime;
    @JsonProperty("temp")
    private double temp;
    @JsonProperty("min_temp")
    private double minTemp;
    @JsonProperty("clouds_mid")
    private int cloudsMid;
    @JsonProperty("clouds_low")
    private int cloudsLow;

    @JsonProperty("moonrise_ts")
    public int getMoonriseTs() {
        return moonriseTs;
    }

    @JsonProperty("moonrise_ts")
    public void setMoonriseTs(int moonriseTs) {
        this.moonriseTs = moonriseTs;
    }

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

    @JsonProperty("pres")
    public double getPres() {
        return pres;
    }

    @JsonProperty("pres")
    public void setPres(double pres) {
        this.pres = pres;
    }

    @JsonProperty("sunset_ts")
    public int getSunsetTs() {
        return sunsetTs;
    }

    @JsonProperty("sunset_ts")
    public void setSunsetTs(int sunsetTs) {
        this.sunsetTs = sunsetTs;
    }

    @JsonProperty("ozone")
    public double getOzone() {
        return ozone;
    }

    @JsonProperty("ozone")
    public void setOzone(double ozone) {
        this.ozone = ozone;
    }

    @JsonProperty("moon_phase")
    public double getMoonPhase() {
        return moonPhase;
    }

    @JsonProperty("moon_phase")
    public void setMoonPhase(double moonPhase) {
        this.moonPhase = moonPhase;
    }

    @JsonProperty("wind_gust_spd")
    public double getWindGustSpd() {
        return windGustSpd;
    }

    @JsonProperty("wind_gust_spd")
    public void setWindGustSpd(double windGustSpd) {
        this.windGustSpd = windGustSpd;
    }

    @JsonProperty("snow_depth")
    public int getSnowDepth() {
        return snowDepth;
    }

    @JsonProperty("snow_depth")
    public void setSnowDepth(int snowDepth) {
        this.snowDepth = snowDepth;
    }

    @JsonProperty("clouds")
    public int getClouds() {
        return clouds;
    }

    @JsonProperty("clouds")
    public void setClouds(int clouds) {
        this.clouds = clouds;
    }

    @JsonProperty("ts")
    public int getTs() {
        return ts;
    }

    @JsonProperty("ts")
    public void setTs(int ts) {
        this.ts = ts;
    }

    @JsonProperty("sunrise_ts")
    public int getSunriseTs() {
        return sunriseTs;
    }

    @JsonProperty("sunrise_ts")
    public void setSunriseTs(int sunriseTs) {
        this.sunriseTs = sunriseTs;
    }

    @JsonProperty("app_min_temp")
    public int getAppMinTemp() {
        return appMinTemp;
    }

    @JsonProperty("app_min_temp")
    public void setAppMinTemp(int appMinTemp) {
        this.appMinTemp = appMinTemp;
    }

    @JsonProperty("wind_spd")
    public double getWindSpd() {
        return windSpd;
    }

    @JsonProperty("wind_spd")
    public void setWindSpd(double windSpd) {
        this.windSpd = windSpd;
    }

    @JsonProperty("pop")
    public int getPop() {
        return pop;
    }

    @JsonProperty("pop")
    public void setPop(int pop) {
        this.pop = pop;
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

    @JsonProperty("app_max_temp")
    public double getAppMaxTemp() {
        return appMaxTemp;
    }

    @JsonProperty("app_max_temp")
    public void setAppMaxTemp(double appMaxTemp) {
        this.appMaxTemp = appMaxTemp;
    }

    @JsonProperty("vis")
    public double getVis() {
        return vis;
    }

    @JsonProperty("vis")
    public void setVis(double vis) {
        this.vis = vis;
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
    public double getUv() {
        return uv;
    }

    @JsonProperty("uv")
    public void setUv(double uv) {
        this.uv = uv;
    }

    @JsonProperty("valid_date")
    public String getValidDate() {
        return validDate;
    }

    @JsonProperty("valid_date")
    public void setValidDate(String validDate) {
        this.validDate = validDate;
    }

    @JsonProperty("wind_dir")
    public int getWindDir() {
        return windDir;
    }

    @JsonProperty("wind_dir")
    public void setWindDir(int windDir) {
        this.windDir = windDir;
    }

    @JsonProperty("max_dhi")
    public Object getMaxDhi() {
        return maxDhi;
    }

    @JsonProperty("max_dhi")
    public void setMaxDhi(Object maxDhi) {
        this.maxDhi = maxDhi;
    }

    @JsonProperty("clouds_hi")
    public int getCloudsHi() {
        return cloudsHi;
    }

    @JsonProperty("clouds_hi")
    public void setCloudsHi(int cloudsHi) {
        this.cloudsHi = cloudsHi;
    }

    @JsonProperty("precip")
    public double getPrecip() {
        return precip;
    }

    @JsonProperty("precip")
    public void setPrecip(double precip) {
        this.precip = precip;
    }

    @JsonProperty("weather")
    public Weather getWeather() {
        return weather;
    }

    @JsonProperty("weather")
    public void setWeather(Weather weather) {
        this.weather = weather;
    }

    @JsonProperty("max_temp")
    public int getMaxTemp() {
        return maxTemp;
    }

    @JsonProperty("max_temp")
    public void setMaxTemp(int maxTemp) {
        this.maxTemp = maxTemp;
    }

    @JsonProperty("moonset_ts")
    public int getMoonsetTs() {
        return moonsetTs;
    }

    @JsonProperty("moonset_ts")
    public void setMoonsetTs(int moonsetTs) {
        this.moonsetTs = moonsetTs;
    }

    @JsonProperty("datetime")
    public String getDatetime() {
        return datetime;
    }

    @JsonProperty("datetime")
    public void setDatetime(String datetime) {
        this.datetime = datetime;
    }

    @JsonProperty("temp")
    public double getTemp() {
        return temp;
    }

    @JsonProperty("temp")
    public void setTemp(double temp) {
        this.temp = temp;
    }

    @JsonProperty("min_temp")
    public double getMinTemp() {
        return minTemp;
    }

    @JsonProperty("min_temp")
    public void setMinTemp(double minTemp) {
        this.minTemp = minTemp;
    }

    @JsonProperty("clouds_mid")
    public int getCloudsMid() {
        return cloudsMid;
    }

    @JsonProperty("clouds_mid")
    public void setCloudsMid(int cloudsMid) {
        this.cloudsMid = cloudsMid;
    }

    @JsonProperty("clouds_low")
    public int getCloudsLow() {
        return cloudsLow;
    }

    @JsonProperty("clouds_low")
    public void setCloudsLow(int cloudsLow) {
        this.cloudsLow = cloudsLow;
    }

}
