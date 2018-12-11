package com.android.weatherapp.view.adapter;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.android.weatherapp.view.CurrentWeatherFragment;
import com.android.weatherapp.view.ForecastWeatherFragment;

/**
 * FragmentPagerAdapter with the Tabs.
 */
public class TabAdapter extends FragmentPagerAdapter {

    private static final String CURRENT = "Current";
    private static final String FORECAST = "Forecast";
    private static final int NUM_OF_TABS = 2;

    public TabAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
            default:
                return CurrentWeatherFragment.newInstance();

            case 1:
                return ForecastWeatherFragment.newInstance();
        }
    }

    @Override
    public int getCount() {
        return NUM_OF_TABS;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        switch (position) {
            case 0:
            default:
                return CURRENT;

            case 1:
                return FORECAST;
        }
    }
}
