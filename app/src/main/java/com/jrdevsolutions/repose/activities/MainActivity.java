package com.jrdevsolutions.repose.activities;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.amplifyframework.auth.AuthUser;
import com.amplifyframework.core.Amplify;
import com.jrdevsolutions.repose.R;

public class MainActivity extends AppCompatActivity {
    public final static String TAG = "jrdevsolutions_stretch";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        AuthUser currentUser = Amplify.Auth.getCurrentUser();
        if (currentUser == null) {
            Intent goToLoginActivityIntent = new Intent(MainActivity.this, LoginActivity.class);
            startActivity(goToLoginActivityIntent);
        }

        ImageView appLogoImageView = findViewById(R.id.appLogoImageView);
        appLogoImageView.setImageResource(R.drawable.reposelogo);

        // Routines Activity
        Button homeRoutinesButton = findViewById(R.id.homeRoutinesButton);
        homeRoutinesButton.setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity.this, RoutinesActivity.class);
            startActivity(intent);
        });

        Button logoutButton = findViewById(R.id.logoutButton);
        logoutButton.setOnClickListener(view -> {
            Amplify.Auth.signOut(
                    () -> {
                        Log.i(TAG, "Logout Succeeded");
                    },
                    failure -> {
                        Log.i(TAG, "Logout Failed: " + failure.toString());
                    }
            );
            Intent goToLoginActivity = new Intent(MainActivity.this, LoginActivity.class);
            startActivity(goToLoginActivity);
        });
    }
}