package com.example.khmerservice;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

public class HomepageActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        // Retrieve the saved user name
        SharedPreferences prefs = getSharedPreferences("UserPrefs", Context.MODE_PRIVATE);
        String userName = prefs.getString("user_name", "User");

        // Display greeting
        TextView tvHelloUser = findViewById(R.id.tvHelloUser);
        tvHelloUser.setText("Hello, " + userName);

        // ==========================
        // Profile Icon
        // ==========================
        LinearLayout layoutProfileIcon = findViewById(R.id.layoutProfileIcon);
        layoutProfileIcon.setOnClickListener(v -> {
            Intent intent = new Intent(HomepageActivity.this, ProfileActivity.class);
            startActivity(intent);
        });

        // ==========================
        // Chat Icon
        // Opens the All Chats page
        // ==========================
        LinearLayout layoutBookingIcon = findViewById(R.id.layoutBookingIcon);
        layoutBookingIcon.setOnClickListener(v -> {
            Intent intent = new Intent(HomepageActivity.this, ChatListActivity.class);
            startActivity(intent);
        });

        // ==========================
        // AC Repair Service Card
        // ==========================
        CardView cardACRepair = findViewById(R.id.cardAC_repair);
        cardACRepair.setOnClickListener(v -> {
            Intent intent = new Intent(HomepageActivity.this, ServiceActivity.class);
            startActivity(intent);
        });
    }
}