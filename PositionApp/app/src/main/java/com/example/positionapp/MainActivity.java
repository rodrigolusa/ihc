package com.example.positionapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements SensorEventListener {

    private SensorManager mSensorManager;
    private Sensor mAccelerometer;
    private TextView coordinateX;
    private TextView coordinateY;
    private TextView coordinateZ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mSensorManager = (SensorManager)getSystemService(SENSOR_SERVICE);
        mAccelerometer = mSensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        coordinateX = (TextView) findViewById(R.id.txtX);
        coordinateY = (TextView) findViewById(R.id.txtY);
        coordinateZ = (TextView) findViewById(R.id.txtZ);
    }

    @Override
    protected void onResume() {
        super.onResume();
        mSensorManager.registerListener(this, mAccelerometer, SensorManager.SENSOR_DELAY_NORMAL);
    }
    @Override
    protected void onPause() {
        super.onPause();
        mSensorManager.unregisterListener(this);
    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        if(event.sensor.getType()== Sensor.TYPE_ACCELEROMETER) {
            float sensorX = event.values[0];
            float sensorY = event.values[1];
            float sensorZ = event.values[2];
            //coordinate.setText(String.valueOf(sensorX) + " " + String.valueOf(sensorY) + " " + String.valueOf(sensorZ));
            coordinateX.setText((String.valueOf(sensorX)));
            coordinateY.setText((String.valueOf(sensorY)));
            coordinateZ.setText((String.valueOf(sensorZ)));

            if(sensorX > 5 && sensorY < 5 && sensorZ > 5){
                Intent in = new Intent(MainActivity.this, MainActivity2.class);
                startActivity(in);
            }
        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }
}