package com.example.googleanalyticshelloworld;

import android.app.Application;
import android.content.Context;
import android.hardware.SensorManager;
import android.widget.Toast;

import com.google.android.gms.analytics.GoogleAnalytics;
import com.google.android.gms.analytics.Tracker;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

/**
 * Custom implementation of android.app.Application.&nbsp;The android:name attribute in the
 * AndroidManifest.xml application element should be the name of your class (".MyApp"). Android will
 * always create an instance of the application class and call onCreate before creating any other
 * Activity, Service or BroadcastReceiver.
 */
public class MyApp extends Application {
    /**
     * The Analytics singleton. The field is set in onCreate method override when the application
     * class is initially created.
     */
    private static GoogleAnalytics analytics;

    /**
     * The default app tracker. The field is from onCreate callback when the application is
     * initially created.
     */
    private static Tracker tracker;

    /**
     * Access to the global Analytics singleton. If this method returns null you forgot to either
     * set android:name="&lt;this.class.name&gt;" attribute on your application element in
     * AndroidManifest.xml or you are not setting this.analytics field in onCreate method override.
     */
    public static GoogleAnalytics analytics() {
        return analytics;
    }

    private void MikeTest() {
        SensorManager mngr = (SensorManager) getSystemService(Context.SENSOR_SERVICE);

    }
    /* public static void stream_from_function() {  // add retro lambda
        Stream.iterate(0, n -> n + 1)
                .limit(7)
                .skip(0)
                        //	.filter(w -> (w % 5) == 0)
                .forEach(System.out::println);
    }
    */

    /**
     * The default app tracker. If this method returns null you forgot to either set
     * android:name="&lt;this.class.name&gt;" attribute on your application element in
     * AndroidManifest.xml or you are not setting this.tracker field in onCreate method override.
     */

    private static final String REGEX = "e:";
    private static final String INPUT =
            "one:two:three:four:five:six:seven:eight:nine:ten";

    public static Tracker tracker() {
        return tracker;
    }

    private boolean hassensor;

    @Override
    public void onCreate() {
        super.onCreate();

        analytics = GoogleAnalytics.getInstance(this);

        // TODO: Replace the tracker-id with your app one from https://www.google.com/analytics/web/
        // TODO: replaced UA with ~ from lambda 1 UA-70607872-1
        tracker = analytics.newTracker("UA-70607872-1");
        List<String> list = new ArrayList<>(Arrays.asList("Alpha", "Bravo", "Charlie"));

        // Provide unhandled exceptions reports. Do that first after creating the tracker
        tracker.enableExceptionReporting(true);

        // Enable Remarketing, Demographics & Interests reports
        // https://developers.google.com/analytics/devguides/collection/android/display-features
        tracker.enableAdvertisingIdCollection(true);

        // Enable automatic activity tracking for your app
        tracker.enableAutoActivityTracking(true);
        SensorManager mngr = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        //  if(getTempSensors() == null) {
        hassensor = false;
        for (int i = 0; i < 5; i++) {
            CharSequence text = "a word " + Integer.toString(3) + " " + Integer.toString(i);
            Toast.makeText(this, text, Toast.LENGTH_LONG).show();
            Toast.makeText(this, "One", Toast.LENGTH_LONG).show();
            Toast.makeText(this, "Two", Toast.LENGTH_LONG).show();
            Toast.makeText(this, "Three", Toast.LENGTH_LONG).show();

            Pattern p = Pattern.compile(REGEX);
            String[] items = p.split(INPUT);
            for (String s : items) {
                Toast.makeText(this, s, Toast.LENGTH_LONG).show();
                //  System.out.println(s);
            }


            //   list.forEach(Toast.makeText(this, s, Toast.LENGTH_LONG).show());
            Toast.makeText(this, "No Temperature Sensors\n Available\nyet\ntoday", Toast.LENGTH_LONG).show();
            // mike    finish();
            //     return;
            // }
        }
        //  hassensor = true;
        // mike   setContentView(R.layout.sensortemp);

        //mike   setTitle("Temperature");
    }

}
/*
    private List<Sensor> getTempSensors() {
        SensorManager mngr = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        List<Sensor> list = mngr.getSensorList(Sensor.TYPE_TEMPERATURE);
        return list != null && !list.isEmpty() ? list : null;
    }
    */
//}
