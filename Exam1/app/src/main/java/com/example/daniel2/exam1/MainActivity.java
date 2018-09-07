package com.example.daniel2.exam1;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    final int PAPER = 0, ROCK = 1, SCISSORS = 2;
    private Button rock,paper,scissors,reset;
    private TextView userScore, computerScore;
    /* 0 = tie, 1 = wins, -1 = loses */
    Map<Integer, Integer> paperMap = new HashMap<Integer, Integer>() {{
        put(PAPER, 0);
        put(ROCK, 1);
        put(SCISSORS, -1);
    }};

    Map<Integer, Integer> rockMap = new HashMap<Integer, Integer>() {{
        put(PAPER, -1);
        put(ROCK, 0);
        put(SCISSORS, 1);
    }};

    Map<Integer, Integer> scissorsMap = new HashMap<Integer, Integer>() {{
        put(PAPER, 1);
        put(ROCK, -1);
        put(SCISSORS, 0);
    }};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /* Initialize buttons and textviews */
        rock = (Button) findViewById(R.id.rock_button);
        paper = (Button) findViewById(R.id.paper_button);
        scissors = (Button) findViewById(R.id.scissors_button);
        reset = (Button) findViewById(R.id.reset_button);
        userScore = (TextView) findViewById(R.id.user_score);
        computerScore = (TextView) findViewById(R.id.computer_score);

        /* Set listener for rock button */
        /*Set click listener for rock button */
        rock.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view)
            {
                turn(ROCK);
            }
        });
        /*Set click listener for paper button */
        paper.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view)
            {
                turn(PAPER);
            }
        });
        /*Set click listener for scissors button */
        scissors.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view)
            {
                turn(SCISSORS);
            }
        });
        /*Set click listener for reset button */
        reset.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view)
            {
                resetGame();
            }
        });

    }

    public void turn(int userChoice){
        /* Generate random number for computer choice */
        Random myRandom = new Random();
        int computerChoice = myRandom.nextInt(3);
        String computerChoiceString = getSelection(computerChoice);
        String feedback = "Computer chooses " + computerChoiceString + ". You ";
        /* Obtain the winner */
        int beats = beats(userChoice, computerChoice);
        if (beats == 0){
            /* Tie*/
            feedback += "tied!";
        } else if (beats < 0){
            /* Loses */
            computerScore.setText(String.valueOf(Integer.parseInt(computerScore.getText().toString()) + 1));
            feedback+= "lost!";
        } else {
            /* Wins */
            userScore.setText(String.valueOf(Integer.parseInt(userScore.getText().toString()) + 1));
            feedback += "won!";
        }
        /*Show dialog */
        showToast(feedback);

    }

    public void resetGame(){
        /* Set scores to 0 */
        userScore.setText(String.valueOf(0));
        computerScore.setText(String.valueOf(0));
    }

    public int beats(int userChoice, int computerChoice){
        switch (userChoice) {
            case PAPER:
                return paperMap.get(computerChoice);
            case ROCK:
                return rockMap.get(computerChoice);
            case SCISSORS:
                return scissorsMap.get(computerChoice);
            default:
                return 0;
        }
    }

    /* Transform int to string */
    public String getSelection(int selection){
        if (selection == 0){
            return "paper";
        } else if (selection == 1){
            return "rock";
        } else if (selection == 2){
            return "scissors";
        }
        return "";
    }

    protected void showToast(String message){
        /* Get the context */
        Context context = getApplicationContext();

        /* Create and display the toast */
        Toast toast = Toast.makeText(context, message, Toast.LENGTH_SHORT);
        toast.show();
    }
}
