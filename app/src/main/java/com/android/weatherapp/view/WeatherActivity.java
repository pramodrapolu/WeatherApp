package com.android.weatherapp.view;

import android.arch.lifecycle.ViewModelProviders;
import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.KeyEvent;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;

import com.android.weatherapp.R;
import com.android.weatherapp.notification.NotificationUtil;
import com.android.weatherapp.util.Logger;
import com.android.weatherapp.view.adapter.TabAdapter;
import com.android.weatherapp.viewmodel.WeatherActivityViewModel;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Activity which holds all the fragments/views.
 */
public class WeatherActivity extends AppCompatActivity {

    private static final String TAG = WeatherActivity.class.getSimpleName();

    private Unbinder mUnbinder;

    @BindView(R.id.input_field)
    EditText mInputField;

    @BindView(R.id.tab_layout)
    TabLayout mTabLayout;

    @BindView(R.id.view_pager)
    ViewPager mViewPager;

    private WeatherActivityViewModel mWeatherActivityViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weather);

        Logger.log(Log.INFO, TAG, "Activity onCreate");

        // Bind the ButterKnife.
        mUnbinder = ButterKnife.bind(this);

        // Get the ViewModel from the ViewModelProviders
        mWeatherActivityViewModel = ViewModelProviders.of(this).get(WeatherActivityViewModel.class);

        // Create/Register the Notification Channels with System.
        NotificationUtil.createNotificationChannel(getApplicationContext());

        mInputField.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if (actionId == EditorInfo.IME_ACTION_SEARCH) {
                    Logger.log(Log.INFO, TAG, "Clicked Search.");
                    // Post the Input value through the InputLiveData.
                    mWeatherActivityViewModel.getInputLiveData().setValue(mInputField.getText()
                            .toString());

                    hideKeyboard();

                    return true;
                }
                return false;
            }
        });

        // Set up fragments.
        setupFragments();
    }

    @Override
    protected void onDestroy() {
        // UnBind the ButterKnife.
        mUnbinder.unbind();
        super.onDestroy();
    }

    /**
     * Create the TabAdapter and add it to the ViewPager.
     */
    private void setupFragments() {
        TabAdapter tabAdapter = new TabAdapter(getSupportFragmentManager());

        mViewPager.setAdapter(tabAdapter);

        mTabLayout.setupWithViewPager(mViewPager);
    }

    private void hideKeyboard() {
        InputMethodManager inputManager = (InputMethodManager) getApplicationContext().
                getSystemService(Context.INPUT_METHOD_SERVICE);
        if (inputManager != null && getCurrentFocus() != null) {
            inputManager.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(),
                    InputMethodManager.HIDE_NOT_ALWAYS);
        }
    }

}
