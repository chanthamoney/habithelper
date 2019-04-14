package com.example.habithelper;

import android.graphics.Bitmap;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Globals {


    private static Globals instance = new Globals();

    // Getter-Setters
    public static Globals getInstance() {
        return instance;
    }

    public static void setInstance(Globals instance) {
        Globals.instance = instance;
    }

    private Bitmap profilePicture;
    private String profileName;
    private String username;
    private String email;
    private String bio;

    private Globals() {

    }

    public Bitmap getProfilePicture() {
        return profilePicture;
    }


    public void setProfilePicture(Bitmap pp) {
        this.profilePicture = pp;
    }

    public String getProfileName() {
        return profileName != null ? profileName : "Kassi Soukaroune";
    }

    public void setProfileName(String pn) {
        this.profileName = pn;
    }


    public String getUsername() {
        return username != null ? username : "@KassiSouk";
    }

    public void setUsername(String un) {
        this.username = "@" + un;
    }


    public String getBio() {
        return bio != null ? bio : "I didn't say yee";
    }

    public void setBio(String b) {
        this.bio = b;
    }


    public String getEmail() {
        return email != null ? email : "Kassi Soukaroune";
    }

    public void setEmail(String e) {
        this.email = e;
    }

    public void clear(){
        profilePicture = null;
        username = null;
        bio = null;
        profileName = null;
        email = "user1523@swearjarapp.com";
    }

    public List<FriendFeedFeed> getFriendFeedList() {
        //initializing the productlist
        List<FriendFeedFeed> friendFeedList = new ArrayList<>();
        //adding some items to our list
        //adding some items to our list
        friendFeedList.add(
                new FriendFeedFeed(1, "Ariana Grande", "Was penalized for habit of \"Using too much spray tan\"",
                        R.drawable.arigrande));
        friendFeedList.add(
                new FriendFeedFeed(2, "Ariana Grande", "Made progress on good habit of \"Writing Lyrics\"",
                        R.drawable.arigrande));
        friendFeedList.add(
                new FriendFeedFeed(3, "Ariana Grande", "Made progress on good habit of \"Walking in Nature\"",
                        R.drawable.arigrande));

        friendFeedList.add(
                new FriendFeedFeed(4, "Jonathan Van Ness", "Made progress on good habit of \"Listening to Beyoncé\"",
                        R.drawable.jvn));
        friendFeedList.add(
                new FriendFeedFeed(5, "Jonathan Van Ness", "Was penalized for habit of \"Saying Queen\"",
                        R.drawable.jvn));
        friendFeedList.add(
                new FriendFeedFeed(6, "Jonathan Van Ness", "Made progress on good habit of \"Wearing Sunscreen\"",
                        R.drawable.jvn));
        friendFeedList.add(
                new FriendFeedFeed(7, "Jonathan Van Ness", "Made progress on good habit of \"Washing Hands\"",
                        R.drawable.jvn));
        friendFeedList.add(
                new FriendFeedFeed(8, getProfileName(), "Made progress on good habit of \"Walking in Nature\"",
                        R.drawable.profilepikture));
        friendFeedList.add(
                new FriendFeedFeed(9, getProfileName(), "Made progress on good habit of \"Eating Apples\"",
                        R.drawable.profilepikture));
        friendFeedList.add(
                new FriendFeedFeed(10, getProfileName(), "Made progress on good habit of \"Attending Lecture\"",
                        R.drawable.profilepikture));

        Collections.shuffle(friendFeedList, new Random(626));
        return friendFeedList;
    }
}