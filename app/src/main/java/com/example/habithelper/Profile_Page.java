package com.example.habithelper;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.provider.MediaStore;
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
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

public class Profile_Page extends ActivitySideMenu
        implements NavigationView.OnNavigationItemSelectedListener {
    //a list to store all the Profile Feed Posts
    List<ProfileFeed> profileFeedList;

    //the recyclerview
    RecyclerView recyclerView;

    Globals sharedData = Globals.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setContentView(R.layout.activity_profile__page);
        super.onCreate(savedInstanceState);

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.getMenu().getItem(1).setChecked(true);

        //getting the recyclerview from xml
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        //initializing the productlist
        profileFeedList = new ArrayList<>();
        //adding some items to our list
        profileFeedList.add(
                new ProfileFeed(1, "Kassi washed her hands",
                        R.drawable.profilepikture));

        profileFeedList.add(
                new ProfileFeed(1, "Kassi ate an apple",
                        R.drawable.profilepikture));
        profileFeedList.add(
                new ProfileFeed(1, "Kassi watched her lecture video",
                        R.drawable.profilepikture));
        profileFeedList.add(
                new ProfileFeed(1, "Kassi recycled her box of snacks",
                        R.drawable.profilepikture));

        //creating recyclerview adapter
        ProfileFeedAdapter adapter = new ProfileFeedAdapter(this, profileFeedList);

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
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.profile__page, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        return super.onOptionsItemSelected(item);
    }

    public void open(){

    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data)
    {
        if (resultCode == Activity.RESULT_CANCELED) {
        }
        else {
            super.onActivityResult(requestCode,resultCode,data);
            Bitmap bm = (Bitmap)data.getExtras().get("data");
            Bitmap bitmap = Bitmap.createBitmap(bm, 0, (bm.getHeight()-bm.getWidth())/2, bm.getWidth(), bm.getWidth());

            sharedData.setProfilePicture(bitmap);
            if(bitmap != null) {
                ArrayList<View> profilePiks = getViewsByTag((ViewGroup) ((ViewGroup) this
                        .findViewById(android.R.id.content)).getChildAt(0), "profilePik");
                for(View f : profilePiks) {
                    ((ImageView) f).setImageBitmap(bitmap);
                }
            }
        }
    }

    public void changePicture(android.view.View view) {
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE); //IMAGE CAPTURE CODE
        startActivityForResult(intent, 0);
    }

    public void friendsButton(android.view.View view) {
            Intent i;
            i = new Intent(this,Friend_Feed_Page.class);
            i.putExtra("FRIEND_LIST", true);
            startActivity(i);
    }
}
