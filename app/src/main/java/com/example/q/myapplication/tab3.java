package com.example.q.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class tab3 extends AppCompatActivity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.thirdtab);
    }

    public void launchgame1(View view) {
        Intent intent = new Intent(this, game1.class);
        startActivity(intent);
    }


    public void launchgame3(View view) {
        Intent intent = new Intent(this, game3.class);
        startActivity(intent);
    }
}
