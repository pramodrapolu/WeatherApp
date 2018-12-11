package com.android.weatherapp;

import android.app.Application;
import android.content.Context;

/**
 * Weather Application Class.
 */
public class WeatherApp extends Application {

    private static Context mContext;

    @Override
    public void onCreate() {
        super.onCreate();
        mContext = this;
    }

    public static Context getContext() {
        return mContext;
    }
}
