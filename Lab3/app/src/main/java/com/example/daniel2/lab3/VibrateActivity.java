package com.example.daniel2.lab3;

import android.content.Context;
import android.os.Vibrator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class VibrateActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vibrate);
        showToast();
        vibrate();
    }

    protected void showToast(){
        /* Get the context */
        Context context = getApplicationContext();

        /* Create and display the toast */
        Toast toast = Toast.makeText(context, "Your phone will vibrate now", Toast.LENGTH_SHORT);
        toast.show();
    }

    protected void vibrate(){
        /* Obtain vibrator */
        Vibrator vibrator = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
        vibrator.vibrate(5000);
    }
}
