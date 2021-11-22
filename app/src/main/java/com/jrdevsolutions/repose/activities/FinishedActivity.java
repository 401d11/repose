package com.jrdevsolutions.repose.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import com.jrdevsolutions.repose.R;

public class FinishedActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_finished);

        Button finishedRestartButton = findViewById(R.id.finishedRestartButton);
        finishedRestartButton.setOnClickListener(view -> {
            Intent intent = new Intent(FinishedActivity.this, RoutinesActivity.class);
            startActivity(intent);
        });
    }
}