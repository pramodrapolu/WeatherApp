package com.android.weatherapp.model;

/**
 * Builder class with the Data required for the Current Weather.
 */
public class CurrentWeather {

    private String weatherProviderName;

    private String currentTemperature;

    private String feelsLikeTemp;

    private String location;

    private String windSpeed;

    private String windDirection;

    private String minTemp;

    private String maxTemp;

    private CurrentWeather(Builder builder) {
        weatherProviderName = builder.weatherProviderName;
        currentTemperature = builder.currentTemperature;
        feelsLikeTemp = builder.feelsLikeTemp;
        location = builder.location;
        windSpeed = builder.windSpeed;
        windDirection = builder.windDirection;
        minTemp = builder.minTemp;
        maxTemp = builder.maxTemp;
    }

    public String getCurrentTemperature() {
        return currentTemperature;
    }

    public String getFeelsLikeTemp() {
        return feelsLikeTemp;
    }

    public String getLocation() {
        return location;
    }

    public String getWindSpeed() {
        return windSpeed;
    }

    public String getWindDirection() {
        return windDirection;
    }

    public String getMinTemp() {
        return minTemp;
    }

    public String getMaxTemp() {
        return maxTemp;
    }

    public String getWeatherProviderName() {
        return weatherProviderName;
    }

    /**
     * {@code CurrentWeather} builder static inner class.
     */
    public static final class Builder {
        private String weatherProviderName;
        private String currentTemperature;
        private String feelsLikeTemp;
        private String location;
        private String windSpeed;
        private String windDirection;
        private String minTemp;
        private String maxTemp;

        public Builder() {
        }

        /**
         * Sets the {@code weatherProviderName} and returns a reference to this Builder so that
         * the methods can be chained together.
         *
         * @param weatherProviderName the {@code weatherProviderName} to set
         * @return a reference to this Builder
         */
        public Builder withWeatherProviderName(String weatherProviderName) {
            this.weatherProviderName = weatherProviderName;
            return this;
        }

        /**
         * Sets the {@code currentTemperature} and returns a reference to this Builder so that
         * the methods can be chained together.
         *
         * @param currentTemperature the {@code currentTemperature} to set
         * @return a reference to this Builder
         */
        public Builder withCurrentTemperature(String currentTemperature) {
            this.currentTemperature = currentTemperature;
            return this;
        }

        /**
         * Sets the {@code feelsLikeTemp} and returns a reference to this Builder so that the
         * methods can be chained together.
         *
         * @param feelsLikeTemp the {@code feelsLikeTemp} to set
         * @return a reference to this Builder
         */
        public Builder withFeelsLikeTemp(String feelsLikeTemp) {
            this.feelsLikeTemp = feelsLikeTemp;
            return this;
        }

        /**
         * Sets the {@code location} and returns a reference to this Builder so that the methods
         * can be chained together.
         *
         * @param location the {@code location} to set
         * @return a reference to this Builder
         */
        public Builder withLocation(String location) {
            this.location = location;
            return this;
        }

        /**
         * Sets the {@code windSpeed} and returns a reference to this Builder so that the methods
         * can be chained together.
         *
         * @param windSpeed the {@code windSpeed} to set
         * @return a reference to this Builder
         */
        public Builder withWindSpeed(String windSpeed) {
            this.windSpeed = windSpeed;
            return this;
        }

        /**
         * Sets the {@code windDirection} and returns a reference to this Builder so that the
         * methods can be chained together.
         *
         * @param windDirection the {@code windDirection} to set
         * @return a reference to this Builder
         */
        public Builder withWindDirection(String windDirection) {
            this.windDirection = windDirection;
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
         * Returns a {@code CurrentWeather} built from the parameters previously set.
         *
         * @return a {@code CurrentWeather} built with parameters of this {@code CurrentWeather
         * .Builder}
         */
        public CurrentWeather build() {
            return new CurrentWeather(this);
        }
    }
}
