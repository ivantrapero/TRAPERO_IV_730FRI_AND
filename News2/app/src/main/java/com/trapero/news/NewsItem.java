package com.trapero.news;

public class NewsItem {
    // Fields for news title, description, and image resource
    private String title;
    private String description;
    private int imageResourceId;  // Use int for local drawable resources or String for URLs

    // Constructor to initialize a NewsItem object
    public NewsItem(String title, String description, int imageResourceId) {
        this.title = title;
        this.description = description;
        this.imageResourceId = imageResourceId;
    }

    // Getter method for the news title
    public String getTitle() {
        return title;
    }

    // Getter method for the news description
    public String getDescription() {
        return description;
    }

    // Getter method for the image resource ID
    public int getImageResourceId() {
        return imageResourceId;
    }

    private String imageUrl;  // For image URLs

    public NewsItem(String title, String description, String imageUrl) {
        this.title = title;
        this.description = description;
        this.imageUrl = imageUrl;
    }

    public String getImageUrl() {
        return imageUrl;
    }
}
