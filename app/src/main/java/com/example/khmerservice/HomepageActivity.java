package com.example.khmerservice;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView; // Import TextView
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

public class HomepageActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        // 1. Retrieve the saved name
        SharedPreferences prefs = getSharedPreferences("UserPrefs", Context.MODE_PRIVATE);
        String userName = prefs.getString("user_name", "User"); // Default to "User" if not found

        // 2. Set the name in your TextView
        // Ensure you have a TextView in activity_home with id: tvHelloUser
        TextView tvHelloUser = findViewById(R.id.tvHelloUser);
        tvHelloUser.setText("Hello, " + userName);

        // CardView logic
        CardView cardAC_repair = findViewById(R.id.cardAC_repair);
        cardAC_repair.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomepageActivity.this, ServiceActivity.class);
                startActivity(intent);
            }
        });
    }
}