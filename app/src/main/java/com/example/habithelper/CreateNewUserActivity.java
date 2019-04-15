package com.example.habithelper;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

public class CreateNewUserActivity extends AppCompatActivity {

    Globals sharedData = Globals.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_new_user);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        String[] arraySpinner = new String[]{
                "", "Good Habits", "Bad Habits", "Charity"
        };
        final Spinner s = (Spinner) findViewById(R.id.spinner);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, arraySpinner);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        s.setAdapter(adapter);

        Button submitSignIn = (Button) findViewById(R.id.submitSignIn);
        submitSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (s.getSelectedItem().toString().equals("")) {
                    AlertDialog.Builder builder = new AlertDialog.Builder(CreateNewUserActivity.this);
                    builder.setTitle("No Mode Selected");
                    builder.setIcon(R.drawable.baseline_error_black_18dp);
                    builder.setMessage("Please select a mode to continue.");
                    builder.setPositiveButton("Ok",
                            new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int id) {
                                    dialog.cancel();
                                }
                            });
                    builder.show();
                } else if (((EditText) findViewById(R.id.fullNameInput)).getText().toString().equals("")) {
                    AlertDialog.Builder builder = new AlertDialog.Builder(CreateNewUserActivity.this);
                    builder.setTitle("Empty Profile Name");
                    builder.setIcon(R.drawable.baseline_error_black_18dp);
                    builder.setMessage("Please input your full name.");
                    builder.setPositiveButton("Ok",
                            new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int id) {
                                    dialog.cancel();
                                }
                            });
                    builder.show();
                } else if (((EditText) findViewById(R.id.usernameInput)).getText().toString().equals("")) {
                    AlertDialog.Builder builder = new AlertDialog.Builder(CreateNewUserActivity.this);
                    builder.setTitle("Empty Username");
                    builder.setIcon(R.drawable.baseline_error_black_18dp);
                    builder.setMessage("Please a valid username.");
                    builder.setPositiveButton("Ok",
                            new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int id) {
                                    dialog.cancel();
                                }
                            });
                    builder.show();
                } else {
                    sharedData.setProfileName(((EditText) findViewById(R.id.fullNameInput)).getText().toString());
                    sharedData.setUsername(((EditText) findViewById(R.id.usernameInput)).getText().toString());
                    sharedData.setBio(((EditText) findViewById(R.id.bioInput)).getText().toString());
                    Intent i = new Intent(CreateNewUserActivity.this, home.class);
                    i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    startActivity(i);
                    finish();
                }
            }
        });

        s.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Object selectedItem = s.getSelectedItem();
                if (selectedItem.toString().equals("Charity")) {
                    AlertDialog.Builder builder = new AlertDialog.Builder(CreateNewUserActivity.this);
                    builder.setTitle("Are you sure?");
                    builder.setIcon(R.drawable.jar);
                    builder.setMessage("Charity mode will immediately donate your funds from the jar to the Ronald McDonald House.");
                    builder.setPositiveButton("Ok",
                            new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int id) {
                                    dialog.cancel();
                                }
                            });

                    builder.setNegativeButton("Cancel",
                            new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int id) {
                                    s.setSelection(0);
                                    dialog.cancel();
                                }
                            });
                    builder.show();
                } else if (selectedItem.toString().equals("Bad Habits")) {
                    AlertDialog.Builder builder = new AlertDialog.Builder(CreateNewUserActivity.this);
                    builder.setTitle("Bad Habits Mode");
                    builder.setIcon(R.drawable.jar);
                    builder.setMessage("This is the simplest mode. You will be charged money to put in the jar every time you break a bad habit.");
                    builder.setPositiveButton("Ok",
                            new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int id) {
                                    dialog.cancel();
                                }
                            });
                    builder.show();
                } else if (selectedItem.toString().equals("Good Habits")) {
                    AlertDialog.Builder builder = new AlertDialog.Builder(CreateNewUserActivity.this);
                    builder.setTitle("Good Habits Mode");
                    builder.setIcon(R.drawable.jar);
                    builder.setMessage("This mode is similar to Bad Habits but with the addition of good habits. By completing good habits you can earn back money from bad habits.");
                    builder.setPositiveButton("Ok",
                            new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int id) {
                                    dialog.cancel();
                                }
                            });
                    builder.show();
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }
}
