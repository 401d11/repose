package com.jrdevsolutions.repose.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.widget.Button;
import android.widget.TextView;

import com.jrdevsolutions.repose.R;

import java.util.Timer;

public class StretchPageActivity extends AppCompatActivity {

        TextView timerTextView;
        long startTime = 0;
        boolean isTimerAlreadyRunning = false;


        //runs without a timer by reposting this handler at the end of the runnable
        Handler timerHandler = new Handler();
        Runnable timerRunnable = new Runnable() {


            @SuppressLint("DefaultLocale")
            @Override
            public void run() {
                new CountDownTimer(30000, 1000) {
                    public void onTick(long millisUntilFinished) {
                        if(millisUntilFinished >= 10000){
                        timerTextView.setText(String.format("0:%d", millisUntilFinished / 1000));
                        } else timerTextView.setText(String.format("0:0%d", millisUntilFinished / 1000));


//                                "Seconds remaining: " + millisUntilFinished / 1000);
                    }

                    public void onFinish() {
                        timerTextView.setText("Done");
                        isTimerAlreadyRunning = false;
                    }
                }.start();
//                long millis = System.currentTimeMillis() - startTime;
//                int seconds = (int) (millis / 1000);
//                int minutes = seconds / 60;
//                seconds = seconds % 60;

//                timerTextView.setText(String.format("%d:%02d", minutes, seconds));

//                timerHandler.postDelayed(this, 500);
            }
        };

        @Override
        public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_stretch_page);

            timerTextView = (TextView) findViewById(R.id.timerTextView);

            Button timerButton = (Button) findViewById(R.id.timerButton);
            timerButton.setText(R.string.Start);
            timerButton.setOnClickListener(view -> {
                if (timerButton.getText().equals("Stop")) {
                    timerHandler.removeCallbacks(timerRunnable);
                    timerButton.setText(R.string.Start);
                } else if(timerButton.getText().equals("Start") && isTimerAlreadyRunning){
                    startTime = System.currentTimeMillis();
                    timerHandler.postDelayed(timerRunnable, 0);
                    timerButton.setText(R.string.Stop);
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