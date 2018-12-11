package com.android.weatherapp.model;

/**
 * Builder Class with the Data required for the Forecast Weather.
 */
public class ForecastWeather {

    private String date;
    private String temperature;
    private String minTemp;
    private String maxTemp;

    public String getDate() {
        return date;
    }

    public String getTemperature() {
        return temperature;
    }

    public String getMinTemp() {
        return minTemp;
    }

    public String getMaxTemp() {
        return maxTemp;
    }

    private ForecastWeather(Builder builder) {
        date = builder.date;
        temperature = builder.temperature;
        minTemp = builder.minTemp;
        maxTemp = builder.maxTemp;
    }

    /**
     * {@code ForecastWeather} builder static inner class.
     */
    public static final class Builder {
        private String date;
        private String temperature;
        private String minTemp;
        private String maxTemp;

        public Builder() {
        }

        /**
         * Sets the {@code date} and returns a reference to this Builder so that the methods can
         * be chained together.
         *
         * @param date the {@code date} to set
         * @return a reference to this Builder
         */
        public Builder withDate(String date) {
            this.date = date;
            return this;
        }

        /**
         * Sets the {@code temperature} and returns a reference to this Builder so that the
         * methods can be chained together.
         *
         * @param temperature the {@code temperature} to set
         * @return a reference to this Builder
         */
        public Builder withTemperature(String temperature) {
            this.temperature = temperature;
            return this;
        }

        /**
         * Sets the {@code minTemp} and returns a reference to this Builder so that the methods
         * can be chained together.
         *
         * @param minTemp the {@code minTemp} to set
         * @return a reference to this Builder
         */
        public Builder withMinTemp(String minTemp) {
            this.minTemp = minTemp;
            return this;
        }

        /**
         * Sets the {@code maxTemp} and returns a reference to this Builder so that the methods
         * can be chained together.
         *
         * @param maxTemp the {@code maxTemp} to set
         * @return a reference to this Builder
         */
        public Builder withMaxTemp(String maxTemp) {
            this.maxTemp = maxTemp;
            return this;
        }

        /**
         * Returns a {@code ForecastWeather} built from the parameters previously set.
         *
         * @return a {@code ForecastWeather} built with parameters of this {@code ForecastWeather
         * .Builder}
         */
        public ForecastWeather build() {
            return new ForecastWeather(this);
        }
    }
}
