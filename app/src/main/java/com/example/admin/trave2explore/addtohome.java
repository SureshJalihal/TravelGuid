package com.example.admin.trave2explore;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import java.util.ArrayList;

public class addtohome extends AppCompatActivity {

    private static final String TAG = "addtohome";

    private ListView mListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homepage);

     ArrayList<Card> list = new ArrayList<>();
        list.add(new Card( R.drawable.image1, "Church1"));
        list.add(new Card( R.drawable.image2, "Church2"));
        list.add(new Card( R.drawable.image3, "Church3"));
        list.add(new Card( R.drawable.image4, "Church4"));
        list.add(new Card( R.drawable.image5, "Church5"));
        list.add(new Card( R.drawable.image6, "Church6"));

    }


}