package com.example.khmerservice;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;

public class BookingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_booking);

        findViewById(R.id.btn_back).setOnClickListener(v -> {
            Intent intent = new Intent(BookingActivity.this, HomepageActivity.class);
            startActivity(intent);
            finish();
        });
    }
}