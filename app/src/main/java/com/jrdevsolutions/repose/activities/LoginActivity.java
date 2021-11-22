package com.jrdevsolutions.repose.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.amplifyframework.core.Amplify;
import com.jrdevsolutions.repose.R;

public class LoginActivity extends AppCompatActivity {
    public final static String TAG = "jrdevsolutions_repose_loginactivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Button loginButton = findViewById(R.id.loginButton);
        loginButton.setOnClickListener( view -> {
            EditText loginUsernameEditText = findViewById(R.id.loginEmailEditText);
            String username = loginUsernameEditText.getText().toString();
            EditText loginPasswordEditText = findViewById(R.id.loginPasswordEditText);
            String password = loginPasswordEditText.getText().toString();

            Amplify.Auth.signIn(username,
                    password,
                    success -> {
                        Log.i(TAG, "Login Succeeded: " + success.toString());
                        Intent goToMainActivityIntent = new Intent(LoginActivity.this, MainActivity.class);
                        startActivity(goToMainActivityIntent);
                    },
                    failure -> {
                        Log.i(TAG, "Login Failed: " + failure.toString());
                        runOnUiThread(() -> Toast.makeText(LoginActivity.this, "Could not log in that user!", Toast.LENGTH_SHORT).show());
                    });
        });

        TextView signUpHereTextView = findViewById(R.id.signUpHereTextView);
        signUpHereTextView.setOnClickListener( view -> {
            Intent intent = new Intent(LoginActivity.this, SignUpActivity.class);
            startActivity(intent);
        });
    }
}