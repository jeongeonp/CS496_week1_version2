package com.example.q.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

public class game3 extends AppCompatActivity {

    int gryffindor, hufflepuff, ravenclaw, slytherin;
    Button submit;
    TextView top, quiz1, quiz2, quiz3, quiz4, quiz5;
    RadioButton answer11, answer12, answer13, answer14, answer21, answer22, answer23, answer24, answer31, answer32, answer33, answer34, answer41, answer42, answer43, answer44, answer51, answer52, answer53, answer54;
    RadioGroup answer1, answer2, answer3, answer4, answer5;
    ScrollView scroll;
    String result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.thirdgame);



        answer11 = findViewById(R.id.answer11);
        answer12 = findViewById(R.id.answer12);
        answer13 = findViewById(R.id.answer13);
        answer14 = findViewById(R.id.answer14);
        answer21 = findViewById(R.id.answer21);
        answer22 = findViewById(R.id.answer22);
        answer23 = findViewById(R.id.answer23);
        answer24 = findViewById(R.id.answer24);
        answer31 = findViewById(R.id.answer31);
        answer32 = findViewById(R.id.answer32);
        answer33 = findViewById(R.id.answer33);
        answer34 = findViewById(R.id.answer34);
        answer41 = findViewById(R.id.answer41);
        answer42 = findViewById(R.id.answer42);
        answer43 = findViewById(R.id.answer43);
        answer44 = findViewById(R.id.answer44);
        answer51 = findViewById(R.id.answer51);
        answer52 = findViewById(R.id.answer52);
        answer53 = findViewById(R.id.answer53);
        answer54 = findViewById(R.id.answer54);

        answer1 = findViewById(R.id.answer1);
        answer2 = findViewById(R.id.answer2);
        answer3 = findViewById(R.id.answer3);
        answer4 = findViewById(R.id.answer4);
        answer5 = findViewById(R.id.answer5);

        scroll = findViewById(R.id.scroll);
        submit = findViewById(R.id.submit);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                test();
                Intent intent = new Intent(game3.this, game3_result.class).putExtra("res", result);
                startActivity(intent);
            }
        });


    }

    public void notCompleted(int i, RadioGroup v) {
        Toast toast = Toast.makeText(game3.this, "All questions must be answered!", Toast.LENGTH_SHORT);
        toast.show();

        //todo move ScrollView to that question
    }

    public void test() {
        gryffindor=0;
        hufflepuff=0;
        ravenclaw=0;
        slytherin=0;


        if (answer11.isChecked()) hufflepuff+=10;
        else if (answer12.isChecked()) ravenclaw+=10;
        else if (answer13.isChecked()) gryffindor+=10;
        else if (answer14.isChecked()) slytherin+=10;
        else {
            notCompleted(1, answer1);
            result = "No Match";
            return;
        }

        if (answer21.isChecked()) ravenclaw+=20;
        else if (answer22.isChecked()) gryffindor+=20;
        else if (answer23.isChecked()) hufflepuff+=20;
        else if (answer24.isChecked()) slytherin+=20;
        else {
            notCompleted(2, answer2);
            result = "No Match";
            return;
        }

        if (answer31.isChecked()) gryffindor+=27;
        else if (answer32.isChecked()) hufflepuff+=27;
        else if (answer33.isChecked()) ravenclaw+=27;
        else if (answer34.isChecked()) slytherin+=27;
        else {
            notCompleted(3, answer3);
            result = "No Match";
            return;
        }

        if (answer41.isChecked()) slytherin+=14;
        else if (answer42.isChecked()) hufflepuff+=14;
        else if (answer43.isChecked()) gryffindor+=14;
        else if (answer44.isChecked()) ravenclaw+=14;
        else {
            notCompleted(4, answer4);
            result = "No Match";
            return;
        }

        if (answer51.isChecked()) slytherin+=17;
        else if (answer52.isChecked()) ravenclaw+=17;
        else if (answer53.isChecked()) hufflepuff+=17;
        else if (answer54.isChecked()) gryffindor+=17;
        else {
            notCompleted(5, answer5);
            result = "No Match";
            return;
        }

        result = calculate();
    }

    public String calculate() {
        if (slytherin > ravenclaw && slytherin > hufflepuff && slytherin > gryffindor) return "slytherin";
        else if (ravenclaw > hufflepuff && ravenclaw > gryffindor && ravenclaw > slytherin) return "ravenclaw";
        else if (hufflepuff > gryffindor && hufflepuff > slytherin && hufflepuff > ravenclaw) return "hufflepuff";
        else if (gryffindor > slytherin && gryffindor > hufflepuff && gryffindor > ravenclaw) return "gryffindor";
        else return "No Match";
    }

}
