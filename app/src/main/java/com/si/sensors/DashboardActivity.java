package com.si.sensors;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class DashboardActivity extends AppCompatActivity implements View.OnClickListener {
    private Button btn1, btn2, btn3, btn4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);
        btn3 = findViewById(R.id.btn3);
        btn4 = findViewById(R.id.btn4);
        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        btn3.setOnClickListener(this);
        btn3.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId()==R.id.btn1){
            Intent intent = new Intent(DashboardActivity.this,MainActivity.class);
            startActivity(intent);
        } else if (v.getId()==R.id.btn2) {
           Intent intent2 = new Intent(DashboardActivity.this,AcceleromoterActivity.class);
           startActivity(intent2);
        } else if (v.getId()==R.id.btn3) {
            Intent intent2 = new Intent(DashboardActivity.this,GyroscopeActivity.class);
            startActivity(intent2);
        } else {
            Intent intent2 = new Intent(DashboardActivity.this,ProximityActivity.class);
            startActivity(intent2);
        }
    }
}
