# WeatherApp
This is a weather Application which gets all the Current Weather and Forecast Weather data from a weather provider.
This project is developed in MVVM (Model - View - View Model) architecture where the Views just rececieve the commands from the View Model.
And the View Model collects/prepares data model for the view by communicating to the Model. Model's are the one which has all the api related details.

This application can be be extended to multiple Weather Providers as well.

It uses following libraries,

Retrofit, Butterknife, OkHttp3, rxJava, rxAndroid.

Features:
Fetch the Current and forecast Weather Info using the Input city by the user. Used Tab styled view for Current and Forecast.

Updated the Weather hourly using JobScheduler and push a notification.
I used Jobscheduler as that is best suited for Scheduling a periodic job and consumes very less resources which in turn saves Battery consumption.

