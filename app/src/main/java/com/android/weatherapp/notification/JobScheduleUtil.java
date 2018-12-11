package com.android.weatherapp.notification;

import android.app.job.JobInfo;
import android.app.job.JobScheduler;
import android.content.ComponentName;
import android.content.Context;

/**
 * Job Scheduler Util which schedules with the specified periodic interval.
 */
public class JobScheduleUtil {

    private static final int JOB_ID = 101;
    private static final long MILLISECONDS_IN_HOUR = 1800000L;

    public static void scheduleWeatherUpdate(Context context) {
        JobScheduler jobScheduler = (JobScheduler) context.getSystemService(Context
                .JOB_SCHEDULER_SERVICE);

        if (jobScheduler != null) {
            jobScheduler.schedule(new JobInfo.Builder(JOB_ID,
                    new ComponentName(context, WeatherUpdateService.class))
                    .setRequiredNetworkType(JobInfo.NETWORK_TYPE_ANY)
                    .setPeriodic(MILLISECONDS_IN_HOUR)
                    .build());
        }
    }
}
