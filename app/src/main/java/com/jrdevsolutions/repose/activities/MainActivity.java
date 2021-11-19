package com.jrdevsolutions.repose.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import com.jrdevsolutions.repose.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button startStretchActivity = findViewById(R.id.startStretchActivityIntentButton);
        startStretchActivity.setOnClickListener(view -> {
            Intent startStretchIntent = new Intent(MainActivity.this, StretchPageActivity.class);
            startActivity(startStretchIntent);
        });

    }
}