package com.example.habithelper;

import android.graphics.Bitmap;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Globals {


    private static Globals instance = new Globals();
    private Bitmap profilePicture;
    private String profileName;
    private String username;
    private String email;
    private String bio;
    private boolean jvn_Friend;
    private boolean ari_Friend;
    List<Habit> habitList = new ArrayList<>();

    private Globals() {
        jvn_Friend = true;
        ari_Friend = true;
        habitList.add(
                new Habit(0, "Kassi Soukaroune", "Brushing Teeth 3x", "Every morning", "7x", "$3", R.drawable.no_lock, R.drawable.baseline_edit_black_18dp, false));
        habitList.add(
                new Habit(1, "Kassi Soukaroune","Sleeping In", "Every morning", "7x", "$3", R.drawable.no_lock, R.drawable.baseline_edit_black_18dp, true));
        habitList.add(
                new Habit(2, "Kassi Soukaroune","Attending Lecture", "For every course", "7x", "$5", R.drawable.baseline_lock_black_18dp, R.drawable.baseline_edit_black_18dp, false));
        habitList.add(
                new Habit(3, "Kassi Soukaroune","Recycling Food Container", "For every snack ;)", "3x", "$2", R.drawable.no_lock, R.drawable.baseline_edit_black_18dp, false));
    }

    public void deleteHabit(int i) {
        habitList.remove(habitList.get(i));

        int j = 0;
        for (Habit h : habitList) {
            h.setId(j);
            j++;
        }
    }

    public List<Habit> getHabitList() {
        for (Habit h : habitList) {
            h.setOwner(getProfileName());
        }
        return habitList;
    }

    public int getNumHabits() {
        return habitList.size();
    }

    public void addToHabitList(Habit habit) {
        this.habitList.add(habit);
    }

    // Getter-Setters
    public static Globals getInstance() {
        return instance;
    }

    public static void setInstance(Globals instance) {
        Globals.instance = instance;
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
        return email != null ? email : "user123@habithelper.com";
    }

    public void setEmail(String e) {
        this.email = e;
    }

    public void setJvnFriend(Boolean b) {
        this.jvn_Friend = b;
    }
    public boolean getJvnFriend() {
        return this.jvn_Friend;
    }
    public void setAriFriend(Boolean b) {
        this.ari_Friend = b;
    }
    public boolean getAriFriend() {
        return this.ari_Friend;
    }

    public void clear() {
        instance = new Globals();
    }

    public List<FriendFeedFeed> getFriendFeedList() {
        //initializing the productlist
        List<FriendFeedFeed> friendFeedList = new ArrayList<>();
        //adding some items to our list
        //adding some items to our list
        if (ari_Friend) {
            friendFeedList.add(
                    new FriendFeedFeed(1, "Ariana Grande", "Was penalized for habit of \"Using too much spray tan\"",
                            R.drawable.arigrande));
            friendFeedList.add(
                    new FriendFeedFeed(2, "Ariana Grande", "Made progress on good habit of \"Writing Lyrics\"",
                            R.drawable.arigrande));
            friendFeedList.add(
                    new FriendFeedFeed(3, "Ariana Grande", "Made progress on good habit of \"Walking in Nature\"",
                            R.drawable.arigrande));
        }

        if(jvn_Friend) {
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
        }

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