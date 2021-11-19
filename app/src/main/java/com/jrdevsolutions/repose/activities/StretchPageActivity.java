package com.jrdevsolutions.repose.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.jrdevsolutions.repose.R;

public class StretchPageActivity extends AppCompatActivity {

    CountDownTimer cdTimer;
    TextView timerTextView;
    Button timerButton;
    long millisLeft = 30000;
    long min = 0;
    long sec = 0;

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

                    if(sec >= 10 && min == 0){
                    timerTextView.setText("0" + Long.toString(min) + ":" + Long.toString(sec) + "s");
                    } else timerTextView.setText("0" + Long.toString(min) + ":0" + Long.toString(sec) + "s");

                    Log.i("Tick", "Tock");
                }

                public void onFinish() {
                    timerTextView.setText(R.string.GoodJob);
                    millisLeft = 30000;
                    timerButton.setText(R.string.Start);
                }
            }.start();
        }
    };

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stretch_page);

        timerTextView = (TextView) findViewById(R.id.timerTextView);

        Button endButton = findViewById(R.id.endButton);
        endButton.setOnClickListener(view -> {
            Intent routinesActivityIntent = new Intent(this, RoutinesActivity.class);
            startActivity(routinesActivityIntent);
        });

        timerButton = findViewById(R.id.timerButton);
        timerButton.setText(R.string.Start);
        timerButton.setOnClickListener(view -> {
            if(timerButton.getText().equals("Start")){
                Log.i("Started", timerButton.getText().toString());
                timerButton.setText(R.string.Pause);
                timerHandler.postDelayed(timerRunnable, 5000);
                Toast.makeText(StretchPageActivity.this, "Your stretch will begin in 5 seconds!", Toast.LENGTH_LONG).show();
            } else if (timerButton.getText().equals("Pause")){
                Log.i("Paused", timerButton.getText().toString());
                timerButton.setText(R.string.Resume);
                timerPause();
            } else if (timerButton.getText().equals("Resume")){
                timerButton.setText(R.string.Pause);
                timerResume();
            }
        });
    }

    public void timerPause() {
        cdTimer.cancel();
    }

    private void timerResume() {
        Log.i("min", Long.toString(min));
        Log.i("Sec", Long.toString(sec));
        timerHandler.postDelayed(timerRunnable, 0);
    }
}