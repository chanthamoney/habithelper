package com.example.habithelper;

public class FriendPageFeed {
    private int id;
    private String name;
    private String message;
    private int image;


    public FriendPageFeed(int id, String name, String message, int image) {
        this.id = id;
        this.name = name;
        this.message = message;
        this.image = image;
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
}