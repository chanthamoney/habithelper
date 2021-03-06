package com.example.habithelper;

import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.CardView;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.ArrayList;

import link.fls.swipestack.SwipeStack;

public class home extends ActivitySideMenu
        implements NavigationView.OnNavigationItemSelectedListener {
    private SwipeStack mSwipeStack;
    private SwipeStackAdapter mAdapter;
    private ArrayList<String> mData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setContentView(R.layout.activity_home);
        super.onCreate(savedInstanceState);

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.getMenu().getItem(0).setChecked(true);

        mData = new ArrayList<String>();
        mData.add("These are your notifications. Let's begin with some tips!\n TIP 1: Swipe Left to delete a notification and swipe right to save!");
        mData.add("TIP 2\nTry clicking on the jar above this notification to see your jar's transaction history.");

        for (int x = 1; x < 5; x++) {
            mData.add("NOTIFICATION" + " " + (x + 2) + "\nThis is an example notification.");
        }

        mSwipeStack = (SwipeStack) findViewById(R.id.swipeStack);
        mAdapter = new SwipeStackAdapter(getApplicationContext(), mData);
        mSwipeStack.setAdapter(mAdapter);

        mSwipeStack.setListener(new SwipeStack.SwipeStackListener() {
            @Override
            public void onViewSwipedToLeft(int position) {
                mAdapter.remove(position);
            }

            @Override
            public void onViewSwipedToRight(int position) {

            }

            @Override
            public void onStackEmpty() {
                mAdapter.reset();
                mSwipeStack.resetStack();
            }
        });

        updateGlobals();

        ImageView iv = (ImageView) findViewById(R.id.myjar);

        ObjectAnimator scaleDown = ObjectAnimator.ofPropertyValuesHolder(
                iv,
                PropertyValuesHolder.ofFloat("scaleX", 0.9f),
                PropertyValuesHolder.ofFloat("scaleY", 0.9f));
        scaleDown.setDuration(1500);

        scaleDown.setRepeatCount(ObjectAnimator.INFINITE);
        scaleDown.setRepeatMode(ObjectAnimator.REVERSE);

        scaleDown.start();
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

    public void clickJar(android.view.View view) {
        AlertDialog.Builder builder = new AlertDialog.Builder(home.this);
        builder.setTitle("Transaction History");
        builder.setIcon(R.drawable.jar);
        builder.setMessage(R.string.jar_history);
        builder.setPositiveButton("Exit",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                    }
                });

        builder.setNegativeButton("Cash Out",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                        AlertDialog.Builder builder = new AlertDialog.Builder(home.this);
                        builder.setTitle("Are you sure?");
                        builder.setIcon(R.drawable.jar);
                        builder.setMessage("Cashing out your jar will remove your entire transaction history and move any funds back to your mobile payment system.");
                        builder.setPositiveButton("Cancel",
                                new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int id) {
                                        dialog.cancel();
                                        Toast.makeText(home.this, "Cancelled", Toast.LENGTH_SHORT).show();
                                    }
                                });

                        builder.setNegativeButton("Yes, cash out.",
                                new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int id) {
                                        dialog.cancel();
                                        Toast.makeText(home.this, "Jar Cashed Out", Toast.LENGTH_SHORT).show();
                                    }
                                });
                        builder.show();
                    }
                });
        builder.show();
    }
}
