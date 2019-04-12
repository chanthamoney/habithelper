package com.example.habithelper;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

public class ActivitySideMenu extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
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

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();
        Intent i;

        if (id == R.id.nav_profile) {
            if (!this.getLocalClassName().equalsIgnoreCase(Profile_Page.class.getSimpleName())) {
                i = new Intent(this,Profile_Page.class);
                startActivity(i);
            }

        } else if (id == R.id.nav_habits) {
            if (!this.getLocalClassName().equalsIgnoreCase(home.class.getSimpleName())) {
                i = new Intent(this,home.class);
                startActivity(i);
            }

        } else if (id == R.id.nav_search) {
            if (!this.getLocalClassName().equalsIgnoreCase(friends_feed.class.getSimpleName())) {
                i = new Intent(this,friends_feed.class);
                startActivity(i);
            }

        } else if (id == R.id.nav_settings) {
            if (!this.getLocalClassName().equalsIgnoreCase(home.class.getSimpleName())) {
                i = new Intent(this,home.class);
                startActivity(i);
            }

        } else if (id == R.id.nav_home) {
            if (!this.getLocalClassName().equalsIgnoreCase(home.class.getSimpleName())) {
                i = new Intent(this,home.class);
                startActivity(i);
            }

        }  else if (id == R.id.nav_trophies) {
            if (!this.getLocalClassName().equalsIgnoreCase(Trophies.class.getSimpleName())) {
                i = new Intent(this,Trophies.class);
                startActivity(i);
            }

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
