package com.example.khmerservice;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class ChatActivity extends AppCompatActivity {

    private RecyclerView rvMessages;
    private MessageAdapter messageAdapter;
    private List<Message> messageList;
    private EditText etMessage;
    private ImageView ivSend, ivBack, ivCall;
    private TextView tvServicerName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);

        String servicerName = getIntent().getStringExtra("servicer_name");

        tvServicerName = findViewById(R.id.tv_servicer_name);
        if (!TextUtils.isEmpty(servicerName)) {
            tvServicerName.setText(servicerName);
        }

        rvMessages = findViewById(R.id.rv_messages);
        etMessage = findViewById(R.id.et_message);
        ivSend = findViewById(R.id.iv_send);
        ivBack = findViewById(R.id.iv_back);
        ivCall = findViewById(R.id.iv_call);

        messageList = new ArrayList<>();
        // Sample conversation — replace with real chat history later
        messageList.add(new Message("Hi, I'm interested in booking your AC repair service.", Message.TYPE_SENT));
        messageList.add(new Message("Hello! Sure, what day works best for you?", Message.TYPE_RECEIVED));
        messageList.add(new Message("Would tomorrow afternoon work?", Message.TYPE_SENT));
        messageList.add(new Message("Yes, I'm free after 2 PM tomorrow.", Message.TYPE_RECEIVED));
        messageList.add(new Message("Great, what's the issue with your AC?", Message.TYPE_RECEIVED));
        messageList.add(new Message("It's not cooling properly and makes a strange noise.", Message.TYPE_SENT));
        messageList.add(new Message("Got it. I'll bring the right tools. Could you share your address?", Message.TYPE_RECEIVED));
        messageList.add(new Message("Sure, I'll send it once I confirm the booking.", Message.TYPE_SENT));
        messageList.add(new Message("Sounds good, see you tomorrow at 2 PM!", Message.TYPE_RECEIVED));

        messageAdapter = new MessageAdapter(messageList);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        rvMessages.setLayoutManager(layoutManager);
        rvMessages.setAdapter(messageAdapter);
        rvMessages.scrollToPosition(messageList.size() - 1);

        ivBack.setOnClickListener(v -> finish());

        ivCall.setOnClickListener(v -> {
            // TODO: launch phone dialer intent
        });

        ivSend.setOnClickListener(v -> sendMessage());

        setupBottomNav();
    }

    private void sendMessage() {
        String text = etMessage.getText().toString().trim();
        if (TextUtils.isEmpty(text)) return;

        messageList.add(new Message(text, Message.TYPE_SENT));
        messageAdapter.notifyItemInserted(messageList.size() - 1);
        rvMessages.scrollToPosition(messageList.size() - 1);
        etMessage.setText("");
    }

    private void setupBottomNav() {
        findViewById(R.id.layoutHomeIcon).setOnClickListener(v -> {
            Intent intent = new Intent(ChatActivity.this, HomepageActivity.class);
            startActivity(intent);
            finish();
        });

        findViewById(R.id.layoutBookingIcon).setOnClickListener(v -> {
            Intent intent = new Intent(ChatActivity.this, BookingActivity.class);
            startActivity(intent);
        });

        findViewById(R.id.layoutProfileIcon).setOnClickListener(v -> {
            Intent intent = new Intent(ChatActivity.this, ProfileActivity.class);
            startActivity(intent);
        });
    }

    // ===================== MESSAGE MODEL =====================
    // (Static nested class instead of a separate Message.java file)
    static class Message {
        static final int TYPE_SENT = 0;
        static final int TYPE_RECEIVED = 1;

        private final String text;
        private final int type;

        Message(String text, int type) {
            this.text = text;
            this.type = type;
        }

        String getText() {
            return text;
        }

        int getType() {
            return type;
        }
    }

    // ===================== MESSAGE ADAPTER =====================
    // (Static nested class instead of a separate MessageAdapter.java file)
    static class MessageAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

        private final List<Message> messageList;

        MessageAdapter(List<Message> messageList) {
            this.messageList = messageList;
        }

        @Override
        public int getItemViewType(int position) {
            return messageList.get(position).getType();
        }

        @NonNull
        @Override
        public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            LayoutInflater inflater = LayoutInflater.from(parent.getContext());
            if (viewType == Message.TYPE_SENT) {
                View view = inflater.inflate(R.layout.item_message_sent, parent, false);
                return new SentViewHolder(view);
            } else {
                View view = inflater.inflate(R.layout.item_message_received, parent, false);
                return new ReceivedViewHolder(view);
            }
        }

        @Override
        public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
            Message message = messageList.get(position);
            if (holder instanceof SentViewHolder) {
                ((SentViewHolder) holder).tvMessage.setText(message.getText());
            } else if (holder instanceof ReceivedViewHolder) {
                ((ReceivedViewHolder) holder).tvMessage.setText(message.getText());
            }
        }

        @Override
        public int getItemCount() {
            return messageList.size();
        }

        static class SentViewHolder extends RecyclerView.ViewHolder {
            TextView tvMessage;
            SentViewHolder(View itemView) {
                super(itemView);
                tvMessage = itemView.findViewById(R.id.tv_message_sent);
            }
        }

        static class ReceivedViewHolder extends RecyclerView.ViewHolder {
            TextView tvMessage;
            ReceivedViewHolder(View itemView) {
                super(itemView);
                tvMessage = itemView.findViewById(R.id.tv_message_received);
            }
        }
    }
}