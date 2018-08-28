package com.example.daniel2.da_lab1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Activity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);

        /*Obtain text from intent, if any */
        Intent intent = getIntent();

        String text = intent.getStringExtra("text");

        /*Set text if any */
        TextView textView = findViewById(R.id.varText);
        textView.setText("You said: " + text + " to the doggo.");
    }
}
