package com.example.admin.trave2explore;

import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;

public class Gallery_Church extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gallery__church);

    }
    public void loadUI(){
        LayoutInflater l = getLayoutInflater();
        View v = l.inflate(R.layout.churchimage, null, false);
        ImageView img= v.findViewById(R.id.imageID);
    }
}
