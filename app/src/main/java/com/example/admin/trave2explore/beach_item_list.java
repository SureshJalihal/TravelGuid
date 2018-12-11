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

public class beach_item_list extends AppCompatActivity {


    private ListView mListView;
    private ArrayList<Card> list = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.beach_itemlist);
        list.add(new Card( R.drawable.vagator, "Vagatore"));
        list.add(new Card( R.drawable.candolimandcalangute, "Calangute"));
        list.add(new Card( R.drawable.baga, "Baga"));
        list.add(new Card( R.drawable.arambolbeach, "Arambol"));
        list.add(new Card( R.drawable.palolim, "Palolim"));
        list.add(new Card( R.drawable.colva, "Colva"));
        list.add(new Card(R.drawable.mobor,"Mobor"));
        list.add(new Card(R.drawable.sinquerim,"Sinquerim"));
        list.add(new Card(R.drawable.arossim,"Arossim"));
        list.add(new Card(R.drawable.morijim,"Morjim"));
        list.add(new Card(R.drawable.bogmalo,"Bogmalo"));
        list.add(new Card(R.drawable.anjuna,"Anjuna"));
        loadUI();

    }

    public void loadUI(){
        LinearLayout allPLaceLayout = (LinearLayout) findViewById(R.id.viewAllPlaces);

        try{

            for(final Card  nameOfChurch : list){
                //initialisatins
                LayoutInflater layoutInflater = getLayoutInflater();
                View thePlace = layoutInflater.inflate(R.layout.add_to_beach_item_list,null);
                ImageView img = thePlace.findViewById(R.id.imgChurch);
                TextView captionImage = thePlace.findViewById(R.id.TxtChurch);
                img.setBackgroundResource(nameOfChurch.getImgURL());
                captionImage.setText(nameOfChurch.getTitle());

                thePlace.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Toast.makeText(beach_item_list.this, "Click", Toast.LENGTH_SHORT).show();
                        Intent i;
                        try{
                            switch (nameOfChurch.getTitle()) {
                                case "Vagatore":
                                    i = new Intent(getApplicationContext(),Activity_beache.class);
                                    startActivity(i);

                                default:
                                    Toast.makeText(getApplicationContext(), "It seems you Pressed Wrongly", Toast.LENGTH_SHORT).show();
                                    break;
                            }

                        }catch (Exception e){
                            Toast.makeText(beach_item_list.this, e.getMessage(), Toast.LENGTH_SHORT).show();
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

