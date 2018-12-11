package com.android.weatherapp;

import com.android.weatherapp.api.Access;
import com.android.weatherapp.api.WeatherApi;
import com.android.weatherapp.model.weatherbit.currentweather.response.WeatherBitCurrentWeather;
import com.android.weatherapp.model.weatherbit.forecastweather.response.WeatherBitForecastWeather;
import com.android.weatherapp.serviceprovider.WeatherBitProvider;

import org.junit.Before;
import org.junit.Test;

import io.reactivex.Single;
import io.reactivex.observers.TestObserver;

import static org.junit.Assert.assertEquals;

public class ForecastWeatherBitModelTest {
    private static final String CURRENT_WEATHER_BASE_URL = "https://api.weatherbit.io/";
    private static final String API_KEY = "4022c71a55414c13a2a0e1318e696783";
    private static final String NUMBER_OF_DAYS = "5";
    private static final String UNITS = "I";

    private Single<WeatherBitForecastWeather> mForecastSingle;

    @Before
    public void initSetup() {
        WeatherBitProvider mWeatherBitProvider = new WeatherBitProvider();
        WeatherApi weatherApi = Access.getInstance().getWeatherApi(CURRENT_WEATHER_BASE_URL);
        mForecastSingle = weatherApi.getForecastWeather("Boston",
                UNITS, NUMBER_OF_DAYS, API_KEY);
    }

    @Test
    public void testIfSuccessfullCall() {
        TestObserver<WeatherBitForecastWeather> mTestObserver = mForecastSingle.test();
        mTestObserver.awaitTerminalEvent();
        mTestObserver.assertNoErrors();
    }

    @Test
    public void testCityNameFromResponse() {
        WeatherBitForecastWeather weatherBitForecastWeather = mForecastSingle.blockingGet();
        assertEquals("Boston", weatherBitForecastWeather.getCityName());
        assertEquals(5, weatherBitForecastWeather.getData().size());

    }
}
