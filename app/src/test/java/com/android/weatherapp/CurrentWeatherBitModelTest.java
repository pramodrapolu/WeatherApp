package com.android.weatherapp;

import com.android.weatherapp.api.Access;
import com.android.weatherapp.api.WeatherApi;
import com.android.weatherapp.model.weatherbit.currentweather.response.WeatherBitCurrentWeather;
import com.android.weatherapp.serviceprovider.WeatherBitProvider;

import org.junit.Before;
import org.junit.Test;

import io.reactivex.Single;
import io.reactivex.observers.TestObserver;

import static org.junit.Assert.assertEquals;

public class CurrentWeatherBitModelTest {
    private static final String CURRENT_WEATHER_BASE_URL = "https://api.weatherbit.io/";
    private static final String API_KEY = "4022c71a55414c13a2a0e1318e696783";
    private static final String UNITS = "I";

    private WeatherBitProvider mWeatherBitProvider;
    private Single<WeatherBitCurrentWeather> mCurrentSingle;
    private TestObserver<WeatherBitCurrentWeather> mTestObserver;

    @Before
    public void initSetup() {
        mWeatherBitProvider = new WeatherBitProvider();
        WeatherApi weatherApi = Access.getInstance().getWeatherApi(CURRENT_WEATHER_BASE_URL);
        mCurrentSingle = weatherApi.getCurrentWeatherBit("Boston",
                UNITS, API_KEY);
    }

    @Test
    public void testIfSuccessfullCall() {
        mTestObserver = mCurrentSingle.test();
        mTestObserver.awaitTerminalEvent();
        mTestObserver.assertNoErrors();
    }

    @Test
    public void testCityNameFromResponse() {
        WeatherBitCurrentWeather weatherBitCurrentWeather = mCurrentSingle.blockingGet();
        assertEquals("Boston", weatherBitCurrentWeather.getData().get(0).getCityName());

    }
}
