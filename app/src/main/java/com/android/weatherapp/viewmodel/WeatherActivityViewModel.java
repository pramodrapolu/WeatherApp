package com.android.weatherapp.viewmodel;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.content.Context;
import android.util.Log;

import com.android.weatherapp.WeatherInfoListener;
import com.android.weatherapp.model.CurrentWeather;
import com.android.weatherapp.model.ForecastWeatherData;
import com.android.weatherapp.notification.JobScheduleUtil;
import com.android.weatherapp.serviceprovider.WeatherProviderType;
import com.android.weatherapp.serviceprovider.WeatherServiceProvider;
import com.android.weatherapp.util.Logger;
import com.android.weatherapp.util.WeatherAppSharedPrefs;

/**
 * ViewModel with the LiveData's to observe on and get/prepare the data for the Views.
 */
public class WeatherActivityViewModel extends ViewModel implements WeatherInfoListener {

    private static final String TAG = WeatherActivityViewModel.class.getSimpleName();

    private MutableLiveData<String> mInputLiveData;
    private MutableLiveData<CurrentWeather> mCurrentWeatherLiveData;
    private MutableLiveData<ForecastWeatherData> mForecastWeatherLiveData;

    private WeatherServiceProvider mWeatherServiceProvider;

    /**
     * Returns the InputLiveData.
     *
     * @return mInputLiveData
     */
    public MutableLiveData<String> getInputLiveData() {
        if (mInputLiveData == null) {
            mInputLiveData = new MutableLiveData<>();

        }
        return mInputLiveData;
    }

    /**
     * Returns the CurrentWeatherLiveData and initiates the CurrentWeather call.
     *
     * @return mCurrentWeatherLiveData
     */
    public MutableLiveData<CurrentWeather> getCurrentWeatherLiveData() {
        if (mCurrentWeatherLiveData == null) {
            mCurrentWeatherLiveData = new MutableLiveData<>();
            if (getInputLocation() != null) {
                initiateCurrentWeatherCall(getInputLocation());
            }
        }
        return mCurrentWeatherLiveData;
    }

    /**
     * Returns the ForecastWeatherLiveData and initiates the forecast call.
     *
     * @return mForecastWeatherLiveData
     */
    public MutableLiveData<ForecastWeatherData> getForecastWeatherLiveData() {
        if (mForecastWeatherLiveData == null) {
            mForecastWeatherLiveData = new MutableLiveData<>();
            if (getInputLocation() != null) {
                initiateForecastWeatherCall(getInputLocation());
            }
        }
        return mForecastWeatherLiveData;
    }

    /**
     * Initiates the CurrentWeather Call
     *
     * @param cityName name of the city for the info.
     */
    public void initiateCurrentWeatherCall(String cityName) {
        // Get the Weather Provider instance by passing in the Weather Bit Provider type.
        mWeatherServiceProvider = WeatherServiceProvider.getWeatherProvider
                (WeatherProviderType.WEATHER_BIT);

        if (mWeatherServiceProvider != null) {
            if (cityName != null) {
                mWeatherServiceProvider.getCurrentWeatherInfo(cityName, this);
            }
        } else {
            Logger.log(Log.INFO, TAG, " WeatherServiceProvider Null");
        }
    }

    /**
     * Initiates the ForecastWeather Call
     *
     * @param cityName name of the city for the info.
     */
    public void initiateForecastWeatherCall(String cityName) {
        // Get the Weather Provider instance by passing in the Weather Bit Provider type.
        mWeatherServiceProvider = WeatherServiceProvider.getWeatherProvider
                (WeatherProviderType.WEATHER_BIT);

        if (mWeatherServiceProvider != null) {
            if (cityName != null) {
                mWeatherServiceProvider.getForecastWeatherInfo(cityName, this);
            }
        } else {
            Logger.log(Log.INFO, TAG, " WeatherServiceProvider Null");
        }

    }

    /**
     * Saves the InputLocation to the SharedPrefs.
     *
     * @param appicationContext Application Context
     * @param cityName          cityName name of the city.
     */
    public void saveInputLocation(Context appicationContext, String cityName) {
        // Schedule the Weather Update with the Job Scheduler to post the
        // notification.
        JobScheduleUtil.scheduleWeatherUpdate(appicationContext);
        WeatherAppSharedPrefs.getInstance().setInputLocation(cityName);
    }

    /**
     * Returns the InputLocation from the SharedPrefs.
     */
    public String getInputLocation() {
        return WeatherAppSharedPrefs.getInstance().getInputLocation();
    }

    @Override
    public void onSuccess(Object T) {
        // Check the Instance and post the model/data.
        if (T instanceof CurrentWeather) {
            CurrentWeather currentWeather = (CurrentWeather) T;

            mCurrentWeatherLiveData.postValue(currentWeather);

        } else if (T instanceof ForecastWeatherData) {
            ForecastWeatherData forecastWeatherData = (ForecastWeatherData) T;
            mForecastWeatherLiveData.postValue(forecastWeatherData);
        }
    }

    @Override
    public void onFailure() {
        mCurrentWeatherLiveData.postValue(null);
    }

    @Override
    protected void onCleared() {
        // Clear the Observers if any.
        mWeatherServiceProvider.clearObservers();
        super.onCleared();
    }
}
