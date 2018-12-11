package com.android.weatherapp.view;


import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.android.weatherapp.R;
import com.android.weatherapp.model.ForecastWeatherData;
import com.android.weatherapp.util.Logger;
import com.android.weatherapp.view.adapter.ForecastWeatherAdapter;
import com.android.weatherapp.viewmodel.WeatherActivityViewModel;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;


/**
 * Fragment which holds the Forecast Weather data.
 */
public class ForecastWeatherFragment extends Fragment {

    private static final String TAG = ForecastWeatherFragment.class.getSimpleName();

    private Unbinder mUnbinder;

    @BindView(R.id.forecast_weather_info)
    LinearLayout mForecastWeatherInfo;

    @BindView(R.id.forecast_weather_city_name)
    TextView mCityName;

    @BindView(R.id.forecast_weather_recycler_view)
    RecyclerView mForecastViewRecyclerView;

    @BindView(R.id.forecast_welcome_header)
    TextView mWelcomeHeader;

    private ForecastWeatherAdapter mForecastWeatherAdapter;

    private WeatherActivityViewModel mWeatherActivityViewModel;

    public ForecastWeatherFragment() {
        // Required empty public constructor
    }

    public static ForecastWeatherFragment newInstance() {

        Bundle args = new Bundle();

        ForecastWeatherFragment fragment = new ForecastWeatherFragment();
        fragment.setArguments(args);
        return fragment;
    }


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_forecast_weather, container, false);
        Logger.log(Log.INFO, TAG, " onCreateView");

        // Bind the ButterKnife.
        mUnbinder = ButterKnife.bind(this, view);

        // Set the Vertical Layout manager and adapter to the Recycler View.
        LinearLayoutManager llm = new LinearLayoutManager(getContext());
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        mForecastViewRecyclerView.setLayoutManager(llm);

        mForecastWeatherAdapter = new ForecastWeatherAdapter(getContext());
        mForecastViewRecyclerView.setAdapter(mForecastWeatherAdapter);
        if (getContext() != null) {
            mForecastViewRecyclerView.addItemDecoration(new
                    DividerItemDecoration(getContext(), RecyclerView.VERTICAL));
        }

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
            observeForecastWeather();
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
     * Observe the Input and Pass it on to ViewModel to get Forecast weather.
     */
    private void observeInput() {
        mWeatherActivityViewModel.getInputLiveData().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String input) {
                if (input != null) {
                    Logger.log(Log.INFO, TAG, " Input Change received");
                    mWeatherActivityViewModel.initiateForecastWeatherCall(input);
                } else {
                    Logger.log(Log.ERROR, TAG, " Input is Null");
                }
            }
        });
    }

    /**
     * Observe the Current Weather.
     */
    private void observeForecastWeather() {
        mWeatherActivityViewModel.getForecastWeatherLiveData().observe(this,
                new Observer<ForecastWeatherData>() {
                    @Override
                    public void onChanged(@Nullable ForecastWeatherData forecastWeatherData) {
                        if (forecastWeatherData != null) {
                            Logger.log(Log.INFO, TAG, "Forecast Weather Data Change received");
                            showCurrentInfoLayout();
                            updateUI(forecastWeatherData);
                        } else {
                            Logger.log(Log.ERROR, TAG, "Forecast Weather is Null");
                            Toast.makeText(getContext(),
                                    getString(R.string.check_input), Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }

    /**
     * Shows the Instruction and hides the Forecast info.
     */
    private void showInstruction() {
        mForecastWeatherInfo.setVisibility(View.GONE);
        mWelcomeHeader.setVisibility(View.VISIBLE);
    }

    /**
     * Shows the Forecast Weather Info and hides Instruction.
     */
    private void showCurrentInfoLayout() {
        mForecastWeatherInfo.setVisibility(View.VISIBLE);
        mWelcomeHeader.setVisibility(View.GONE);
    }

    /**
     * Updates the UI with the lastest {@link ForecastWeatherData} model.
     *
     * @param forecastWeatherData model with the required data.
     */
    private void updateUI(ForecastWeatherData forecastWeatherData) {

        Logger.log(Log.INFO, TAG, "Updating UI");

        if (forecastWeatherData != null) {
            if (forecastWeatherData.getForecastCityName() != null) {
                if (getActivity() != null) {
                    mWeatherActivityViewModel.saveInputLocation(getActivity()
                            .getApplicationContext(), forecastWeatherData.getForecastCityName());
                }
                mCityName.setText(forecastWeatherData.getForecastCityName());
                mCityName.setVisibility(View.VISIBLE);
            }
            if (forecastWeatherData.getForecastWeather() != null && forecastWeatherData
                    .getForecastWeather().size() > 0) {
                mForecastWeatherAdapter.updateForecastWeatherList(forecastWeatherData
                        .getForecastWeather());
            }
        }
    }
}
