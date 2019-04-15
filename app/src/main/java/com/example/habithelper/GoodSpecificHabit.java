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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_good_specific_habit);
        TextView name = findViewById(R.id.activity);
        name.setText(getIntent().getExtras().getString("NAME"));
    }


    public void goodDialog(android.view.View view) {
        AlertDialog.Builder builder = new AlertDialog.Builder(GoodSpecificHabit.this);
        builder.setTitle("Are you sure?");
        builder.setItems(new CharSequence[]
                        {"Congratulations! You have met the quota for this habit frequency to unlock $1 from your jar.", "Cancel", "Ok."},
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        // The 'which' argument contains the index position
                        // of the selected item
                        switch (which) {
                            case 1:
                                Toast.makeText(GoodSpecificHabit.this, "Cancelled.", Toast.LENGTH_SHORT).show();
                                break;
                            case 2:
                                Toast.makeText(GoodSpecificHabit.this, "Bad Habit Recorded!", Toast.LENGTH_SHORT).show();
                                break;
                        }
                    }
                });
        builder.show();
    }

    public void deleteHabit(android.view.View view) {
        AlertDialog.Builder builder = new AlertDialog.Builder(GoodSpecificHabit.this);
        builder.setTitle("Are you sure?");
        builder.setIcon(R.drawable.jar);
        builder.setMessage("This will permanently delete this habit. However, records of this habit may remain (e.g. transaction history, user feed).");
        builder.setPositiveButton("Cancel",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                    }
                });

        builder.setNegativeButton("Yes, delete.",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        sharedData.deleteHabit(Integer.parseInt(getIntent().getExtras().getString("ID")));
                        Intent i = new Intent(getApplicationContext(), Habits_Page.class);
                        i.putExtra("PERSON", sharedData.getProfileName());
                        startActivity(i);
                    }
                });
        builder.show();
    }
}
