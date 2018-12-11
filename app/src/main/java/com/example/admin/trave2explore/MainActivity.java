package com.example.admin.trave2explore;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;

public class MainActivity extends AppCompatActivity{

    Button Register,SignIn;
//    private ProgressBar progressBar;
//    private ProgressDialog progressDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        progressBar=(ProgressBar)findViewById(R.id.startBar);
//        progressBar.setVisibility(View.VISIBLE); //to show
//        progressBar.setVisibility(View.GONE); // to hide

        Register =(Button)findViewById(R.id.changeRegister);

        Register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

               Intent i;
                i = new Intent(getApplicationContext(),SignIn.class);

                startActivity(i);
            }
        });



        SignIn=(Button)findViewById(R.id.changeSignIn);

        SignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i;
                i = new Intent(getApplicationContext(),LoginActivity.class);
                startActivity(i);
            }
        });

    }

}
