package com.example.q.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;


public class tab1_moreinfo extends AppCompatActivity implements View.OnClickListener {

    Button button;
    EditText notes;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.moreinfotab);

        button = (Button) findViewById(R.id.enter);
        notes = (EditText) findViewById(R.id.text);

        button.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(getApplicationContext(), tab1.class);
        /*// Get the text view.
        TextView showCountTextView = (TextView) findViewById(R.id.notes);
        // Get the value of text view
       showCountTextView.setText("notes ");*/

        Bundle b = new Bundle();
        b.putString("notes", notes.getText().toString());

        intent.putExtras(b);
        startActivity(intent);
    }



}