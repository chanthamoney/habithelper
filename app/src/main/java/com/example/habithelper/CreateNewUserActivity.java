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
import android.widget.TextView;

public class CreateNewUserActivity extends AppCompatActivity {

    Globals sharedData = Globals.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_new_user);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Button submitSignIn = (Button) findViewById(R.id.submitSignIn);
        submitSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sharedData.setProfileName(((EditText) findViewById(R.id.fullNameInput)).getText().toString());
                sharedData.setUsername(((EditText) findViewById(R.id.usernameInput)).getText().toString());
                sharedData.setBio(((EditText) findViewById(R.id.bioInput)).getText().toString());
                Intent i = new Intent(CreateNewUserActivity.this, home.class);
                startActivity(i);
            }
        });

        String[] arraySpinner = new String[] {
                "Good Habits", "Bad Habits", "Charity"
        };
        final Spinner s = (Spinner) findViewById(R.id.spinner);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, arraySpinner);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        s.setAdapter(adapter);
        s.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Object selectedItem = s.getSelectedItem();
                if (selectedItem.toString().equals("Charity")) {
                    AlertDialog.Builder builder = new AlertDialog.Builder(CreateNewUserActivity.this);
                    builder.setTitle("Are you sure?");
                    builder.setIcon(R.drawable.jar);
                    builder.setMessage("Charity mode will immediately donate your funds from the jar to the Ronald McDonald House Charity.");
                    builder.setPositiveButton("OK",
                            new DialogInterface.OnClickListener()
                            {
                                public void onClick(DialogInterface dialog, int id)
                                {
                                    dialog.cancel();
                                }
                            });

                    builder.setNegativeButton("Cancel",
                            new DialogInterface.OnClickListener()
                            {
                                public void onClick(DialogInterface dialog, int id)
                                {
                                    s.setSelection(0);
                                    dialog.cancel();
                                }
                            });
                    builder.create().show();
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }
}
