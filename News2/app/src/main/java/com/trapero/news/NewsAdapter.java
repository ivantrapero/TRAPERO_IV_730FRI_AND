package com.trapero.news;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class NewsAdapter extends BaseAdapter {

    private Context context;
    private ArrayList<NewsItem> newsItems;

    // Constructor to initialize context and list of news items
    public NewsAdapter(Context context, ArrayList<NewsItem> newsItems) {
        this.context = context;
        this.newsItems = newsItems;
    }

    @Override
    public int getCount() {
        return newsItems.size();
    }

    @Override
    public Object getItem(int position) {
        return newsItems.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.news_item, parent, false);
        }

        NewsItem currentItem = (NewsItem) getItem(position);

        // Find and set title, description, and image for the news item
        TextView titleTextView = convertView.findViewById(R.id.news_title);
        TextView descriptionTextView = convertView.findViewById(R.id.news_description);
        ImageView imageView = convertView.findViewById(R.id.news_image);

        titleTextView.setText(currentItem.getTitle());
        descriptionTextView.setText(currentItem.getDescription());
        imageView.setImageResource(currentItem.getImageResourceId()); // Set image from resource ID

        // Set click listener for the item
        convertView.setOnClickListener(v -> {
            Intent intent = new Intent(context, NewsDetailActivity.class);
            intent.putExtra("title", currentItem.getTitle());
            intent.putExtra("description", currentItem.getDescription());
            intent.putExtra("imageResId", currentItem.getImageResourceId());
            context.startActivity(intent);
        });

        return convertView;
    }
}

