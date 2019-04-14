package com.example.habithelper;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class LoggingOut extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logging_out);

        Intent mStartActivity = new Intent(LoggingOut.this, LoginActivity.class);
        startActivity(mStartActivity);
    }
}
