package com.trapero.news;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class NewsDetailActivity extends AppCompatActivity {

    private TextView titleTextView;
    private TextView descriptionTextView;
    private ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news_detail); // Make sure to create this layout file

        // Initialize views
        titleTextView = findViewById(R.id.news_detail_title);
        descriptionTextView = findViewById(R.id.news_detail_description);
        imageView = findViewById(R.id.news_detail_image);

        // Get data from Intent
        Intent intent = getIntent();
        String title = intent.getStringExtra("title");
        String description = intent.getStringExtra("description");
        int imageResId = intent.getIntExtra("imageResId", 0);

        // Set data to views
        titleTextView.setText(title);
        descriptionTextView.setText(description);
        imageView.setImageResource(imageResId);
    }
}
