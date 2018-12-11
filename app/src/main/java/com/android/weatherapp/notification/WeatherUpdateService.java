package com.android.weatherapp.notification;

import android.app.job.JobParameters;
import android.app.job.JobService;
import android.util.Log;

import com.android.weatherapp.WeatherInfoListener;
import com.android.weatherapp.model.CurrentWeather;
import com.android.weatherapp.serviceprovider.WeatherProviderType;
import com.android.weatherapp.serviceprovider.WeatherServiceProvider;
import com.android.weatherapp.util.WeatherAppSharedPrefs;

public class WeatherUpdateService extends JobService implements WeatherInfoListener {

    private WeatherServiceProvider mWeatherServiceProvider;
    private JobParameters mJobParams;

    @Override
    public boolean onStartJob(JobParameters params) {
        mJobParams = params;

        mWeatherServiceProvider = WeatherServiceProvider.getWeatherProvider
                (WeatherProviderType.WEATHER_BIT);

        if (mWeatherServiceProvider != null) {
            if (getInputLocation() != null) {
                mWeatherServiceProvider.getCurrentWeatherInfo(getInputLocation(), this);
            }
            return true;
        } else {
            Log.d("JobService", "initiateCurrentWeatherCall: null");
            jobFinished(params, false);
        }

        return false;
    }

    @Override
    public boolean onStopJob(JobParameters params) {
        return false;
    }

    private String getInputLocation() {
        return WeatherAppSharedPrefs.getInstance().getInputLocation();
    }

    @Override
    public void onSuccess(Object T) {
        CurrentWeather currentWeather = (CurrentWeather) T;
        if (currentWeather != null) {
            NotificationUtil.createNotification(currentWeather, getApplicationContext());
        }
        jobFinished(mJobParams, false);
    }

    @Override
    public void onFailure() {
        jobFinished(mJobParams, false);
    }
}
