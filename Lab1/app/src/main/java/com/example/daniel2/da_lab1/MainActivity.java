package com.example.daniel2.da_lab1;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void talk_to_doggo(View v){
        Intent intent = new Intent(MainActivity.this, Activity2.class);
        /*Obtain text*/
        EditText editText = findViewById(R.id.editText);
        String text = editText.getText().toString();

        /*Set text to activity 2*/
        intent.putExtra("text", text);

        /*Start activity 2*/
        startActivity(intent);
    }

    public void change_text(View v){
       /* obtain text view */
       TextView textView = findViewById(R.id.textView3);

       /*Change text */
       textView.setText("Casual conversations doesn't mean that she likes you.");
    }

    public void doggo(View v) {
        Intent intent = new Intent(MainActivity.this, activity_3.class);
        startActivity(intent);
    }
}
