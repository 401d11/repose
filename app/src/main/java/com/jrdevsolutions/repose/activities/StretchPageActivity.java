package com.jrdevsolutions.repose.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.util.Log;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.amplifyframework.api.graphql.model.ModelQuery;
import com.amplifyframework.core.Amplify;
import com.amplifyframework.datastore.generated.model.Stretch;
import com.jrdevsolutions.repose.R;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class StretchPageActivity extends AppCompatActivity {

    public final static String TAG = "jrdevsolutions_repose_stretchpageactivity";

    CountDownTimer cdTimer;
    TextView timerTextView;
    Button timerButton;
    long millisLeft = (5 * 1000) + 999;
    long min = 0;
    long sec = 0;
    public List<Stretch> stretchList = new ArrayList<>();
    int currentStretchIndex = 0;
    TextView stretchNameTextView;
    TextView setsLeftTextView;
    TextView repsLeftTextView;
    TextView stretchDescription;
    int currentReps = 10;
    int currentSets = 1;

    Handler timerHandler = new Handler();
    Runnable timerRunnable = new Runnable() {


        @SuppressLint("DefaultLocale")
        @Override
        public void run() {
            cdTimer = new CountDownTimer(millisLeft, 100) {
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
                    millisLeft = (5 * 1000) + 999;
                    timerTextView.setText("0" + Long.toString(min) + ":" + Long.toString(sec) + "s");
                    currentReps++;
                    if (currentReps > stretchList.get(currentStretchIndex).getReps()) {
                        currentReps = 10;
                        currentSets++;
                        repsLeftTextView.setText(currentReps + " / " + stretchList.get(currentStretchIndex).getReps());
                        setsLeftTextView.setText(currentSets + " / " + stretchList.get(currentStretchIndex).getSets());
                    }
                    if (currentSets > stretchList.get(currentStretchIndex).getSets()) {
                        currentSets = 1;
                        currentStretchIndex++;
                        if (currentStretchIndex == stretchList.size()) {
//                            timerButton.setText("Start");
                            Intent intent = new Intent(StretchPageActivity.this, FinishedActivity.class);
                            startActivity(intent);
                        } else {
                            stretchNameTextView.setText(stretchList.get(currentStretchIndex).getName());
                            stretchDescription.setText(stretchList.get(currentStretchIndex).getDescription());
                            repsLeftTextView.setText(currentReps + " / " + stretchList.get(currentStretchIndex).getReps());
                            setsLeftTextView.setText(currentSets + " / " + stretchList.get(currentStretchIndex).getSets());
                        }
                    }
                    repsLeftTextView.setText(currentReps + " / " + stretchList.get(currentStretchIndex).getReps());
                    setsLeftTextView.setText(currentSets + " / " + stretchList.get(currentStretchIndex).getSets());
                    timerHandler.postDelayed(timerRunnable, 000);
                }
            }.start();
        }
    };

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stretch_page);

        Intent intent = getIntent();
        ArrayList<String> stretchIdList = intent.getStringArrayListExtra("Stretches");

        Amplify.API.query(
                ModelQuery.list(Stretch.class),
                success -> {
                    for (Stretch stretch : success.getData()) {
                        for (String idString : stretchIdList) {
                            if (idString.equals(stretch.getId())) {
                                stretchList.add(stretch);
                            }
                        }
                    }
                    stretchNameTextView = findViewById(R.id.stretchNameTextView);
                    setsLeftTextView = findViewById(R.id.setsLeftTextView);
                    repsLeftTextView = findViewById(R.id.repsLeftTextView);
                    stretchDescription = findViewById(R.id.stretchDescription);
//                    getImageFileFromS3AndSetImageView(stretchList.get(0).getImageKey());
                    runOnUiThread(() -> {
                        stretchNameTextView.setText(stretchList.get(0).getName());
                        repsLeftTextView.setText(currentReps + " / " + stretchList.get(0).getReps());
                        setsLeftTextView.setText(currentSets + " / " + stretchList.get(0).getSets());
                        stretchDescription.setText(stretchList.get(0).getDescription());
                    });
                },
                failure -> {
                    Log.e(TAG, "Failed to grab stretches by ID:" + failure);
                }
        );

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

    protected void getImageFileFromS3AndSetImageView(String s3ImageKey) {
        if (s3ImageKey != null) {
            Amplify.Storage.downloadFile(
                    s3ImageKey,
                    new File(getApplicationContext().getFilesDir(), s3ImageKey),
                    success -> {
                        Log.i(TAG, "Image download succesfully from S3 with name: " + success.getFile().getName());
                        runOnUiThread( () -> {
                            ImageView stretchPictureImageView = findViewById(R.id.stretchPictureImageView);
                            stretchPictureImageView.setImageBitmap(BitmapFactory.decodeFile(success.getFile().getPath()));
                        });
                    },
                    failure -> {
                        Log.e(TAG, "Failed to download image from S3! Key is: " + s3ImageKey + " with error: " + failure.getMessage(), failure);
                    }
            );
        }
    }
}