package com.example.admin.trave2explore;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import java.util.ArrayList;

public class add_to_temple_item_list extends AppCompatActivity {

    private static final String TAG = "addtotemplelist";

    private ListView mListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.temple_itemlist);

        ArrayList<Card> list = new ArrayList<>();
        list.add(new Card( R.drawable.mangeshi, "Mangeshi Temple"));
        list.add(new Card( R.drawable.mahadev, "Mahadeva Temple"));
        list.add(new Card( R.drawable.nagesh, "Nagesh Temple"));
        list.add(new Card( R.drawable.brahma, "Brahma Temple"));
        list.add(new Card( R.drawable.mahalasa, "Mahalasa Temple"));
        list.add(new Card( R.drawable.damodar, "Damodar Temple"));
        list.add(new Card(R.drawable.durga,"Shantadurga Temple"));
        list.add(new Card(R.drawable.lakshmi,"Mahalaxmi Temple"));
        list.add(new Card(R.drawable.maruti,"Maruti Temple"));
        list.add(new Card(R.drawable.eshwar," Saptakoteshwar Temple"));

    }
}
