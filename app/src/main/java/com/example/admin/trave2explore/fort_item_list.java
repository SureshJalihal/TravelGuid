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

public class fort_item_list extends AppCompatActivity {


    private ListView mListView;
    private ArrayList<Card> list = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.fort_item_list);

        list.add(new Card( R.drawable.agu, "Aguada Fort"));
        list.add(new Card( R.drawable.chapora, "Chapora Fort"));
        list.add(new Card( R.drawable.fortrm, "Reis Magos Fort"));
        list.add(new Card( R.drawable.corjuem, "Corjuem Fort"));
        list.add(new Card( R.drawable.terekhol, "Terekhol Fort"));
        list.add(new Card( R.drawable.sinquerim, " Sinquerim Fort"));
        list.add(new Card(R.drawable.nanuz,"Nanuz Fort"));
        list.add(new Card(R.drawable.cabo,"Cabo de Rama Fort"));
        list.add(new Card(R.drawable.rachol," Rachol Fort"));
        list.add(new Card(R.drawable.mogoa,"Mormugao Fort"));
        list.add(new Card(R.drawable.anjidev,"Anjdiv Fort"));
        loadUI();

    }

    public void loadUI(){
        LinearLayout allPLaceLayout = (LinearLayout) findViewById(R.id.viewAllPlaces);

        try{

            for(final Card nameOfChurch : list){
                //initialisatins
                LayoutInflater layoutInflater = getLayoutInflater();
                View thePlace = layoutInflater.inflate(R.layout.add_to_fort_item_list,null);
                ImageView img = thePlace.findViewById(R.id.imgChurch);
                TextView captionImage = thePlace.findViewById(R.id.TxtChurch);
                img.setBackgroundResource(nameOfChurch.getImgURL());
                captionImage.setText(nameOfChurch.getTitle());

                thePlace.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Toast.makeText(fort_item_list.this, "Click", Toast.LENGTH_SHORT).show();
                        Intent i;
                        try{
                            switch (nameOfChurch.getTitle()) {
                                case "Aguada Fort":
                                    i = new Intent(getApplicationContext(),fort_activity.class);
                                    startActivity(i);

                                default:
                                    Toast.makeText(getApplicationContext(), "It seems you Pressed Wrongly", Toast.LENGTH_SHORT).show();
                                    break;
                            }

                        }catch (Exception e){
                            Toast.makeText(fort_item_list.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                        }

                    }
                });
                allPLaceLayout.addView(thePlace);
            }
        }catch (Exception e){
            Log.w("Error", e.getMessage());
            Toast.makeText(this, "Error because of "+ e.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }
}
