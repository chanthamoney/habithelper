package com.example.habithelper;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class Friend_Friend_Page extends ActivitySideMenu
        implements NavigationView.OnNavigationItemSelectedListener {
    //a list to store all the Friend Feed Posts
    List<FriendFeedFeed> friendFeedList;

    //the recyclerview
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        boolean is_ariana = getIntent().hasExtra("ARIANA");

        setContentView(R.layout.activity_friends_friends);
        super.onCreate(savedInstanceState);

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.getMenu().getItem(3).setChecked(true);

        //getting the recyclerview from xml
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        if(is_ariana) {
            //initializing the productlist
            friendFeedList = new ArrayList<>();
            //adding some items to our list
            friendFeedList.add(
                    new FriendFeedFeed(1, "Jonathan Van Ness","@JVN",
                            R.drawable.jvn));

            friendFeedList.add(
                    new FriendFeedFeed(2, sharedData.getProfileName(),sharedData.getUsername(),
                            R.drawable.profilepikture));

        } else {
            //initializing the productlist
            friendFeedList = new ArrayList<>();
            //adding some items to our list
            friendFeedList.add(
                    new FriendFeedFeed(1, "Ariana Grande","@AriGrande",
                            R.drawable.arigrande));

            friendFeedList.add(
                    new FriendFeedFeed(2, sharedData.getProfileName(),sharedData.getUsername(),
                            R.drawable.profilepikture));
        }

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
        AlertDialog.Builder builder = new AlertDialog.Builder(Friend_Friend_Page.this);
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
