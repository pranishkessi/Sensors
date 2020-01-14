package com.si.sensors;

import androidx.appcompat.app.AppCompatActivity;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class GyroscopeActivity extends AppCompatActivity {
    private TextView tvresult;
    private EditText et1,et2;
    private SensorManager sensorManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gyroscope);
        et1=findViewById(R.id.et1);
        et2=findViewById(R.id.et2);
        tvresult=findViewById(R.id.tvresult);
        int one =Integer.parseInt(et1.getText().toString());
        int two =Integer.parseInt(et2.getText().toString());
        int res;

        sensorGyro(one,two);

    }
    private void sensorGyro(final int one, final int two){
        sensorManager=(SensorManager) getSystemService(SENSOR_SERVICE);
        final Sensor sensor=sensorManager.getDefaultSensor(Sensor.TYPE_GYROSCOPE);
        SensorEventListener gyrolistner=new SensorEventListener() {
            @Override
            public void onSensorChanged(SensorEvent sensorEvent) {
                if(sensorEvent.values[1]<0){


                    tvresult.setText(" "+(one+two));
                }else if(sensorEvent.values[1]>0){

                    tvresult.setText(" "+(one-two));

                }


            }

            @Override
            public void onAccuracyChanged(Sensor sensor, int i) {

            }
        };if (sensor!=null){
            sensorManager.registerListener(gyrolistner,sensor,SensorManager.SENSOR_DELAY_NORMAL);


        }else {
            Toast.makeText(this, "No Sensor Found", Toast.LENGTH_SHORT).show();
        }

    }
}

