package com.example.admin.trave2explore;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.Toast;

public class Church extends AppCompatActivity {

    Button showgallery;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_church);

//        Toolbar mytbar = (Toolbar) findViewById(R.id.toolbar);
//        setSupportActionBar(mytbar);

        showgallery=(Button)findViewById(R.id.ShowchurchGallery);

        showgallery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i;
                i = new Intent(getApplicationContext(),gallery.class);

                startActivity(i);
            }
        });

        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);

            }
       }

       void Press(View v){
           RatingBar r =(RatingBar) findViewById(R.id.RateBar);
           Toast.makeText(getApplicationContext(),String.valueOf(r.getRating()),Toast.LENGTH_LONG).show();
       }

    }
