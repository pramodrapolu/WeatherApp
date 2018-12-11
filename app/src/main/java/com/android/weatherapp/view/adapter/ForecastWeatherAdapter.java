package com.android.weatherapp.view.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.android.weatherapp.R;
import com.android.weatherapp.model.ForecastWeather;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * RecyclerView Adapter for the list of the Forecast Weathers.
 */
public class ForecastWeatherAdapter extends RecyclerView.Adapter<ForecastWeatherAdapter
        .ForecastViewHolder> {

    private final Context mContext;
    private List<ForecastWeather> mForecastWeatherList;

    public ForecastWeatherAdapter(Context context) {
        mContext = context;
        mForecastWeatherList = new ArrayList<>();
    }

    @NonNull
    @Override
    public ForecastWeatherAdapter.ForecastViewHolder onCreateViewHolder(@NonNull ViewGroup parent,
                                                                        int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout
                .forecast_weather_item, parent, false);
        return new ForecastViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ForecastWeatherAdapter.ForecastViewHolder holder, int
            position) {

        ForecastWeather forecastWeather = mForecastWeatherList.get(position);

        // Set the Data to the views.
        holder.mForecastDate.setText(forecastWeather.getDate());
        holder.mForecastTemp.setText(String.format(mContext.getResources().getString(R.string
                .temp_label), forecastWeather.getTemperature()));
        holder.mForecastMinTemp.setText(String.format(mContext.getResources().getString(R.string
                .current_min_temp_label), forecastWeather.getMinTemp()));
        holder.mForecastMaxTemp.setText(String.format(mContext.getResources().getString(R.string
                .current_max_temp_label), forecastWeather.getMaxTemp()));
    }

    @Override
    public int getItemCount() {
        return mForecastWeatherList.size();
    }

    /**
     * Update the ForecastWeather List.
     *
     * @param forecastWeatherList updated list.
     */
    public void updateForecastWeatherList(List<ForecastWeather> forecastWeatherList) {
        mForecastWeatherList.clear();
        mForecastWeatherList.addAll(forecastWeatherList);
        notifyDataSetChanged();
    }

    /**
     * View Holder which holds the Views.
     */
    static class ForecastViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.weather_item_date)
        TextView mForecastDate;

        @BindView(R.id.weather_item_temp)
        TextView mForecastTemp;

        @BindView(R.id.weather_min_temp)
        TextView mForecastMinTemp;

        @BindView(R.id.weather_max_temp)
        TextView mForecastMaxTemp;

        ForecastViewHolder(View itemView) {
            super(itemView);
            // Bind the ButterKnife.
            ButterKnife.bind(this, itemView);
        }
    }
}
