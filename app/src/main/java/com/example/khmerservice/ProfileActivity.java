package com.example.khmerservice;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

public class ProfileActivity extends AppCompatActivity {

    private static final String ICON_ADDRESS       = "https://cdn-icons-png.flaticon.com/512/684/684908.png";
    private static final String ICON_BILL          = "https://cdn-icons-png.flaticon.com/512/2271/2271024.png";
    private static final String ICON_LANGUAGE      = "https://cdn-icons-png.flaticon.com/512/484/484633.png";
    private static final String ICON_EXCHANGE_RATE = "https://cdn-icons-png.flaticon.com/512/4256/4256900.png";
    private static final String ICON_FEEDBACK      = "https://cdn-icons-png.flaticon.com/512/1827/1827933.png";
    private static final String ICON_CONVERSION    = "https://cdn-icons-png.flaticon.com/512/3258/3258922.png";

    private static final String AVATAR_PLACEHOLDER = "https://cdn-icons-png.flaticon.com/512/149/149071.png";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        loadIcons();
        setupMenuClickListeners();
        setupBottomNavClickListeners();
        setupServiceCardClickListeners();
    }

    private void loadIconUrl(ImageView target, String url) {
        Glide.with(this)
                .load(url)
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .placeholder(R.drawable.bg_circle_light)
                .error(R.drawable.ic_person_placeholder)
                .into(target);
    }

    private void loadIcons() {

        loadIconUrl(findViewById(R.id.imgUserAvatar), AVATAR_PLACEHOLDER);

        loadIconUrl(findViewById(R.id.imgIconAddress), ICON_ADDRESS);
        loadIconUrl(findViewById(R.id.imgIconBill), ICON_BILL);
        loadIconUrl(findViewById(R.id.imgIconLanguage), ICON_LANGUAGE);
        loadIconUrl(findViewById(R.id.imgIconExchangeRate), ICON_EXCHANGE_RATE);
        loadIconUrl(findViewById(R.id.imgIconFeedback), ICON_FEEDBACK);
        loadIconUrl(findViewById(R.id.imgIconConversion), ICON_CONVERSION);

        // Service card avatars
        loadIconUrl(
                findViewById(R.id.cardService1).findViewById(R.id.imgServiceAvatar),
                AVATAR_PLACEHOLDER
        );

        loadIconUrl(
                findViewById(R.id.cardService2).findViewById(R.id.imgServiceAvatar),
                AVATAR_PLACEHOLDER
        );
    }

    private void setupMenuClickListeners() {

        findViewById(R.id.rowAddress).setOnClickListener(v ->
                Toast.makeText(this, "Address clicked", Toast.LENGTH_SHORT).show());

        findViewById(R.id.rowBill).setOnClickListener(v ->
                Toast.makeText(this, "Bill clicked", Toast.LENGTH_SHORT).show());

        findViewById(R.id.rowLanguage).setOnClickListener(v ->
                Toast.makeText(this, "Language clicked", Toast.LENGTH_SHORT).show());

        findViewById(R.id.rowExchangeRate).setOnClickListener(v ->
                Toast.makeText(this, "Preferred exchange rate clicked", Toast.LENGTH_SHORT).show());

        findViewById(R.id.rowFeedback).setOnClickListener(v ->
                Toast.makeText(this, "Feedback clicked", Toast.LENGTH_SHORT).show());

        findViewById(R.id.rowConversion).setOnClickListener(v ->
                Toast.makeText(this, "Conversion clicked", Toast.LENGTH_SHORT).show());
    }

    private void setupBottomNavClickListeners() {

        // Home
        findViewById(R.id.navHome).setOnClickListener(v -> {
            Intent intent = new Intent(ProfileActivity.this, HomepageActivity.class);
            startActivity(intent);
            finish();
        });

        // Booking
        findViewById(R.id.navBooking).setOnClickListener(v -> {
            Intent intent = new Intent(ProfileActivity.this, BookingActivity.class);
            startActivity(intent);
            finish();
        });

        // Already on Profile
        findViewById(R.id.navProfile).setOnClickListener(v ->
                Toast.makeText(this, "Profile", Toast.LENGTH_SHORT).show());
    }

    private void setupServiceCardClickListeners() {

        findViewById(R.id.cardService1).setOnClickListener(v ->
                Toast.makeText(this, "Service 1 clicked", Toast.LENGTH_SHORT).show());

        findViewById(R.id.cardService2).setOnClickListener(v ->
                Toast.makeText(this, "Service 2 clicked", Toast.LENGTH_SHORT).show());
    }
}