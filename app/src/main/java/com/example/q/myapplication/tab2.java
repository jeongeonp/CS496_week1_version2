package com.example.q.myapplication;


import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.GridView;
import android.widget.Toast;

import java.io.File;

public class tab2 extends Activity {

    private File[] files;
    private Uri[] uris;
    public final int REQUEST_CODE = 1;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Set title for the GridView
        setTitle("GridView");
        // Get the view from grid_view.xml
        setContentView(R.layout.grid_view);
        loadOrRequestPermission();
    }

    public void loadOrRequestPermission() {
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED) {
            doLoad();
        }
        else {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.READ_EXTERNAL_STORAGE}, REQUEST_CODE);
        }
    }

    public void doLoad()
    {
        if (!Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED)) {
            Toast.makeText(this, "Error! No SDCARD Found!", Toast.LENGTH_LONG).show();
        } else {
            File dirPicture = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES);
            if (dirPicture.isDirectory()) {
                files = dirPicture.listFiles();
                uris = new Uri[files.length];
                for (int i = 0; i < files.length; i++) {
                    String fileName = files[i].getName();
                    File file = new File(dirPicture, fileName);
                    uris[i] = Uri.fromFile(file);
                }
            }
        }

        // Set the images from ImageAdapter.java to GridView
        GridView gridview = findViewById(R.id.gridview);
        gridview.setAdapter(new ImageAdapter(this, uris));

        // Listening to GridView item click
        gridview.setOnItemClickListener(new OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View v, int position, long id) {

                // Launch ImageViewPager.java on selecting GridView Item
                Intent i = new Intent(getApplicationContext(), ImageViewPager.class);

                // Send the click position to ImageViewPager.java using intent
                i.putExtra("id", position);

                // Start ImageViewPager
                startActivity(i);
            }
        });
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String permissions[], int[] grantResults)
    {
        switch(requestCode)
        {
            case REQUEST_CODE:
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED)
                {
                    doLoad();
                }
        }
    }
}