package com.example.myapplication;

import android.location.Location;
import android.location.LocationListener;
import android.os.Bundle;
import android.util.Log;

/**
 * Created by Hello on 5/31/13.
 */
public class MyLocationListener implements LocationListener {
    final String logTag = "Monitor Location";

    @Override
    public void onLocationChanged(Location location) {
        String provider = location.getProvider();
        double lat = location.getLatitude();
        double lng = location.getLongitude();
        float accuracty = location.getAccuracy();
        long time = location.getTime();

        String logMessage = LogHelper.FormatLocationInfo(provider, lat, lng, accuracty, time);

        Log.d(logTag, "Monitor - location: " + logMessage);


    }

    @Override
    public void onStatusChanged(String s, int i, Bundle bundle) {

    }

    @Override
    public void onProviderEnabled(String s) {
        Log.d(logTag, "Monitor Location - provider enabled" + s);

    }

    @Override
    public void onProviderDisabled(String s) {
        Log.d(logTag, "Monitor Location - provider disabled" + s);

    }
}
