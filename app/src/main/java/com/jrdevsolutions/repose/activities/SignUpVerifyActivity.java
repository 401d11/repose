package com.jrdevsolutions.repose.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.amplifyframework.core.Amplify;
import com.jrdevsolutions.repose.R;

public class SignUpVerifyActivity extends AppCompatActivity {
    public final static String TAG = "jrdevsolutions_repose_signupverifyactivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up_verify);

        Intent intent = getIntent();
        EditText verifyEmailEditText = findViewById(R.id.verifyEmailEditText);
        verifyEmailEditText.setText(intent.getStringExtra(SignUpActivity.NEW_USER_EMAIL));
        EditText verifyCodeEditText = findViewById(R.id.loginEmailEditText);

        Button verifySignUpButton = findViewById(R.id.loginButton);
        verifySignUpButton.setOnClickListener( view -> {
            String email = verifyEmailEditText.getText().toString();
            String verificationCode = verifyCodeEditText.getText().toString();

            Amplify.Auth.confirmSignUp(email,
                    verificationCode,
                    success -> {
                        Log.i(TAG, "Verification Succeeded: " + success.toString());
                        Intent goToLoginActivity = new Intent(SignUpVerifyActivity.this, LoginActivity.class);
                        startActivity(goToLoginActivity);
                    },
                    failure -> {
                        Log.i(TAG, "Verification Failed: " + failure.toString());
                        runOnUiThread(() -> Toast.makeText(SignUpVerifyActivity.this, "Could not verify that user!", Toast.LENGTH_SHORT).show());
                    });
        });
    }
}