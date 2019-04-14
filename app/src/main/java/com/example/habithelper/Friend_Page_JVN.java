package com.example.habithelper;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

public class Friend_Page_JVN extends ActivitySideMenu
        implements NavigationView.OnNavigationItemSelectedListener {
    //a list to store all the Friend Profile Feed Posts
    List<FriendPageFeed> FriendPageFeedList;

    //the recyclerview
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setContentView(R.layout.activity_friend_page_jvn);
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
                new FriendPageFeed(1, "Johnathan Van Ness","Made progress on good habit of \"Listening to Beyoncé\"",
                        R.drawable.jvn));
        FriendPageFeedList.add(
                new FriendPageFeed(1, "Johnathan Van Ness","Was penalized for habit of \"Saying Queen\"",
                        R.drawable.jvn));
        FriendPageFeedList.add(
                new FriendPageFeed(1, "Johnathan Van Ness","Made progress on good habit of \"Wearing Sunscreen\"",
                        R.drawable.jvn));
        FriendPageFeedList.add(
                new FriendPageFeed(1, "Johnathan Van Ness","Made progress on good habit of \"Walking in Nature\"",
                        R.drawable.jvn));

        //creating recyclerview adapter
        FriendPageFeedAdapter adapter = new FriendPageFeedAdapter(this, FriendPageFeedList);

        //setting adapter to recyclerview
        recyclerView.setAdapter(adapter);
    }

    public void toggleFriend(android.view.View view) {
        Button btn = (Button) findViewById(R.id.addfriendbtn4);

        if ("Add Friend".equals(btn.getText())) {
            btn.setText("Unfriend");
        } else {
            btn.setText("Add Friend");
        }
    }

    public void clickFriendBtn(android.view.View view) {
        Intent i;
        i = new Intent(this, Friend_Friend_Page.class);
        startActivity(i);
    }

    public void openFriendProfile(android.view.View view) {

    }
}
