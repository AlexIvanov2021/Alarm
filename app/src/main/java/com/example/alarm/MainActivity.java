package com.example.alarm;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Date;

public class MainActivity extends AppCompatActivity {
    TextView textViewTime;
    String timeNow;
    boolean logicAlarm = true;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textViewTime = findViewById(R.id.textViewTime);


        Handler handler = new Handler();
        handler.post(new Runnable() {
            private Object alarmTime;

            @Override
            public void run() {
                Date date = new Date();
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm");
                textViewTime.setText(""+simpleDateFormat.format(date));
                alarmTime("16:49");
                handler.postDelayed(this,1000);
            }

        });

    }

    private void alarmTime(String timeAlarm) {
        if(textViewTime.getText().toString().equals(timeAlarm)&&logicAlarm){
            AlarmFragment alarmFragment = new AlarmFragment();
            alarmFragment.show(getSupportFragmentManager(),"show");
    }
}
}