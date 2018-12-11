package com.example.admin.trave2explore;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class temple_item_list extends AppCompatActivity {


    private ListView mListView;
    private ArrayList<Card> list = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.temple_itemlist);
        list.add(new Card( R.drawable.mangeshi, "Mangeshi Temple"));
        list.add(new Card( R.drawable.mahadev, "Mahadeva Temple"));
        list.add(new Card( R.drawable.nagesh, "Nagesh Temple"));
        list.add(new Card( R.drawable.brahma, "Brahma Temple"));
        list.add(new Card( R.drawable.mahalasa, "Mahalasa Temple"));
        list.add(new Card( R.drawable.damodar, "Damodar Temple"));
        list.add(new Card(R.drawable.durga,"Shantadurga Temple"));
        list.add(new Card(R.drawable.lakshmi,"Mahalaxmi Temple"));
        list.add(new Card(R.drawable.maruti,"Maruti Temple"));
        list.add(new Card(R.drawable.eshwar,"Saptakoteshwar Temple"));
        loadUI();

    }

    public void loadUI(){
        LinearLayout allPLaceLayout = (LinearLayout) findViewById(R.id.viewAllPlaces);

        try{

            for(final Card nameOfChurch : list){
                //initialisatins
                LayoutInflater layoutInflater = getLayoutInflater();
                View thePlace = layoutInflater.inflate(R.layout.add_to_temple_item_list,null);
                ImageView img = thePlace.findViewById(R.id.imgChurch);
                TextView captionImage = thePlace.findViewById(R.id.TxtChurch);
                img.setBackgroundResource(nameOfChurch.getImgURL());
                captionImage.setText(nameOfChurch.getTitle());
                allPLaceLayout.addView(thePlace);

                thePlace.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Toast.makeText(temple_item_list.this, "Click", Toast.LENGTH_SHORT).show();
                        Intent i;
                        try{
                            switch (nameOfChurch.getTitle()) {
                                case "Mangeshi Temple":
                                    i = new Intent(getApplicationContext(),Activity_temple.class);
                                    startActivity(i);

                                default:
                                    Toast.makeText(getApplicationContext(), "It seems you Pressed Wrongly", Toast.LENGTH_SHORT).show();
                                    break;
                            }

                        }catch (Exception e){
                            Toast.makeText(temple_item_list.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                        }

                    }
                });

            }
        }catch (Exception e){
            Log.w("Error", e.getMessage());
            Toast.makeText(this, "Error because of "+ e.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }
}