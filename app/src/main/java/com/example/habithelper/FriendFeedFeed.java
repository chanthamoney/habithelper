package com.example.habithelper;

public class FriendFeedFeed {
    private int id;
    private String name;
    private String message;
    private int image;
    private String tag;

    public FriendFeedFeed(int id, String name, String message, int image) {
        this.id = id;
        this.name = name;
        this.message = message;
        this.image = image;
        if (id >= 8) {
            tag = "profilePik";
        } else {
        }
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getMessage() {
        return message;
    }

    public int getImage() {
        return image;
    }

    public String getTag() {
        return tag;
    }
}
