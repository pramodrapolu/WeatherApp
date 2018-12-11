package com.android.weatherapp.util;

import android.util.Log;

/**
 * Logger Util class.
 */
public class Logger {

    public static void log(int debugLevel, String tag, String message) {
        switch (debugLevel) {
            case Log.DEBUG:
                Log.d(tag, message);
                break;

            case Log.VERBOSE:
                Log.v(tag, message);
                break;

            case Log.ERROR:
                Log.e(tag, message);
                break;

            case Log.WARN:
                Log.w(tag, message);
                break;

            case Log.INFO:
                Log.i(tag, message);
                break;
        }
    }
}
