package com.example.daniel2.lab3;

import android.content.Context;
import android.graphics.Color;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class PromixityActivity extends AppCompatActivity implements SensorEventListener {
    private SensorManager sensorManager;
    private Sensor mProximity;
    private TextView hiddenMessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_promixity);
        /* Initialize hidden message TextView */
        hiddenMessage = findViewById(R.id.hiddenText);
        hiddenMessage.setVisibility(View.VISIBLE);

        /* Initialize sensors */
        sensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        mProximity = sensorManager.getDefaultSensor(Sensor.TYPE_PROXIMITY);
    }

    @Override
    public void onSensorChanged(SensorEvent sensorEvent) {
        /* Retrieve distance (cm) from the sensor */
        float distance = sensorEvent.values[0];
        if (distance < mProximity.getMaximumRange()){
            /* Show hidden message */
            hiddenMessage.setVisibility(View.VISIBLE);
            getWindow().getDecorView().setBackgroundColor(Color.RED);

        } else {
            /* Hide hidden message */
            if (hiddenMessage.getVisibility() == View.VISIBLE) {
                hiddenMessage.setVisibility(View.INVISIBLE);
            }
            getWindow().getDecorView().setBackgroundColor(Color.GREEN);
        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {

    }

    @Override
    protected void onResume() {
        // Register a listener for the sensor.
        super.onResume();
        sensorManager.registerListener(this, mProximity, SensorManager.SENSOR_DELAY_NORMAL);
    }

    @Override
    protected void onPause() {
        // Be sure to unregister the sensor when the activity pauses.
        super.onPause();
        sensorManager.unregisterListener(this);
    }

}
