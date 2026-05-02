package com.example.khmerservice;


import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;


public class Onboarding2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_onboarding2);

        Button btnGetStart = findViewById(R.id.btn_get_start);
        btnGetStart.setOnClickListener(v -> {
            startActivity(new Intent(Onboarding2Activity.this, MainActivity.class));
            finish(); // close onboarding so user can't go back
        });
    }
}
