package com.example.daniel2.lab3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button buttonVibrate, buttonProximity;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /* Initialize buttons */
        buttonVibrate = (Button) findViewById(R.id.buttonVibrate);
        buttonProximity = findViewById(R.id.buttonProximity);

        /*Set click listener for vibrate button */
        buttonVibrate.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view)
            {
                Intent intent = new Intent(MainActivity.this, VibrateActivity.class);
                startActivity(intent);
            }
        });

        /*Set click listener for proximity button */
        buttonProximity.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent intent = new Intent(MainActivity.this, PromixityActivity.class);
                startActivity(intent);

            }
        });
    }
}
