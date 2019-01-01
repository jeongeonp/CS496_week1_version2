package com.example.q.myapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;


public class game3_result extends AppCompatActivity {

    TextView result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.thirdgame_result);

        result = findViewById(R.id.result);
        String s = getIntent().getStringExtra("res");



        ImageView layout = (ImageView) findViewById(R.id.background);
        if (s == "gryffindor") { layout.setBackgroundResource(R.drawable.gryffindor); }
        else if (s == "ravenclaw") { layout.setBackgroundResource(R.drawable.ravenclaw); }
        else if (s == "hufflepuff") { layout.setBackgroundResource(R.drawable.hufflepuff); }
        else if (s == "slytherin") { layout.setBackgroundResource(R.drawable.slytherin); }

        result.setText(s);

    }
}
