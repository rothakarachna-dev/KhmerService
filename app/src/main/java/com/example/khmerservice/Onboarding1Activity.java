package com.example.khmerservice;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;

public class Onboarding1Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_onboarding1);

        findViewById(android.R.id.content).setOnClickListener(v -> {
            Intent intent = new Intent(Onboarding1Activity.this, Onboarding2Activity.class);
            ActivityOptions options = ActivityOptions.makeCustomAnimation(
                    this,
                    android.R.anim.slide_in_left,
                    android.R.anim.slide_out_right
            );
            startActivity(intent, options.toBundle());
        });
    }
}