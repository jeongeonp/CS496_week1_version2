package com.example.q.myapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class game1 extends AppCompatActivity {

    Button rock, paper, scissors;
    TextView tv_score;
    ImageView iv_opponent, iv_you;
    int totalScore, myScore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.firstgame);

        paper = (Button) findViewById(R.id.paper);
        rock = (Button) findViewById(R.id.rock);
        scissors = (Button) findViewById(R.id.scissors);

        tv_score = (TextView) findViewById(R.id.score);

        iv_opponent = (ImageView) findViewById(R.id.opponent);
        iv_you = (ImageView) findViewById(R.id.you);

        rock.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                iv_you.setImageResource(R.drawable.rock2);
                String msg = play_turn("rock");
                Toast.makeText(game1.this, msg, Toast.LENGTH_SHORT).show();
                tv_score.setText(myScore + " out of " + totalScore );
            }
        });

        paper.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                iv_you.setImageResource(R.drawable.paper2);
                String msg = play_turn("paper");
                Toast.makeText(game1.this, msg, Toast.LENGTH_SHORT).show();
                tv_score.setText(myScore + " out of " + totalScore );
            }
        });

        scissors.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                iv_you.setImageResource(R.drawable.scissors2);
                String msg = play_turn("scissors");
                Toast.makeText(game1.this, msg, Toast.LENGTH_SHORT).show();
                tv_score.setText(myScore + " out of " + totalScore );
            }
        });


    }


    public String play_turn (String cPlayer) {
        String cOpponent = "";
        Random r = new Random();

        int randNum = r.nextInt(3) + 1;

        if (randNum == 1) { cOpponent = "rock"; }
        else if (randNum == 2) { cOpponent = "paper"; }
        else if (randNum == 3) {cOpponent = "scissors"; }

        if (cOpponent == "rock") { iv_opponent.setImageResource(R.drawable.rock2); }
        else if (cOpponent == "paper") { iv_opponent.setImageResource(R.drawable.paper2); }
        else if (cOpponent == "scissors") { iv_opponent.setImageResource(R.drawable.scissors2); }


        if (cOpponent == cPlayer) {
            totalScore++;
            return "It's a tie!";
        }
        else if (cPlayer == "rock" && cOpponent == "scissors") {
            myScore++;
            totalScore++;
            return "You win! Good job.";
        }
        else if (cPlayer == "paper" && cOpponent == "rock") {
            myScore++;
            totalScore++;
            return "You win! Good job.";
        }
        else if (cPlayer == "scissors" && cOpponent == "paper") {
            myScore++;
            totalScore++;
            return "You win! Good job.";
        }
        else if (cOpponent == "rock" && cPlayer== "scissors") {
            totalScore++;
            return "I'm sorry. You lost :(";
        }
        else if (cOpponent == "paper" && cPlayer == "rock") {
            totalScore++;
            return "I'm sorry. You lost :(";
        }
        else if (cOpponent == "scissors" && cPlayer == "paper") {
            totalScore++;
            return "I'm sorry. You lost :(";
        }
        else { return "Something is wrong!"; }
    }


}
