package com.example.habithelper;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Switch;
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

    AlertDialog myalert;

    int currentlyEditing;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        person = getIntent().getExtras().getString("PERSON");

        setContentView(R.layout.activity_habits__page);
        if(!person.equals(sharedData.getProfileName())) {
            setTitle(person + "'s Habits Page");
        } else {
            NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
            navigationView.getMenu().getItem(2).setChecked(true);
        }
        super.onCreate(savedInstanceState);

        //getting the recyclerview from xml
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        //initializing the productlist
        habitList = new ArrayList<>();
        //adding some items to our list
        if (person.equals("Ariana Grande")) {
            habitList.add(
                    new Habit(1, "Ariana Grande","Streaming Album", "Every night before bed", "7x", "$1", R.drawable.no_lock, R.drawable.baseline_thumb_up_black_18dp, false));
            habitList.add(
                    new Habit(2, "Ariana Grande","Using too much spray tan", "Whenever in public", "1x", "$9", R.drawable.no_lock, R.drawable.baseline_thumb_down_black_18dp, true));
            habitList.add(
                    new Habit(3, "Ariana Grande","Writing Lyrics", "Once per week", "1x", "$5", R.drawable.no_lock, R.drawable.baseline_thumb_up_black_18dp, false));
            habitList.add(
                    new Habit(4, "Ariana Grande","Walking in Nature", "per night with piggy smalls", "5x", "$9", R.drawable.no_lock, R.drawable.baseline_thumb_up_black_18dp, false));

            findViewById(R.id.fab).setVisibility(View.INVISIBLE);

        } else if (person.equals("Jonathan Van Ness")) {
            habitList.add(
                    new Habit(1, "Jonathan Van Ness","Listening to Beyoncé", "Every time before eating", "7x", "$2", R.drawable.no_lock, R.drawable.baseline_thumb_up_black_18dp, false));
            habitList.add(
                    new Habit(2, "Jonathan Van Ness","Saying Queen", "To anyone else", "4x", "$2", R.drawable.no_lock, R.drawable.baseline_thumb_down_black_18dp, true));
            habitList.add(
                    new Habit(3, "Jonathan Van Ness","Wearing Sunscreen", "per day 30 min before going outside", "5x", "$1", R.drawable.no_lock, R.drawable.baseline_thumb_up_black_18dp, false));
            habitList.add(
                    new Habit(4, "Jonathan Van Ness","Walking in Nature", "Every night with bobby berk", "5x", "$8", R.drawable.no_lock, R.drawable.baseline_thumb_up_black_18dp, false));

            findViewById(R.id.fab).setVisibility(View.INVISIBLE);
        } else {
            habitList = sharedData.getHabitList();
        }

        //creating recyclerview adapter
        HabitPageHabitAdapter adapter = new HabitPageHabitAdapter(this, habitList);

        //setting adapter to recyclerview
        recyclerView.setAdapter(adapter);

        FloatingActionButton myFab = (FloatingActionButton) findViewById(R.id.fab);
        myFab.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                myalert = new AlertDialog.Builder(Habits_Page.this).setView(R.layout.layout_popup_habit).create();
                currentlyEditing = -1;
                myalert.show();
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
        myalert = new AlertDialog.Builder(Habits_Page.this).setView(R.layout.layout_popup_habit).show();
        ((Switch) myalert.findViewById(R.id.myprivate)).setChecked(view.getTag(R.id.secret4).equals("TRUE"));
        ((Switch) myalert.findViewById(R.id.mybreak)).setChecked(view.getTag(R.id.secret5).equals("TRUE"));
        ((EditText) myalert.findViewById(R.id.mynameinput)).setText(view.getTag(R.id.secret6).toString());
        ((EditText) myalert.findViewById(R.id.mynotesinput)).setText(view.getTag(R.id.secret7).toString());
        ((EditText) myalert.findViewById(R.id.myfrequencyinput)).setText(view.getTag(R.id.secret8).toString().substring(0, view.getTag(R.id.secret8).toString().length() - 1));
        ((EditText) myalert.findViewById(R.id.mycostinput)).setText(view.getTag(R.id.secret9).toString().substring(1));

        currentlyEditing = Integer.parseInt(view.getTag(R.id.secret2).toString());
    }

    private void reportHabit(android.view.View view) {
        ImageView v = (ImageView) view;
        AlertDialog.Builder builder = new AlertDialog.Builder(Habits_Page.this);
        builder.setTitle("Report Habit");
        builder.setIcon(R.drawable.jar);
        builder.setMessage("Are you sure you want to report that " + person + " did their habit of \"" + view.getTag(R.id.secret3) + "\"?");
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
        if(view.getId() == R.id.see_pic) {
            String goodorbad = view.getTag(R.id.habit_description).toString();
            if (goodorbad.equals("Bad")) {
                i = new Intent(this, BadSpecificHabit.class);
                i.putExtra("NAME", view.getTag(R.id.habit_name).toString());
                i.putExtra("ID", view.getTag(R.id.mybreak).toString());
                startActivity(i);
            } else {
                i = new Intent(this, GoodSpecificHabit.class);
                i.putExtra("NAME",  view.getTag(R.id.habit_name).toString());
                i.putExtra("ID", view.getTag(R.id.mybreak).toString());
                startActivity(i);
            }
        } else {
            if (person.equals(sharedData.getProfileName())) {
                TextView name = view.findViewById(R.id.habit_name);
                if (name.getTag().equals("Bad")) {
                    i = new Intent(this, BadSpecificHabit.class);
                    i.putExtra("NAME", ((TextView) view.findViewById(R.id.habit_name)).getText());
                    i.putExtra("ID", ((TextView) view.findViewById(R.id.habit_description)).getTag().toString());
                    startActivity(i);
                } else {
                    i = new Intent(this, GoodSpecificHabit.class);
                    i.putExtra("NAME", ((TextView) view.findViewById(R.id.habit_name)).getText());
                    i.putExtra("ID", ((TextView) view.findViewById(R.id.habit_description)).getTag().toString());
                    startActivity(i);
                }
            }
        }
    }

    public void onMyCancel(View view) {
        myalert.cancel();
    }

    public void onMySubmit(View view) {
        if (currentlyEditing >= 0) {
            Habit habit = sharedData.getHabitList().get(currentlyEditing);
            String name = ((EditText) view.getRootView().findViewById(R.id.mynameinput)).getText().toString();
            String notes = ((EditText) view.getRootView().findViewById(R.id.mynotesinput)).getText().toString();
            String frequency = ((EditText) view.getRootView().findViewById(R.id.myfrequencyinput)).getText().toString();
            String cost = ((EditText) view.getRootView().findViewById(R.id.mycostinput)).getText().toString();
            Boolean isbad = ((Switch) view.getRootView().findViewById(R.id.mybreak)).isChecked();
            Boolean isprivate = ((Switch) view.getRootView().findViewById(R.id.myprivate)).isChecked();
            if (name != null && !name.equals("")) {
                habit.setName(name);
            }
            if (notes != null && !notes.equals("")) {
                habit.setDescription(notes);
            }
            if (frequency != null && !frequency.equals("")) {
                habit.setFrequency(frequency + "x");
            }
            if (cost != null && !cost.equals("")) {
                habit.setCost("$" + cost);
            }
            habit.setIs_bad(isbad);
            if (isprivate) {
                habit.setLock_image(R.drawable.baseline_lock_black_18dp);
            } else {
                habit.setLock_image(R.drawable.no_lock);
            }
        } else {
            String name = ((EditText) view.getRootView().findViewById(R.id.mynameinput)).getText().toString();
            String notes = ((EditText) view.getRootView().findViewById(R.id.mynotesinput)).getText().toString();
            String frequency = ((EditText) view.getRootView().findViewById(R.id.myfrequencyinput)).getText().toString() + "x";
            String cost = "$" + ((EditText) view.getRootView().findViewById(R.id.mycostinput)).getText().toString();
            Boolean isbad = ((Switch) view.getRootView().findViewById(R.id.mybreak)).isChecked();
            Boolean isprivate = ((Switch) view.getRootView().findViewById(R.id.myprivate)).isChecked();
            int d;
            if (isprivate) {
                d = R.drawable.baseline_lock_black_18dp;
            } else {
                d = R.drawable.no_lock;
            }
            Habit habit = new Habit(sharedData.getNumHabits(),  sharedData.getProfileName(),  name, notes, frequency, cost, d, R.drawable.baseline_edit_black_18dp, isbad);
            sharedData.addToHabitList(habit);
        }
        habitList = sharedData.getHabitList();
        //creating recyclerview adapter
        HabitPageHabitAdapter adapter = new HabitPageHabitAdapter(this, habitList);

        //setting adapter to recyclerview
        recyclerView.setAdapter(adapter);
        myalert.cancel();
    }
}
