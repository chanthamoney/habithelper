package com.example.habithelper;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class Habits_Page extends ActivitySideMenu
        implements NavigationView.OnNavigationItemSelectedListener {
    //a list to store all the Friend Feed Posts
    List<Habit> habitList;

    //the recyclerview
    RecyclerView recyclerView;

    String person;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        person = getIntent().getExtras().getString("PERSON");

        setContentView(R.layout.activity_habits__page);
        if(!person.equals(sharedData.getProfileName())) {
            setTitle(person + "'s Habits Page");
        }
        super.onCreate(savedInstanceState);

        if (person.equals(sharedData.getProfileName())) {
            NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
            navigationView.getMenu().getItem(2).setChecked(true);
        }

        //getting the recyclerview from xml
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        //initializing the productlist
        habitList = new ArrayList<>();
        //adding some items to our list
        if (person.equals("Ariana Grande")) {
            habitList.add(
                    new Habit(1, "Streaming Album", "Every night before bed", "7x", "$1", R.drawable.no_lock, R.drawable.baseline_thumb_up_black_18dp, false));
            habitList.add(
                    new Habit(2, "Using too much spray tan", "Whenever in public", "1x", "$9", R.drawable.no_lock, R.drawable.baseline_thumb_down_black_18dp, true));
            habitList.add(
                    new Habit(3, "Writing Lyrics", "Once per week", "1x", "$5", R.drawable.no_lock, R.drawable.baseline_thumb_up_black_18dp, false));
            habitList.add(
                    new Habit(4, "Walking in Nature", "per night with piggy smalls", "5x", "$9", R.drawable.no_lock, R.drawable.baseline_thumb_up_black_18dp, false));

            findViewById(R.id.fab).setVisibility(View.INVISIBLE);

        } else if (person.equals("Jonathan Van Ness")) {
            habitList.add(
                    new Habit(1, "Listening to Beyoncé", "Every time before eating", "7x", "$2", R.drawable.no_lock, R.drawable.baseline_thumb_up_black_18dp, false));
            habitList.add(
                    new Habit(2, "Saying Queen", "To anyone else", "4x", "$2", R.drawable.no_lock, R.drawable.baseline_thumb_down_black_18dp, true));
            habitList.add(
                    new Habit(3, "Wearing Sunscreen", "per day 30 min before going outside", "5x", "$1", R.drawable.no_lock, R.drawable.baseline_thumb_up_black_18dp, false));
            habitList.add(
                    new Habit(4, "Walking in Nature", "Every night with bobby berk", "5x", "$8", R.drawable.no_lock, R.drawable.baseline_thumb_up_black_18dp, false));

            findViewById(R.id.fab).setVisibility(View.INVISIBLE);
        } else {
            habitList.add(
                    new Habit(1, "Brushing Teeth 3x", "Every morning", "7x", "$3", R.drawable.no_lock, R.drawable.baseline_edit_black_18dp, false));
            habitList.add(
                    new Habit(2, "Sleeping In", "Every morning", "7x", "$3", R.drawable.no_lock, R.drawable.baseline_edit_black_18dp, true));
            habitList.add(
                    new Habit(3, "Attending Lecture", "For every course", "7x", "$5", R.drawable.baseline_lock_black_18dp, R.drawable.baseline_edit_black_18dp, false));
            habitList.add(
                    new Habit(4, "Recycling Food Container", "For every snack ;)", "3x", "$2", R.drawable.no_lock, R.drawable.baseline_edit_black_18dp, false));

        }

        //creating recyclerview adapter
        HabitPageHabitAdapter adapter = new HabitPageHabitAdapter(this, habitList);

        //setting adapter to recyclerview
        recyclerView.setAdapter(adapter);

        FloatingActionButton myFab = (FloatingActionButton) findViewById(R.id.fab);
        myFab.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(Habits_Page.this);
                builder.setTitle("NEW HABIT!");
                builder.setIcon(R.drawable.jar);
                builder.setMessage("This is how you would create a new habit.");
                builder.setPositiveButton("Ok",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                dialog.cancel();
                            }
                        });
                builder.show();
            }
        });
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

    public void onActionClick(android.view.View view) {
        if (person.equals("Ariana Grande") || person.equals("Jonathan Van Ness")) {
            reportHabit(view);
        } else {
            editHabit(view);
        }
    }

    private void editHabit(android.view.View view) {
        ImageView v = (ImageView) view;
        boolean is_bad = v.getDrawable().equals(R.drawable.baseline_thumb_down_black_18dp);

        AlertDialog.Builder builder = new AlertDialog.Builder(Habits_Page.this);
        builder.setTitle("Edit Habit");
        builder.setIcon(R.drawable.jar);
        builder.setMessage("This is how you would edit the habit.");
        builder.setPositiveButton("Ok",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                    }
                });
        builder.show();
    }

    private void reportHabit(android.view.View view) {
        ImageView v = (ImageView) view;
        AlertDialog.Builder builder = new AlertDialog.Builder(Habits_Page.this);
        builder.setTitle("Report Habit");
        builder.setIcon(R.drawable.jar);
        builder.setMessage("Are you sure you want to report that " + person + " did their habit of \"" + view.getTag() + "\"?");
        builder.setPositiveButton("Yes",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                    }
                });

        builder.setNegativeButton("Cancel",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                    }
                });
        builder.show();
    }

    public void onHabitClick(android.view.View view) {
        Intent i;
        TextView name = view.findViewById(R.id.habit_name);
        if (name.getTag().equals("Bad")) {
            i = new Intent(this, BadSpecificHabit.class);
            i.putExtra("NAME", ((TextView) view.findViewById(R.id.habit_name)).getText());
            startActivity(i);
        } else {
            i = new Intent(this, GoodSpecificHabit.class);
            i.putExtra("NAME", ((TextView) view.findViewById(R.id.habit_name)).getText());
            startActivity(i);
        }
    }
}
