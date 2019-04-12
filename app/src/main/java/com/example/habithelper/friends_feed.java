package com.example.habithelper;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

public class friends_feed extends ActivitySideMenu
        implements NavigationView.OnNavigationItemSelectedListener {

    //A list to store all the friend feed posts
    List<FriendFeed> friendFeedList;

    //The RecyclerView
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setContentView(R.layout.activity_friends_feed);
        super.onCreate(savedInstanceState);

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.getMenu().getItem(3).setChecked(true);

        //Get recyclerView from xml
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        //Initialize the friendFeedList
        friendFeedList = new ArrayList<>();

        profileFeedList.add(
                new ProfileFeed(1, "Ariana ate InNOut before her sound check.",
                        R.drawable.arigrande));

        profileFeedList.add(
                new ProfileFeed(1, "jvn didn't put on sunscreen.",
                        R.drawable.jvn));

        profileFeedList.add(
                new ProfileFeed(1, "Ariana forget to feed PiggySmalls.",
                        R.drawable.arigrande));

        profileFeedList.add(
                new ProfileFeed(1, "Ariana didn't go to bed before 10 pm.",
                        R.drawable.arigrande));


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
