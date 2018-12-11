package com.android.weatherapp.serviceprovider;

import com.android.weatherapp.WeatherInfoListener;

/**
 * Abstract Class which has all the methods which will be used by the respective WeatherProvider.
 */
public abstract class WeatherServiceProvider {

    public abstract boolean isForecastSupported();

    /**
     * Initiates the Respective Current Weather Call.
     *
     * @param city     name of the city.
     * @param listener to receive the response.
     */
    public abstract void getCurrentWeatherInfo(String city, WeatherInfoListener listener);

    /**
     * Initiates the Respective Forecast Weather Call.
     *
     * @param city     name of the city.
     * @param listener to receive the response.
     */
    public abstract void getForecastWeatherInfo(String city, WeatherInfoListener listener);

    public abstract void clearObservers();

    /**
     * Returns the Specific WeatherProvider based on the type passed in.
     *
     * @param weatherProvider type of the provider
     * @return Specific Provider
     */
    public synchronized static WeatherServiceProvider getWeatherProvider(@WeatherProviderType
                                                                                 String
                                                                                 weatherProvider) {

        if (weatherProvider.equals(WeatherProviderType.WEATHER_BIT)) {
            return new WeatherBitProvider();
        }

        return null;

    }
}
