package com.example.khmerservice;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public class ChatListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat_list);

        // Open chat
        findViewById(R.id.chatSoPhana).setOnClickListener(v -> {
            startActivity(new Intent(ChatListActivity.this, ChatActivity.class));
        });

        // Home
        findViewById(R.id.layoutHomeIcon).setOnClickListener(v -> {
            startActivity(new Intent(ChatListActivity.this, HomepageActivity.class));
        });

        // Profile
        findViewById(R.id.layoutProfileIcon).setOnClickListener(v -> {
            startActivity(new Intent(ChatListActivity.this, ProfileActivity.class));
        });

        // Already on Chats page
        findViewById(R.id.layoutBookingIcon).setOnClickListener(v -> {
            // Do nothing
        });
    }
}