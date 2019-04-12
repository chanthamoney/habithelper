package com.example.habithelper;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;
import java.util.List;

public class Friend_Feed_Page extends ActivitySideMenu
        implements NavigationView.OnNavigationItemSelectedListener {
    //a list to store all the Friend Feed Posts
    List<FriendFeedFeed> friendFeedList;

    //the recyclerview
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setContentView(R.layout.activity_friends_feed);
        super.onCreate(savedInstanceState);

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.getMenu().getItem(3).setChecked(true);

        //getting the recyclerview from xml
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        //initializing the productlist
        friendFeedList = new ArrayList<>();
        //adding some items to our list
        friendFeedList.add(
                new FriendFeedFeed(1, "Ariana ate InNOut before her sound check.",
                        R.drawable.arigrande));

        friendFeedList.add(
                new FriendFeedFeed(1, "jvn didn't put on sunscreen.",
                        R.drawable.jvn));

        friendFeedList.add(
                new FriendFeedFeed(1, "Ariana forget to feed PiggySmalls.",
                        R.drawable.arigrande));

        friendFeedList.add(
                new FriendFeedFeed(1, "Ariana didn't go to bed before 10 pm.",
                        R.drawable.arigrande));


        //creating recyclerview adapter
        FriendFeedAdapter adapter = new FriendFeedAdapter(this, friendFeedList);

        //setting adapter to recyclerview
        recyclerView.setAdapter(adapter);

    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

}
