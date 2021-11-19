package com.jrdevsolutions.repose.activities;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;

import com.amplifyframework.api.graphql.model.ModelMutation;
import com.amplifyframework.core.Amplify;
import com.amplifyframework.datastore.generated.model.Stretch;
import com.jrdevsolutions.repose.R;

public class MainActivity extends AppCompatActivity {
    public final static String TAG = "jrdevsolutions_stretch";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Routines Activity
        Button homeRoutinesButton = findViewById(R.id.homeRoutinesButton);
        homeRoutinesButton.setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity.this, RoutinesActivity.class);
            startActivity(intent);
        });
    }
}