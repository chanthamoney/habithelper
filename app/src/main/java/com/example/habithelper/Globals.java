package com.example.habithelper;

import android.graphics.Bitmap;

public class Globals {


    private static Globals instance = new Globals();

    // Getter-Setters
    public static Globals getInstance() {
        return instance;
    }

    public static void setInstance(Globals instance) {
        Globals.instance = instance;
    }

    private static Bitmap profilePicture;
    private static String profileName;
    private static String username;
    private static String email = "user1523@swearjarapp.com";
    private static String bio;

    private Globals() {

    }

    public Bitmap getProfilePicture() {
        return profilePicture;
    }


    public void setProfilePicture(Bitmap pp) {
        this.profilePicture = pp;
    }

    public String getProfileName() {
        return profileName;
    }

    public void setProfileName(String pn) {
        this.profileName = pn;
    }


    public String getUsername() {
        return username;
    }

    public void setUsername(String un) {
        this.username = "@" + un;
    }


    public String getBio() {
        return bio;
    }

    public void setBio(String b) {
        this.bio = b;
    }


    public String getEmail() {
        return email;
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
}