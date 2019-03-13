package com.example.gyroreader;

import android.app.Activity;
import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.widget.TextView;

public class GyroActivity extends Activity implements SensorEventListener {
    private final SensorManager sensorManager;
    private final Sensor gyroSensor;
    private TextView xValue;
    private TextView yValue;
    private TextView zValue;
    private String flag = null;


    public GyroActivity(Context context, TextView xValue, TextView yValue, TextView zValue) {
        this.xValue=xValue;
        this.yValue=yValue;
        this.zValue=zValue;
        this.sensorManager = (SensorManager) context.getSystemService(SENSOR_SERVICE); //get the sensor
        this.gyroSensor = sensorManager.getDefaultSensor(Sensor.TYPE_GYROSCOPE);
        System.out.println("Constructed");
    }


    public void onResume() {
        super.onResume();
    }


    public void onPause() {
        super.onPause();

    }

    public void register() {
        sensorManager.registerListener(this, gyroSensor, SensorManager.SENSOR_DELAY_NORMAL);
        flag = "Registered";
    }

    public void unRegister() {
        sensorManager.unregisterListener(this, gyroSensor);
        flag = null;
    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        String sensorName = event.sensor.getName();
        String x = String.valueOf(event.values[0]);
        String y = String.valueOf(event.values[1]);
        String z = String.valueOf(event.values[2]);
        if (flag!=null) {
            xValue.setText(x);
            yValue.setText(y);
            zValue.setText(z);
        }
        System.out.println(sensorName + ": X: " + String.valueOf(x) + "; Y: " + String.valueOf(y) + "; Z: " + String.valueOf(z) + ";");
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }
}
