package com.android.weatherapp.serviceprovider;

import android.support.annotation.StringDef;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * Weather Provider Type.
 */
@Retention(RetentionPolicy.SOURCE)
@StringDef({WeatherProviderType.WEATHER_BIT})
public @interface WeatherProviderType {

    public static final String WEATHER_BIT = "Weather bit";
}
