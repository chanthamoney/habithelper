package com.example.habithelper;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;
import android.widget.Toast;

public class BadSpecificHabit extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bad_specific_habit);
        TextView name = findViewById(R.id.activity);
        name.setText(getIntent().getExtras().getString("NAME"));
    }


    public void badDialog(android.view.View view) {
        AlertDialog.Builder builder = new AlertDialog.Builder(BadSpecificHabit.this);
        builder.setTitle("Are you sure?");
        builder.setItems(new CharSequence[]
                        {"You have met your quota for this bad habit and $1 will be locked in your jar.", "Cancel", "Ok."},
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        // The 'which' argument contains the index position
                        // of the selected item
                        switch (which) {
                            case 0:
                                break;
                            case 1:
                                Toast.makeText(BadSpecificHabit.this, "Cancelled.", Toast.LENGTH_SHORT).show();
                                break;
                            case 2:
                                Toast.makeText(BadSpecificHabit.this, "Bad Habit Recorded!", Toast.LENGTH_SHORT).show();
                                break;
                        }
                    }
                });
        builder.show();
    }

}
