package com.example.habithelper;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

public class Friend_Page extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    //a list to store all the Friend Profile Feed Posts
    List<FriendPageFeed> FriendPageFeedList;

    //the recyclerview
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_friend_page);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

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
                new FriendPageFeed(1, "Ari streamed her album",
                        R.drawable.arigrande));

        FriendPageFeedList.add(
                new FriendPageFeed(1, "Ari sprayed tan",
                        R.drawable.arigrande));
        FriendPageFeedList.add(
                new FriendPageFeed(1, "Ari wrote lyrics",
                        R.drawable.arigrande));
        FriendPageFeedList.add(
                new FriendPageFeed(1, "Ari went on a walk",
                        R.drawable.arigrande));

        //creating recyclerview adapter
        FriendPageFeedAdapter adapter = new FriendPageFeedAdapter(this, FriendPageFeedList);

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

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();
        Intent i;

        if (id == R.id.nav_profile) {

        } else if (id == R.id.nav_habits) {
            i = new Intent(this, home.class);
            this.startActivity(i);

        } else if (id == R.id.nav_search) {
            i = new Intent(this,home.class);
            this.startActivity(i);

        } else if (id == R.id.nav_settings) {
            i = new Intent(this,home.class);
            this.startActivity(i);

        } else if (id == R.id.nav_home) {
            i = new Intent(this,home.class);
            this.startActivity(i);

        }  else if (id == R.id.nav_trophies) {
            i = new Intent(this, Trophies.class);
            this.startActivity(i);

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    public void toggleFriend(android.view.View view) {
        Button btn = (Button) findViewById(R.id.addfriendbtn);

        if (btn.getText() == "Unfriend") {
            btn.setText("Add Friend");
        } else {
            btn.setText("Unfriend");
        }
    }
}
