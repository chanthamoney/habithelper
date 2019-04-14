package com.example.habithelper;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Friend_Feed_Page extends ActivitySideMenu
        implements NavigationView.OnNavigationItemSelectedListener {
    //a list to store all the Friend Feed Posts
    List<FriendFeedFeed> friendFeedList;
    List<FriendFeedFeed> friendList;

    //the recyclerview
    RecyclerView recyclerView;

    TabLayout tabLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        boolean friend_list = getIntent().hasExtra("FRIEND_LIST");

        setContentView(R.layout.activity_friends_feed);
        super.onCreate(savedInstanceState);

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.getMenu().getItem(3).setChecked(true);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabLayout);
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                if ("List".equals(tab.getText())) {
                    //initializing the productlist
                    friendList = new ArrayList<>();
                    //adding some items to our list
                    friendList.add(
                            new FriendFeedFeed(1, "Ariana Grande", "@arigrande",
                                    R.drawable.arigrande));
                    friendList.add(
                            new FriendFeedFeed(2, "Jonathan Van Ness", "@jvn",
                                    R.drawable.jvn));

                    //creating recyclerview adapter
                    FriendFeedAdapter adapter = new FriendFeedAdapter(getBaseContext(), friendList);

                    //setting adapter to recyclerview
                    recyclerView.setAdapter(adapter);
                } else {
                    //getting the recyclerview from xml
                    recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
                    recyclerView.setHasFixedSize(true);
                    recyclerView.setLayoutManager(new LinearLayoutManager(getBaseContext()));

                    friendFeedList = sharedData.getFriendFeedList();

                    //creating recyclerview adapter
                    FriendFeedAdapter adapter = new FriendFeedAdapter(getBaseContext(), friendFeedList);

                    //setting adapter to recyclerview
                    recyclerView.setAdapter(adapter);
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        //getting the recyclerview from xml
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        friendFeedList = sharedData.getFriendFeedList();

        //creating recyclerview adapter
        FriendFeedAdapter adapter = new FriendFeedAdapter(this, friendFeedList);

        //setting adapter to recyclerview
        recyclerView.setAdapter(adapter);

        if (friend_list) {
            TabLayout.Tab tab = tabLayout.getTabAt(1);
            tab.select();
        }
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

    public void openFriendProfile(android.view.View view) {
        if (view.getTag().equals("Ariana Grande")) {
            Intent i = new Intent(this, Friend_Page_Ariana.class);
            startActivity(i);
        } else if (view.getTag().equals("Jonathan Van Ness")) {
            Intent i = new Intent(this, Friend_Page_JVN.class);
            startActivity(i);
        } else {
            Intent i = new Intent(this, Profile_Page.class);
            startActivity(i);
        }
    }

    public void onClickSearch(android.view.View view) {
        AlertDialog.Builder builder = new AlertDialog.Builder(Friend_Feed_Page.this);
        builder.setTitle("Oh no!");
        builder.setMessage("This feature would allow you to search your feed or friends.");
        builder.setPositiveButton("OK",
                new DialogInterface.OnClickListener()
                {
                    public void onClick(DialogInterface dialog, int id)
                    {
                        dialog.cancel();
                    }
                });
        builder.show();
    }
}
