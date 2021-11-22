package com.jrdevsolutions.repose.activities;

import static android.content.ContentValues.TAG;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;

import com.amplifyframework.core.Amplify;
import com.jrdevsolutions.repose.R;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class FinishedActivity extends AppCompatActivity {
    private final MediaPlayer mp = new MediaPlayer();
    public final static String TAG = "jrdevsolutions_repose_stretchpageactivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_finished);

        playString("Well done!");

        Button finishedRestartButton = findViewById(R.id.finishedRestartButton);
        finishedRestartButton.setOnClickListener(view -> {
            Intent intent = new Intent(FinishedActivity.this, RoutinesActivity.class);
            startActivity(intent);
        });
    }

    public void playString(String string){
        Amplify.Predictions.convertTextToSpeech(
                string,
                result -> playAudio(result.getAudioData()),
                error -> Log.e(TAG, "Conversion failed", error)
        );
    }

    protected void playAudio(InputStream data) {
        File mp3File = new File(getCacheDir(), "audio.mp3");

        try (OutputStream out = new FileOutputStream(mp3File)) {
            byte[] buffer = new byte[8 * 1_024];
            int bytesRead;
            while ((bytesRead = data.read(buffer)) != -1) {
                out.write(buffer, 0, bytesRead);
            }
            mp.reset();
            mp.setOnPreparedListener(MediaPlayer::start);
            mp.setDataSource(new FileInputStream(mp3File).getFD());
            mp.prepareAsync();
        } catch (IOException error) {
            Log.e(TAG, "Error writing audio file", error);
        }
    }
}