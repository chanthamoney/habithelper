package com.example.habithelper;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class ActivitySideMenu extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    Globals sharedData = Globals.getInstance();

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

        updateGlobals();
    }

    public void updateGlobals() {
        if (sharedData.getProfileName() != null) {
            ArrayList<View> profileNames = getViewsByTag((ViewGroup) ((ViewGroup) this
                    .findViewById(android.R.id.content)).getChildAt(0), "profileName");
            for(View f : profileNames) {
                ((TextView) f).setText(sharedData.getProfileName());
            }
        }

        if (sharedData.getUsername() != null) {
            ArrayList<View> usernames = getViewsByTag((ViewGroup) ((ViewGroup) this
                    .findViewById(android.R.id.content)).getChildAt(0), "username");
            for(View f : usernames) {
                ((TextView) f).setText(sharedData.getUsername());
            }
        }

        if (sharedData.getEmail() != null) {
            ArrayList<View> emails = getViewsByTag((ViewGroup) ((ViewGroup) this
                    .findViewById(android.R.id.content)).getChildAt(0), "email");
            for(View f : emails) {
                ((TextView) f).setText(sharedData.getEmail());
            }
        }

        if (sharedData.getBio() != null) {
            ArrayList<View> bios = getViewsByTag((ViewGroup) ((ViewGroup) this
                    .findViewById(android.R.id.content)).getChildAt(0), "bio");
            for(View f : bios) {
                ((TextView) f).setText(sharedData.getBio());
            }
        }

        if (sharedData.getProfileName() != null) {
            ArrayList<View> welcomeProfileNames = getViewsByTag((ViewGroup) ((ViewGroup) this
                    .findViewById(android.R.id.content)).getChildAt(0), "welcomeProfileName");
            for(View f : welcomeProfileNames) {
                if (sharedData.getProfileName().indexOf(' ') > 0) {
                    ((TextView) f).setText("Welcome Back, " + sharedData.getProfileName().substring(0, sharedData.getProfileName().indexOf(' ')) + "!");

                } else {
                    ((TextView) f).setText("Welcome Back, " + sharedData.getProfileName() + "!");
                }
            }

        }

        if(sharedData.getProfilePicture() != null) {
            ArrayList<View> profilePiks = getViewsByTag((ViewGroup) ((ViewGroup) this
                    .findViewById(android.R.id.content)).getChildAt(0), "profilePik");
            for(View f : profilePiks) {
                ((ImageView) f).setImageBitmap(sharedData.getProfilePicture());
            }
        }
    }

    public static ArrayList<View> getViewsByTag(ViewGroup root, String tag){
        ArrayList<View> views = new ArrayList<View>();
        final int childCount = root.getChildCount();
        for (int i = 0; i < childCount; i++) {
            final View child = root.getChildAt(i);
            if (child instanceof ViewGroup) {
                views.addAll(getViewsByTag((ViewGroup) child, tag));
            }

            final Object tagObj = child.getTag();
            if (tagObj != null && tagObj.equals(tag)) {
                views.add(child);
            }

        }
        return views;
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
    public boolean onPrepareOptionsMenu(Menu menu) {
        updateGlobals();
        return super.onPrepareOptionsMenu(menu);
    }

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
            if (!this.getLocalClassName().equalsIgnoreCase(Friend_Feed_Page.class.getSimpleName())) {
                i = new Intent(this,Friend_Feed_Page.class);
                startActivity(i);
            }

        } else if (id == R.id.nav_settings) {
            if (!this.getLocalClassName().equalsIgnoreCase(SettingsActivity.class.getSimpleName())) {
                i = new Intent(this, SettingsActivity.class);
                startActivity(i);
            }

        } else if (id == R.id.nav_home) {
            if (!this.getLocalClassName().equalsIgnoreCase(home.class.getSimpleName())) {
                i = new Intent(this,home.class);
                startActivity(i);
            }

        }  else if (id == R.id.nav_achievements) {
            if (!this.getLocalClassName().equalsIgnoreCase(Achievements.class.getSimpleName())) {
                i = new Intent(this,Achievements.class);
                startActivity(i);
            }

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    public void clickProfile(android.view.View view) {
        if (!this.getLocalClassName().equalsIgnoreCase(Profile_Page.class.getSimpleName())) {
            Intent i;
            i = new Intent(this,Profile_Page.class);
            startActivity(i);
        }
    }
}
