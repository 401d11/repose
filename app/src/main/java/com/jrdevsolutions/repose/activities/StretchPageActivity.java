package com.jrdevsolutions.repose.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;

import com.jrdevsolutions.repose.R;

import java.util.Timer;

public class StretchPageActivity extends AppCompatActivity {

        TextView timerTextView;
        Button timerButton;
        long millisLeft = 30000;
        long min = 0;
        long sec = 0;

    boolean isTimerAlreadyRunning;
        CountDownTimer cdTimer;

    public void timerPause() {
        cdTimer.cancel();
    }

    private void timerResume() {
        Log.i("min", Long.toString(min));
        Log.i("Sec", Long.toString(sec));
        timerHandler.postDelayed(timerRunnable, 0);
    }

        Handler timerHandler = new Handler();
        Runnable timerRunnable = new Runnable() {


            @SuppressLint("DefaultLocale")
            @Override
            public void run() {
                cdTimer = new CountDownTimer(millisLeft, 1000) {
                    @SuppressLint("SetTextI18n")
                    public void onTick(long milliTillFinish) {

                        millisLeft = milliTillFinish;
                        min = (milliTillFinish / (1000 * 60));
                        sec = ((milliTillFinish / 1000) - min * 60);

                        if(sec >= 10){
                        timerTextView.setText(Long.toString(min) + ":" + Long.toString(sec));
                        } else timerTextView.setText(Long.toString(min) + ":0" + Long.toString(sec));

                        Log.i("Tick", "Tock");
                    }


                    public void onFinish() {
                        timerTextView.setText("Done");
                        millisLeft = 30000;
                        timerButton.setText("Start");
                        isTimerAlreadyRunning = false;
                    }
                };

                cdTimer.start();
            }
        };

        @Override
        public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_stretch_page);

            isTimerAlreadyRunning = false;

            timerTextView = (TextView) findViewById(R.id.timerTextView);

            timerButton = (Button) findViewById(R.id.timerButton);
            timerButton.setText(R.string.Start);
            timerButton.setOnClickListener(view -> {
                if(timerButton.getText().equals("Start")){
                    Log.i("Started", timerButton.getText().toString());
                    timerButton.setText("Pause");
                    timerHandler.postDelayed(timerRunnable, 0);
//                    cdTimer.onTick(30*1000);
                } else if (timerButton.getText().equals("Pause")){
                    Log.i("Paused", timerButton.getText().toString());
                    timerButton.setText("Resume");
                    timerPause();
                } else if (timerButton.getText().equals("Resume")){
                    timerButton.setText("Pause");
                    timerResume();
                }
            });
        }

        @Override
        public void onPause() {
            super.onPause();
            timerHandler.removeCallbacks(timerRunnable);
            Button b = (Button)findViewById(R.id.timerButton);
            b.setText(R.string.Start);
        }



}