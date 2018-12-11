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

public class waterfalls_item_list extends AppCompatActivity {


    private ListView mListView;
    private ArrayList<Card> list = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.waterfall_item_list);
        list.add(new Card( R.drawable.dhooddd, "Dudhsagar Waterfall"));
        list.add(new Card( R.drawable.hivrem, "Hivre Waterfall"));
        list.add(new Card( R.drawable.tambdisurla, "Tambadi Surla Waterfall"));
        list.add(new Card( R.drawable.netravali, "Netravali Waterfall"));
        list.add(new Card( R.drawable.aravlemmm, "Arvalem Waterfall"));
        list.add(new Card( R.drawable.bamanbudo, " Bamanbudo Waterfall"));
        list.add(new Card(R.drawable.kesarval,"Kesarval Waterfall"));
        list.add(new Card(R.drawable.kuskem,"Kuskem Waterfall"));
        list.add(new Card(R.drawable.charavana,"Charavane Waterfall"));
        list.add(new Card(R.drawable.sadaa,"Sada Waterfall"));
        loadUI();

    }

    public void loadUI(){
        LinearLayout allPLaceLayout = (LinearLayout) findViewById(R.id.viewAllPlaces);

        try{

            for(final Card nameOfChurch : list){
                //initialisatins
                LayoutInflater layoutInflater = getLayoutInflater();
                View thePlace = layoutInflater.inflate(R.layout.add_to_waterfalls_item_list,null);
                ImageView img = thePlace.findViewById(R.id.imgChurch);
                TextView captionImage = thePlace.findViewById(R.id.TxtChurch);
                img.setBackgroundResource(nameOfChurch.getImgURL());
                captionImage.setText(nameOfChurch.getTitle());
                allPLaceLayout.addView(thePlace);


                thePlace.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Toast.makeText(waterfalls_item_list.this, "Click", Toast.LENGTH_SHORT).show();
                        Intent i;
                        try{
                            switch (nameOfChurch.getTitle()) {
                                case "Dudhsagar Waterfall":
                                    i = new Intent(getApplicationContext(),Activity_waterfall.class);
                                    startActivity(i);

                                default:
                                    Toast.makeText(getApplicationContext(), "It seems you Pressed Wrongly", Toast.LENGTH_SHORT).show();
                                    break;
                            }

                        }catch (Exception e){
                            Toast.makeText(waterfalls_item_list.this, e.getMessage(), Toast.LENGTH_SHORT).show();
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