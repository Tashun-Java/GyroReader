package com.example.gyroreader;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;



public class MainActivity extends AppCompatActivity {
    private TextView xValue;
    private TextView yValue;
    private TextView zValue;
    private GyroActivity gyroActivity;
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }


    public void startSensing(View view) {
        if (xValue == null) xValue = findViewById(R.id.xValue);
        if (yValue == null) yValue = findViewById(R.id.yValue);
        if (zValue == null) zValue = findViewById(R.id.zValue);
        if (gyroActivity == null) gyroActivity = new GyroActivity(this, xValue, yValue, zValue);
        if (button == null) button = findViewById(R.id.startButton);
        if (button.getText().equals("Start")) {
            button.setText("Stop");
            gyroActivity.register();
        } else {
            button.setText("Start");
            gyroActivity.unRegister();
        }

    }
}
