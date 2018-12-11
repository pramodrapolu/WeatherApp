package com.android.weatherapp.notification;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.TaskStackBuilder;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.NotificationManagerCompat;

import com.android.weatherapp.R;
import com.android.weatherapp.model.CurrentWeather;
import com.android.weatherapp.view.WeatherActivity;

/**
 * Notification Util class.
 * <p>
 * Creates Notification channel for API 26 or more,
 * Creates the Notification and posts it.
 */
public class NotificationUtil {

    private static final String CHANNEL_ID = "WeatherUpdateChannel";
    private static final int PENDING_INTENT_REQUEST_CODE = 0;
    private static final int NOTIFICATION_ID = 999;

    /**
     * Creates the Notification Channel for API 26 or more.
     */
    public static void createNotificationChannel(Context applicationContext) {
        // Create the NotificationChannel, but only on API 26+ because
        // the NotificationChannel class is new and not in the support library
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            NotificationChannel notificationChannel = new NotificationChannel(CHANNEL_ID,
                    applicationContext.getString(R.string.channel_name),
                    NotificationManager.IMPORTANCE_DEFAULT);
            notificationChannel.setDescription(applicationContext.getString(R.string
                    .channel_description));
            // Register the channel with the system; you can't change the importance
            // or other notification behaviors after this
            NotificationManager notificationManager = applicationContext.getSystemService
                    (NotificationManager.class);
            if (notificationManager != null) {
                notificationManager.createNotificationChannel(notificationChannel);
            }
        }
    }

    /**
     * Creates the Notification with the current Weather.
     *
     * @param currentWeather Data model with the Current Weather info.
     */
    static void createNotification(CurrentWeather currentWeather, Context applicationContext) {
        Intent intent = new Intent(applicationContext, WeatherActivity.class);

        TaskStackBuilder taskStackBuilder = TaskStackBuilder.create(applicationContext);
        taskStackBuilder.addNextIntentWithParentStack(intent);
        PendingIntent pendingIntent = taskStackBuilder.getPendingIntent(PENDING_INTENT_REQUEST_CODE,
                PendingIntent.FLAG_UPDATE_CURRENT);

        // Build the Notification.
        NotificationCompat.Builder notificationBuilder =
                new NotificationCompat.Builder(applicationContext, CHANNEL_ID)
                        .setSmallIcon(R.drawable.ic_weather_notification)
                        .setContentTitle(applicationContext.getString(R.string
                                .notification_title))
                        .setPriority(NotificationCompat.PRIORITY_DEFAULT)
                        .setContentIntent(pendingIntent)
                        .setAutoCancel(true);

        String notificationContentText = getNotificationText(applicationContext,
                currentWeather.getCurrentTemperature(), currentWeather.getLocation());
        notificationBuilder.setContentText(notificationContentText);
        NotificationManagerCompat notificationManager = NotificationManagerCompat.from
                (applicationContext);
        // Post the Notification.
        notificationManager.notify(NOTIFICATION_ID, notificationBuilder.build());

    }

    /**
     * Formats the Notification Text with current Temp and city Name.
     *
     * @param currentTemp Current Temperature.
     * @param cityName    name of the city.
     * @return formatted notification text.
     */
    private static String getNotificationText(Context context, String currentTemp, String
            cityName) {
        return context.getString(R.string.notification_text, currentTemp, cityName);
    }
}
