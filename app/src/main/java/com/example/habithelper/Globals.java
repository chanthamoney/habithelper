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

    private Bitmap profilePicture;


    private Globals() {

    }


    public Bitmap getProfilePicture() {
        return profilePicture;
    }


    public void setProfilePicture(Bitmap pp) {
        this.profilePicture = pp;
    }

}