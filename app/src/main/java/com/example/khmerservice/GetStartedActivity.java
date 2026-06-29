package com.example.khmerservice;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class GetStartedActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);

        Button btnGetStarted = findViewById(R.id.btn_get_start);

        btnGetStarted.setOnClickListener(v -> {
            // Updated to redirect to AuthActivity
            Intent intent = new Intent(GetStartedActivity.this, AuthActivity.class);
            startActivity(intent);
            finish(); // Finishes this activity so user can't go back to it
        });
    }
}