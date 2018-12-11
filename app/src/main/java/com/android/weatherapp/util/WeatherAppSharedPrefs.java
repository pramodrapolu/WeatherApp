package com.android.weatherapp.util;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;

import com.android.weatherapp.WeatherApp;

/**
 * Shared Prefs Util Class.
 */
public class WeatherAppSharedPrefs {

    private static WeatherAppSharedPrefs sInstance;
    private SharedPreferences mSharedPreferences;
    private SharedPreferences.Editor mSharedPreferencesEditor;

    @SuppressLint("CommitPrefEdits")
    private WeatherAppSharedPrefs() {
        if (sInstance != null) {
            throw new RuntimeException("Use getInstance() method to get the single instance " +
                    "of this class.");
        }
        mSharedPreferences = WeatherApp.getContext().getSharedPreferences(SharedPrefsConstants
                .WEATHER_APP_PREFERENCES, Context.MODE_PRIVATE);
        mSharedPreferencesEditor = mSharedPreferences.edit();
    }

    /**
     * Creates single instance of WeatherAppSharedPrefs.
     *
     * @return Returns instance of WeatherAppSharedPrefs.
     */
    public synchronized static WeatherAppSharedPrefs getInstance() {

        if (sInstance == null) {
            sInstance = new WeatherAppSharedPrefs();
        }
        return sInstance;
    }

    /**
     * Clears all the preferences stored.
     */
    public void clear() {
        mSharedPreferencesEditor.clear().apply();
    }

    public void setInputLocation(String location) {
        mSharedPreferencesEditor.putString(SharedPrefsConstants.INPUT_LOCATION, location);
        mSharedPreferencesEditor.apply();
    }

    public String getInputLocation() {
        return mSharedPreferences.getString(SharedPrefsConstants.INPUT_LOCATION, null);
    }

    /**
     * Inner class to maintain all the constants.
     */
    private class SharedPrefsConstants {
        private static final String WEATHER_APP_PREFERENCES = "WeatherAppPreferences";

        private static final String INPUT_LOCATION = "InputLocation";

    }
}
