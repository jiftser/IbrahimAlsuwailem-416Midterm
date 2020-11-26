package com.example.ibrahimalsuwailem_416midterm;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class Splash extends AppCompatActivity {
    TextView timer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        timer = (TextView)findViewById(R.id.timer);

        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                finish();
                startActivity(new Intent(Splash.this, MainActivity.class));
            }
        };
        Timer opening = new Timer();
        opening.schedule(task,10000);

        new CountDownTimer(10000, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                timer.setText(new SimpleDateFormat("ss").format(new Date(millisUntilFinished)));
            }

            @Override
            public void onFinish() {

            }
        }.start();
    }
}