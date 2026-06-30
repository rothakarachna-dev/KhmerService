package com.example.khmerservice;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout; // Ensure this is imported
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

public class HomepageActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        // 1. Retrieve the saved name
        SharedPreferences prefs = getSharedPreferences("UserPrefs", Context.MODE_PRIVATE);
        String userName = prefs.getString("user_name", "User");

        // 2. Set the name in your TextView
        TextView tvHelloUser = findViewById(R.id.tvHelloUser);
        tvHelloUser.setText("Hello, " + userName);

        // 3. Profile Icon click logic
        LinearLayout layoutProfileIcon = findViewById(R.id.layoutProfileIcon); // Ensure ID matches XML
        layoutProfileIcon.setOnClickListener(v -> {
            Intent intent = new Intent(HomepageActivity.this, ProfileActivity.class);
            startActivity(intent);
        });

        // 4. Booking Icon click logic
        findViewById(R.id.layoutBookingIcon).setOnClickListener(v -> {
            Intent intent = new Intent(HomepageActivity.this, BookingActivity.class);
            startActivity(intent);
        });

        // 5. CardView logic
        CardView cardAC_repair = findViewById(R.id.cardAC_repair);
        cardAC_repair.setOnClickListener(v -> {
            Intent intent = new Intent(HomepageActivity.this, ServiceActivity.class);
            startActivity(intent);
        });
    }
}