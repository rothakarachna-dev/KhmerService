package com.example.khmerservice;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class ServiceActivity extends AppCompatActivity {

    private ImageView ivHome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service_detail);

        // Initialize the home button
        ivHome = findViewById(R.id.iv_home);

        // Navigate to HomepageActivity when clicked
        ivHome.setOnClickListener(v -> {
            Intent intent = new Intent(ServiceActivity.this, HomepageActivity.class);
            startActivity(intent);
            finish(); // Closes ServiceActivity so the user can't return to it by pressing Back
        });
    }
}