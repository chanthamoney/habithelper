package com.example.habithelper;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;

import java.util.ArrayList;

import link.fls.swipestack.SwipeStack;

public class home extends ActivitySideMenu
        implements NavigationView.OnNavigationItemSelectedListener {
    private SwipeStack mSwipeStack;
    private SwipeStackAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setContentView(R.layout.activity_home);
        super.onCreate(savedInstanceState);

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.getMenu().getItem(0).setChecked(true);

        ArrayList<String> mData = new ArrayList<>();

        for (int x = 0; x < 5; x++) {
            mData.add("NOTIF." + " " + (x + 1) + "\nThis is an example notification.");
        }

        SwipeStack swipeStack = (SwipeStack) findViewById(R.id.swipeStack);
        swipeStack.setAdapter(new SwipeStackAdapter(getApplicationContext(), mData));

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
//        AlertDialog.Builder builder = new AlertDialog.Builder(home.this);
//        builder.setTitle("Transaction History");
//        builder.setMessage();
//        builder.create().show();

        AlertDialog.Builder builder = new AlertDialog.Builder(home.this);
        builder.setTitle("Transaction History");
        builder.setIcon(R.drawable.jar);
        builder.setMessage(R.string.jar_history);
        builder.setPositiveButton("Exit",
                new DialogInterface.OnClickListener()
                {
                    public void onClick(DialogInterface dialog, int id)
                    {
                        dialog.cancel();
                    }
                });

        builder.setNegativeButton("Cash Out",
                new DialogInterface.OnClickListener()
                {
                    public void onClick(DialogInterface dialog, int id)
                    {
                        dialog.cancel();
                        AlertDialog.Builder builder = new AlertDialog.Builder(home.this);
                        builder.setTitle("Are you sure?");
                        builder.setIcon(R.drawable.jar);
                        builder.setMessage("Cashing out your jar will remove your entire transaction history and move any funds back to your mobile payment system.");
                        builder.setPositiveButton("Cancel",
                                new DialogInterface.OnClickListener()
                                {
                                    public void onClick(DialogInterface dialog, int id)
                                    {
                                        dialog.cancel();
                                    }
                                });

                        builder.setNegativeButton("Yes, cash out.",
                                new DialogInterface.OnClickListener()
                                {
                                    public void onClick(DialogInterface dialog, int id)
                                    {
                                        dialog.cancel();
                                    }
                                });
                        builder.create().show();
                    }
                });
        builder.create().show();
    }
}
