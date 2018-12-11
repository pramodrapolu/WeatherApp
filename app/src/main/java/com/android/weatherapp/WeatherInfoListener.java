package com.android.weatherapp;

public interface WeatherInfoListener {
    void onSuccess(Object T);

    void onFailure();
}
