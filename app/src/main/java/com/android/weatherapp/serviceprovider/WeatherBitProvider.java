package com.android.weatherapp.serviceprovider;

import android.util.Log;

import com.android.weatherapp.WeatherInfoListener;
import com.android.weatherapp.api.Access;
import com.android.weatherapp.api.WeatherApi;
import com.android.weatherapp.model.CurrentWeather;
import com.android.weatherapp.model.ForecastWeather;
import com.android.weatherapp.model.ForecastWeatherData;
import com.android.weatherapp.model.weatherbit.currentweather.response.Data;
import com.android.weatherapp.model.weatherbit.currentweather.response.WeatherBitCurrentWeather;
import com.android.weatherapp.model.weatherbit.forecastweather.response.WeatherBitForecastData;
import com.android.weatherapp.model.weatherbit.forecastweather.response.WeatherBitForecastWeather;
import com.android.weatherapp.util.Logger;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * Provider Class specific for the WeatheBit Provider which does all the api calls and communicates
 * back to the view model using the listener.
 */
public class WeatherBitProvider extends WeatherServiceProvider {

    private static final String TAG = WeatherBitProvider.class.getSimpleName();

    private static final String WEATHER_PROVIDER_NAME = "Weather Bit";
    private static final String CURRENT_WEATHER_BASE_URL = "https://api.weatherbit.io/";
    private static final String FORECAST_WEATHER_BASE_URL = "https://api.weatherbit.io/";
    private static final String API_KEY = "4022c71a55414c13a2a0e1318e696783";
    private static final String NUMBER_OF_DAYS = "5";
    private static final String UNITS = "I";

    private Disposable mCurrentDisposable;
    private Disposable mForecastDisposable;

    @Override
    public boolean isForecastSupported() {
        return true;
    }

    /**
     * Initiates the Current Weather Call.
     *
     * @param city     name of the city.
     * @param listener to receive the response.
     */
    @Override
    public void getCurrentWeatherInfo(String city, final WeatherInfoListener listener) {
        WeatherApi weatherApi = Access.getInstance().getWeatherApi(CURRENT_WEATHER_BASE_URL);
        Single<WeatherBitCurrentWeather> currentSingle = weatherApi.getCurrentWeatherBit(city,
                UNITS, API_KEY);
        currentSingle.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
                .subscribe(new SingleObserver<WeatherBitCurrentWeather>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        mCurrentDisposable = d;
                    }

                    @Override
                    public void onSuccess(WeatherBitCurrentWeather weatherBitCurrentWeather) {
                        if (weatherBitCurrentWeather != null) {
                            Logger.log(Log.INFO, TAG, "onSuccess: " +
                                    weatherBitCurrentWeather.getData().get(0).getCityName());
                            listener.onSuccess(getCurrentWeather(weatherBitCurrentWeather));
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        e.printStackTrace();
                        Logger.log(Log.ERROR, TAG, "onError of the Current Weather Call");
                        listener.onFailure();
                    }
                });
    }

    /**
     * Initiates the Forecast Weather Call.
     *
     * @param city     name of the city.
     * @param listener to receive the response.
     */
    @Override
    public void getForecastWeatherInfo(String city, final WeatherInfoListener listener) {
        WeatherApi weatherApi = Access.getInstance().getWeatherApi(FORECAST_WEATHER_BASE_URL);
        Single<WeatherBitForecastWeather> forecastSingle = weatherApi.getForecastWeather(city,
                UNITS,
                NUMBER_OF_DAYS, API_KEY);
        forecastSingle.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
                .subscribe(new SingleObserver<WeatherBitForecastWeather>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        mForecastDisposable = d;
                    }

                    @Override
                    public void onSuccess(WeatherBitForecastWeather weatherBitForecastWeather) {
                        if (weatherBitForecastWeather != null) {
                            Logger.log(Log.INFO, TAG, "onSuccess: " +
                                    weatherBitForecastWeather.getCityName());
                            listener.onSuccess(getForecastWeather(weatherBitForecastWeather));
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        e.printStackTrace();
                        Logger.log(Log.ERROR, TAG, "onError of the Forecast Weather Call");
                        listener.onFailure();
                    }
                });
    }

    @Override
    public void clearObservers() {
        Logger.log(Log.INFO, TAG, "Clearing Observers");
        if (mCurrentDisposable != null && !mCurrentDisposable.isDisposed()) {
            mCurrentDisposable.dispose();
        }
        if (mForecastDisposable != null && !mForecastDisposable.isDisposed()) {
            mForecastDisposable.dispose();
        }
    }

    /**
     * Returns the Current Weather from the current weather response
     *
     * @param weatherBitCurrentWeather Response of the Current Weather call.
     * @return {@link CurrentWeather} model.
     */
    private CurrentWeather getCurrentWeather(WeatherBitCurrentWeather weatherBitCurrentWeather) {
        Logger.log(Log.INFO, TAG, "Setting up the CurrentWeather Model");
        CurrentWeather.Builder currentWeatherBuilder = new CurrentWeather.Builder();
        if (weatherBitCurrentWeather != null) {
            Data data = weatherBitCurrentWeather.getData().get(0);
            if (data != null) {
                currentWeatherBuilder.withWeatherProviderName(WEATHER_PROVIDER_NAME)
                        .withCurrentTemperature(String.valueOf(data.getTemp()))
                        .withFeelsLikeTemp(String.valueOf(data.getFeelLikeTemp()))
                        .withLocation(data.getCityName())
                        .withWindSpeed(String.valueOf(data.getWindSpd()))
                        .withWindDirection(data.getWindCdir());
            }
        }

        return currentWeatherBuilder.build();
    }

    /**
     * Returns the Forecast Weather from the forecast weather response.
     *
     * @param weatherBitForecastWeather Response from the Forecast Weather call.
     * @return {@link ForecastWeatherData} model.
     */
    private ForecastWeatherData getForecastWeather(WeatherBitForecastWeather
                                                           weatherBitForecastWeather) {
        Logger.log(Log.INFO, TAG, "Setting up the ForecastweatherData Model");
        ForecastWeatherData forecastWeatherData = new ForecastWeatherData();
        List<ForecastWeather> forecastWeatherList = new ArrayList<>();


        if (weatherBitForecastWeather != null && weatherBitForecastWeather.getData() != null &&
                weatherBitForecastWeather.getData
                        ().size() > 0) {
            for (WeatherBitForecastData weatherBitForecastData : weatherBitForecastWeather
                    .getData()) {
                ForecastWeather.Builder forecastWeatherBuilder = new ForecastWeather.Builder()
                        .withDate(weatherBitForecastData.getValidDate())
                        .withTemperature(String.valueOf(weatherBitForecastData.getTemp()))
                        .withMinTemp(String.valueOf(weatherBitForecastData.getMinTemp()))
                        .withMaxTemp(String.valueOf(weatherBitForecastData.getMaxTemp()));

                forecastWeatherList.add(forecastWeatherBuilder.build());
            }

            forecastWeatherData.setForecastCityName(weatherBitForecastWeather.getCityName());
            forecastWeatherData.setForecastWeather(forecastWeatherList);
        }

        return forecastWeatherData;
    }
}
