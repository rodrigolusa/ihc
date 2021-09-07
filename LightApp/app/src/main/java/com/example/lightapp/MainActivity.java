package com.example.lightapp;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.location.Location;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity implements SensorEventListener {

    private SensorManager sensorManager;
    private Sensor light;
    private Sensor temp;
    TextView lightValue;
    TextView tempValue;
    TextView location;
    Button btnGetGPS;

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lightValue = (TextView) findViewById(R.id.txtLight);
        tempValue = (TextView) findViewById(R.id.txtTemp);
        location = (TextView) findViewById(R.id.txtLocation);

        sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
        light = sensorManager.getDefaultSensor(Sensor.TYPE_LIGHT);
        temp = sensorManager.getDefaultSensor((Sensor.TYPE_AMBIENT_TEMPERATURE));

        if(light != null)
        {
            sensorManager.registerListener(MainActivity.this, light, SensorManager.SENSOR_DELAY_NORMAL);
        }else
        {
            lightValue.setText("Light sensor not supported");
        }

        if(temp != null){
            sensorManager.registerListener(MainActivity.this, light, SensorManager.SENSOR_DELAY_NORMAL);
        } else{
            tempValue.setText("Light sensor not supported");
        }

        btnGetGPS = (Button) findViewById(R.id.btnGetGPS);
        ActivityCompat.requestPermissions(MainActivity.this, new String[] {Manifest.permission.ACCESS_FINE_LOCATION}, 123);
        btnGetGPS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                GPSTracker g = new GPSTracker(getApplicationContext());
                Location l = g.getLocation();
                if(l != null){
                    double lat = l.getLatitude();
                    double longi = l.getLongitude();

                    location.setText("LAT: " + lat + "  LONG: " + longi);
                    Toast.makeText(getApplicationContext(), "LAT: " + lat + "\nLONG: " + longi, Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        Sensor sensor = event.sensor;
        if(sensor.getType() == Sensor.TYPE_LIGHT)
        {
            lightValue.setText(String.valueOf(event.values[0]));
        }
        if(sensor.getType() == Sensor.TYPE_AMBIENT_TEMPERATURE)
        {
            tempValue.setText(String.valueOf(event.values[0]));
        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }
}