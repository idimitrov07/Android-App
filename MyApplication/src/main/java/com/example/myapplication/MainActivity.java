package com.example.myapplication;

import android.app.Activity;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

public class MainActivity extends Activity {

    final String logTag = "Monitor Location";
    LocationListener networkListener;
    LocationListener gpsListener;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.itemStart:
                onStartListening( item);


                break;
            case R.id.itemStop:
                onStopListening(item);


                break;
            default:
                return super.onOptionsItemSelected(item);
        }
        return true;


    }

    public void onStartListening(MenuItem item) {
        Log.d(logTag, "Monitor Location - start listening");


        try {
            LocationManager lm = (LocationManager) getSystemService(LOCATION_SERVICE);

            networkListener = new MyLocationListener();
            lm.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, 0, 0, networkListener);
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    public void onStopListening(MenuItem item) {
        Log.d(logTag, "Monitor Location - stop listening");


        doStopListening();


    }

    public void onRecentLocation(Menu item) {
        Log.d(logTag, "Monitor - recent location");
    }

    public void onSingleLocation(Menu item) {
        Log.d(logTag, "Monitor - single location");
    }

    public void onExit(Menu item) {
        Log.d(logTag, "Monitor - exit");

        doStopListening();
        finish();
    }

    void doStopListening() {
        LocationManager lm = (LocationManager) getSystemService(LOCATION_SERVICE);
        if (networkListener == null) {
            lm.removeUpdates(networkListener);
            networkListener = null;


        }
    }

}
