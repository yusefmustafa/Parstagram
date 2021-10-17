package com.example.parstagram;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.parse.Parse;
import com.parse.ParseException;
import com.parse.ParseUser;
import com.parse.SignUpCallback;

public class SignupActivity extends AppCompatActivity {

    private EditText etSignupUsername;
    private EditText etSignupPassword;
    private Button btnSignupSignup;
    private static String TAG = "SignupActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_signup);

//        if (ParseUser.getCurrentUser() != null) {
//            goMainActivity();
//        }
        etSignupUsername = findViewById(R.id.etSignupUsername);
        etSignupPassword = findViewById(R.id.etSignupPassword);
        btnSignupSignup = findViewById(R.id.btnSignupSignup);
        btnSignupSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = etSignupUsername.getText().toString();
                String password = etSignupPassword.getText().toString();
                if (username.isEmpty()) {
                    Toast.makeText(btnSignupSignup.getContext(), "Please enter a valid username", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (password.isEmpty()) {
                    Toast.makeText(btnSignupSignup.getContext(), "Please enter a valid password", Toast.LENGTH_SHORT).show();
                    return;
                }
                ParseUser user = new ParseUser();
                user.setUsername(username);
                user.setPassword(password);
                user.signUpInBackground(new SignUpCallback() {
                    public void done(ParseException e) {
                        if (e != null) {
                            Log.e(TAG, "Error while signing up", e);
                            return;
                        }
                        Log.i(TAG, "Signed up and logged in as: " + ParseUser.getCurrentUser().getUsername());
                        goMainActivity();
                    }
                });
            }
        });
    }

    private void goMainActivity() {
        Intent i = new Intent(this, MainActivity.class);
        startActivity(i);
        finish();
    }
}
