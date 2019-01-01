package com.example.q.myapplication;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


public class game3_result extends AppCompatActivity {

    TextView result;
    ImageView emblem;
    ImageView background;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.thirdgame_result);

        //emblem = (ImageView) findViewById(R.id.emblem);
        background = (ImageView) findViewById(R.id.background);
        result = findViewById(R.id.result);
        String s = getIntent().getStringExtra("res");

        System.out.println(s);

        /*
        if (s == "gryffindor") { emblem.setImageResource(R.drawable.mgryffindor); }
        else if (s == "ravenclaw") { emblem.setImageResource(R.drawable.mravenclaw); }
        else if (s == "hufflepuff") { emblem.setImageResource(R.drawable.mhufflepuff); }
        else if (s == "slytherin") { emblem.setImageResource(R.drawable.mslytherin); }
        */
        if (s.equals("gryffindor")) {
            background.setBackgroundResource(R.drawable.bgryffindor);
            result.setTextColor(Color.parseColor("#FFC500"));
        }
        else if (s.equals("ravenclaw")) {
            background.setBackgroundResource(R.drawable.bravenclaw);
            result.setTextColor(Color.parseColor("#000A90"));
        }
        else if (s.equals("hufflepuff")) {
            background.setBackgroundResource(R.drawable.bhufflepuff);
            result.setTextColor(Color.parseColor("#EEE117"));
        }
        else if (s.equals("slytherin")) {
            background.setBackgroundResource(R.drawable.bslytherin);
            result.setTextColor(Color.parseColor("#0D6217"));
        }
        else {
            background.setBackgroundResource(R.drawable.background4);
            result.setTextColor(Color.parseColor("#FFC500"));
        }
        //Toast.makeText(this, s, Toast.LENGTH_SHORT).show();


        result.setText(s);

    }
}
