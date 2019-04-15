package com.example.habithelper;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

public class Friend_Page_Ariana extends ActivitySideMenu
        implements NavigationView.OnNavigationItemSelectedListener {
    //a list to store all the Friend Profile Feed Posts
    List<FriendPageFeed> FriendPageFeedList;

    //the recyclerview
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setContentView(R.layout.activity_friend_page_ariana);
        super.onCreate(savedInstanceState);

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        //getting the recyclerview from xml
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        //initializing the productlist
        FriendPageFeedList = new ArrayList<>();
        //adding some items to our list
        FriendPageFeedList.add(
                new FriendPageFeed(1, "Ariana Grande", "Made progress on good habit of \"Streaming Album\"",
                        R.drawable.arigrande));
        FriendPageFeedList.add(
                new FriendPageFeed(2, "Ariana Grande", "Was penalized for habit of \"Using too much spray tan\"",
                        R.drawable.arigrande));
        FriendPageFeedList.add(
                new FriendPageFeed(3, "Ariana Grande", "Made progress on good habit of \"Writing Lyrics\"",
                        R.drawable.arigrande));
        FriendPageFeedList.add(
                new FriendPageFeed(4, "Ariana Grande", "Made progress on good habit of \"Walking in Nature\"",
                        R.drawable.arigrande));

        //creating recyclerview adapter
        FriendPageFeedAdapter adapter = new FriendPageFeedAdapter(this, FriendPageFeedList);

        //setting adapter to recyclerview
        recyclerView.setAdapter(adapter);

        if (!sharedData.getAriFriend()) {
            Button btn = (Button) findViewById(R.id.addfriendbtn);
            btn.setText("Add Friend");
            findViewById(R.id.habitsbutton).setVisibility(View.INVISIBLE);
            findViewById(R.id.friendsbutton).setVisibility(View.INVISIBLE);
            findViewById(R.id.recyclerView).setVisibility(View.INVISIBLE);
        }
    }

    public void toggleFriend(android.view.View view) {
        Button btn = (Button) findViewById(R.id.addfriendbtn);

        if ("Add Friend".equals(btn.getText())) {
            btn.setText("Unfriend");
            findViewById(R.id.habitsbutton).setVisibility(View.VISIBLE);
            findViewById(R.id.recyclerView).setVisibility(View.VISIBLE);
            findViewById(R.id.friendsbutton).setVisibility(View.VISIBLE);
            sharedData.setAriFriend(true);
        } else {
            btn.setText("Add Friend");
            findViewById(R.id.habitsbutton).setVisibility(View.INVISIBLE);
            findViewById(R.id.friendsbutton).setVisibility(View.INVISIBLE);
            findViewById(R.id.recyclerView).setVisibility(View.INVISIBLE);
            sharedData.setAriFriend(false);
        }
    }

    public void clickFriendBtn(android.view.View view) {
        Intent i;
        i = new Intent(this, Friend_Friend_Page.class);
        i.putExtra("ARIANA", true);
        startActivity(i);
    }

    public void openFriendProfile(android.view.View view) {

    }

    public void habitsButton(android.view.View view) {
        Intent i;
        i = new Intent(this, Habits_Page.class);
        i.putExtra("PERSON", "Ariana Grande");
        startActivity(i);
    }
}
