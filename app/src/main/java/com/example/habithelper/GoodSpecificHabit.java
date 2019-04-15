package com.example.habithelper;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;
import android.widget.Toast;

public class GoodSpecificHabit extends AppCompatActivity {

    Globals sharedData = Globals.getInstance();

    String habitName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_good_specific_habit);
        TextView name = findViewById(R.id.activity);
        habitName = getIntent().getExtras().getString("NAME");
        name.setText(habitName);
    }


    public void goodDialog(android.view.View view) {
        AlertDialog.Builder builder = new AlertDialog.Builder(GoodSpecificHabit.this);
        builder.setTitle("Are you sure?");
        builder.setIcon(R.drawable.jar);
        builder.setMessage("Congratulations! You have met the frequency quota for the good habit \""+ habitName + "\" to unlock $1 from your jar.");
        builder.setPositiveButton("Yes, continue.",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                        Toast.makeText(GoodSpecificHabit.this, "Progress Recorded!", Toast.LENGTH_SHORT).show();
                    }
                });

        builder.setNegativeButton("Cancel",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                        Toast.makeText(GoodSpecificHabit.this, "Cancelled.", Toast.LENGTH_SHORT).show();
                    }
                });
        builder.show();
    }

    public void deleteHabit(android.view.View view) {
        AlertDialog.Builder builder = new AlertDialog.Builder(GoodSpecificHabit.this);
        builder.setTitle("Are you sure?");
        builder.setIcon(R.drawable.jar);
        builder.setMessage("This will permanently delete the habit \"" + habitName + "\". However, records of this habit may remain (e.g. transaction history, user feed).");
        builder.setPositiveButton("Cancel",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                        Toast.makeText(GoodSpecificHabit.this, "Cancelled", Toast.LENGTH_SHORT).show();
                    }
                });

        builder.setNegativeButton("Yes, delete.",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        sharedData.deleteHabit(Integer.parseInt(getIntent().getExtras().getString("ID")));
                        Intent i = new Intent(getApplicationContext(), Habits_Page.class);
                        i.putExtra("PERSON", sharedData.getProfileName());
                        startActivity(i);
                        Toast.makeText(GoodSpecificHabit.this, "Deleted Habit \"" + habitName + "\"", Toast.LENGTH_SHORT).show();
                    }
                });
        builder.show();
    }
}
