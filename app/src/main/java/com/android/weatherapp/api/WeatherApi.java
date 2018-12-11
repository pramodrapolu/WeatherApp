package com.android.weatherapp.api;

import com.android.weatherapp.model.weatherbit.currentweather.response.WeatherBitCurrentWeather;
import com.android.weatherapp.model.weatherbit.forecastweather.response.WeatherBitForecastWeather;

import io.reactivex.Single;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Interface/API class with Query Methods.
 */
public interface WeatherApi {

    /**
     * Returns the Single of the Current Weather.
     *
     * @param cityName name of the city
     * @param units    units of the temperature
     * @param apiKey   api Key/clientID
     * @return Single of the Current Weather.
     */
    @GET("v2.0/current")
    Single<WeatherBitCurrentWeather> getCurrentWeatherBit(@Query("city") String cityName,
                                                          @Query("units") String units,
                                                          @Query("key") String apiKey);

    /**
     * Returns the Single of the Forecast Weather.
     *
     * @param cityName name of the city
     * @param units    units of the temperature
     * @param days     number of days forecast needed for
     * @param apiKey   api Key/clientID
     * @return Single of the Forecast Weather.
     */
    @GET("v2.0/forecast/daily")
    Single<WeatherBitForecastWeather> getForecastWeather(@Query("city") String cityName,
                                                         @Query("units") String units,
                                                         @Query("days") String days,
                                                         @Query("key") String apiKey);
}
