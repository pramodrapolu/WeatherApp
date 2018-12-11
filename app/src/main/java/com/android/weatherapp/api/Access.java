package com.android.weatherapp.api;

import android.util.Log;

import com.android.weatherapp.util.Logger;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.jackson.JacksonConverterFactory;

/**
 * Network util class which has the helper methods for Api calls.
 */
public class Access {
    private static final String TAG = Access.class.getSimpleName();
    private static final int TIMEOUT = 60;

    private static Access sInstance;

    private OkHttpClient.Builder mOkHttpBuilder;
    private JacksonConverterFactory mConverterFactory;

    private WeatherApi mWeatherApi;

    /**
     * Initializes the OkHttp client, Object Mapper and the Converter Factory with appropriate
     * params.
     */
    private Access() {
        if (sInstance != null) {
            throw new RuntimeException("Use getInstance() method to get the single instance of " +
                    "this class.");
        }
        // Set Logging Interceptor
        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BASIC);

        // Set Okhttpclient properties
        mOkHttpBuilder = new OkHttpClient.Builder();
        mOkHttpBuilder.addInterceptor(loggingInterceptor);
        mOkHttpBuilder.readTimeout(TIMEOUT, TimeUnit.SECONDS)
                .connectTimeout(TIMEOUT, TimeUnit.SECONDS);

        // Set JacksonConverterFactory properties
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.NONE);
        objectMapper.setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        objectMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        mConverterFactory = JacksonConverterFactory.create(objectMapper);
    }

    /**
     * @return mInstance: Reference of {@link Access}
     */
    public static synchronized Access getInstance() {
        if (sInstance == null) {
            synchronized (Access.class) {
                if (sInstance == null) {
                    sInstance = new Access();
                }
            }
        }
        return sInstance;
    }


    /**
     * Returns the WeatherApi which is the Implementation Api interface class.
     *
     * @param endPoint endpoint of the api
     * @return WeatherApi
     */
    public WeatherApi getWeatherApi(String endPoint) {
        if (mWeatherApi != null) {
            return mWeatherApi;
        }
        mWeatherApi = getRetrofit(endPoint).create(WeatherApi.class);
        return mWeatherApi;
    }

    /**
     * Returns the Retrofit built with all the properties needed.
     *
     * @param endPoint endpoint of the api.
     * @return Retrofit.
     */
    private Retrofit getRetrofit(String endPoint) {
        Retrofit.Builder retrofitBuilder = new Retrofit.Builder();
        retrofitBuilder.baseUrl(endPoint);
        retrofitBuilder.addCallAdapterFactory(RxJava2CallAdapterFactory.create());
        retrofitBuilder.addConverterFactory(mConverterFactory);
        retrofitBuilder.client(mOkHttpBuilder.build());

        return retrofitBuilder.build();
    }
}
