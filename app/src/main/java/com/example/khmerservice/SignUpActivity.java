package com.example.khmerservice;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.example.khmerservice.R;

public class SignUpActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        SharedPreferences prefs = getSharedPreferences("UserPrefs", Context.MODE_PRIVATE);
        if (prefs.getBoolean("is_logged_in", false)) {
            startActivity(new Intent(this, HomepageActivity.class));
            finish();
            return;
        }

        setContentView(R.layout.activity_signup);

        // Find views
        EditText etFullName = findViewById(R.id.etFullName); // Ensure your XML has this ID
        TextView tvLogIn = findViewById(R.id.tvLogIn);
        Button btnCreateAccount = findViewById(R.id.btnCreateAccount);

        tvLogIn.setOnClickListener(v -> {
            Intent intent = new Intent(SignUpActivity.this, LoginActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);
            startActivity(intent);
            finish();
        });

        btnCreateAccount.setOnClickListener(v -> {
            // Capture the input
            String name = etFullName.getText().toString().trim();

            // Simple validation
            if (!name.isEmpty()) {
                saveUserSession("new_user_email", name);
                startActivity(new Intent(SignUpActivity.this, HomepageActivity.class));
                finish();
            } else {
                etFullName.setError("Please enter your name");
            }
        });
    }

    private void saveUserSession(String email, String name) {
        SharedPreferences sharedPreferences = getSharedPreferences("UserPrefs", Context.MODE_PRIVATE);
        sharedPreferences.edit()
                .putString("user_email", email)
                .putString("user_name", name) // Save the name here
                .putBoolean("is_logged_in", true)
                .apply();
    }
}