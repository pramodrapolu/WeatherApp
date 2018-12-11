package com.android.weatherapp.view;


import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.android.weatherapp.R;
import com.android.weatherapp.model.CurrentWeather;
import com.android.weatherapp.util.Logger;
import com.android.weatherapp.viewmodel.WeatherActivityViewModel;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;


/**
 * Fragment which holds the Current Weather data.
 */
public class CurrentWeatherFragment extends Fragment {

    private static final String TAG = CurrentWeatherFragment.class.getSimpleName();

    private Unbinder mUnbinder;

    @BindView(R.id.current_info_layout)
    RelativeLayout mCurrentInfoLayout;

    @BindView(R.id.weather_provider_name)
    TextView mWeatherProviderName;

    @BindView(R.id.city_name)
    TextView mCityName;

    @BindView(R.id.current_temperature)
    TextView mCurrentTemp;

    @BindView(R.id.current_wind)
    TextView mCurrentWind;

    @BindView(R.id.current_feel_like_temp)
    TextView mCurrentFeelsLikeTemp;

    @BindView(R.id.current_min_temp)
    TextView mCurrentMinTemp;

    @BindView(R.id.current_max_temp)
    TextView mCurrentMaxTemp;

    @BindView(R.id.instruction_header)
    TextView mInstructionHeader;

    private WeatherActivityViewModel mWeatherActivityViewModel;


    public CurrentWeatherFragment() {
        // Required empty public constructor
    }

    public static CurrentWeatherFragment newInstance() {

        Bundle args = new Bundle();

        CurrentWeatherFragment fragment = new CurrentWeatherFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_current_weather, container, false);

        Logger.log(Log.INFO, TAG, " onCreateView");

        // Bind the ButterKnife.
        mUnbinder = ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Logger.log(Log.INFO, TAG, " onActivityCreated");
        if (getActivity() != null) {
            // Get the ViewModel from the ViewModelProviders
            mWeatherActivityViewModel = ViewModelProviders.of(getActivity()).get
                    (WeatherActivityViewModel.class);
            observeCurrentWeather();
            observeInput();
        }

        if (mWeatherActivityViewModel.getInputLocation() == null) {
            showInstruction();
        }
    }

    @Override
    public void onDestroy() {
        // UnBind the ButterKnife.
        mUnbinder.unbind();
        super.onDestroy();
    }

    /**
     * Observe the Input and Pass it on to ViewModel to get current weather.
     */
    private void observeInput() {
        mWeatherActivityViewModel.getInputLiveData().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String input) {
                if (input != null) {
                    Logger.log(Log.INFO, TAG, " Input Change received");
                    // Get the Weather Info.
                    mWeatherActivityViewModel.initiateCurrentWeatherCall(input);
                } else {
                    Logger.log(Log.ERROR, TAG, " Input is Null");
                }
            }
        });
    }

    /**
     * Observe the Current Weather.
     */
    private void observeCurrentWeather() {
        mWeatherActivityViewModel.getCurrentWeatherLiveData().observe(this,
                new Observer<CurrentWeather>() {
                    @Override
                    public void onChanged(@Nullable CurrentWeather currentWeather) {
                        if (currentWeather != null) {
                            Logger.log(Log.INFO, TAG, "Current Weather Data Change received");
                            showCurrentWeather();
                            updateUI(currentWeather);
                        } else {
                            Logger.log(Log.ERROR, TAG, "Current Weather is Null");
                            Toast.makeText(getContext(),
                                    getString(R.string.check_input), Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }

    /**
     * Shows the Instruction and hides the info.
     */
    private void showInstruction() {
        mCurrentInfoLayout.setVisibility(View.GONE);
        mInstructionHeader.setVisibility(View.VISIBLE);
    }

    /**
     * Shows the Current Weather Info and hides Instruction.
     */
    private void showCurrentWeather() {
        mCurrentInfoLayout.setVisibility(View.VISIBLE);
        mInstructionHeader.setVisibility(View.GONE);
    }

    /**
     * Updates the UI with the lastest {@link CurrentWeather} model.
     *
     * @param currentWeather model with the required data.
     */
    private void updateUI(CurrentWeather currentWeather) {

        Logger.log(Log.INFO, TAG, "Updating UI");

        if (currentWeather.getWeatherProviderName() != null) {
            mWeatherProviderName.setText(currentWeather.getWeatherProviderName());
            mWeatherProviderName.setVisibility(View.VISIBLE);
        } else {
            mWeatherProviderName.setVisibility(View.GONE);
        }

        if (currentWeather.getCurrentTemperature() != null) {
            mCurrentTemp.setText(String.format(getResources().getString(R.string
                    .temp_label), currentWeather.getCurrentTemperature()));
            mCurrentTemp.setVisibility(View.VISIBLE);
        } else {
            mCurrentTemp.setVisibility(View.GONE);
        }

        if (currentWeather.getFeelsLikeTemp() != null) {
            mCurrentFeelsLikeTemp.setText(String.format(getResources().getString(R.string
                    .feels_like_temp), currentWeather.getFeelsLikeTemp()));
            mCurrentFeelsLikeTemp.setVisibility(View.VISIBLE);
        } else {
            mCurrentFeelsLikeTemp.setVisibility(View.GONE);
        }

        if (currentWeather.getLocation() != null) {
            if (getActivity() != null) {
                mWeatherActivityViewModel.saveInputLocation(getActivity().getApplicationContext(),
                        currentWeather.getLocation());
            }
            mCityName.setText(currentWeather.getLocation());
            mCityName.setVisibility(View.VISIBLE);
        } else {
            mCityName.setVisibility(View.GONE);
        }

        if (currentWeather.getWindSpeed() != null) {
            mCurrentWind.setText(String.format(getResources().getString(R.string
                    .current_wind_speed_label), currentWeather.getWindSpeed(), currentWeather
                    .getWindDirection()));
            mCurrentWind.setVisibility(View.VISIBLE);
        } else {
            mCurrentWind.setVisibility(View.GONE);
        }

        if (currentWeather.getMinTemp() != null) {
            mCurrentMinTemp.setText(String.format(getResources().getString(R.string
                    .current_min_temp_label), currentWeather.getMinTemp()));
            mCurrentMinTemp.setVisibility(View.VISIBLE);
        } else {
            mCurrentMinTemp.setVisibility(View.GONE);
        }

        if (currentWeather.getMaxTemp() != null) {
            mCurrentMaxTemp.setText(String.format(getResources().getString(R.string
                    .current_max_temp_label), currentWeather.getMaxTemp()));
            mCurrentMaxTemp.setVisibility(View.VISIBLE);
        } else {
            mCurrentMaxTemp.setVisibility(View.GONE);
        }
    }
}
