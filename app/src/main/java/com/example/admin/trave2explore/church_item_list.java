package com.example.admin.trave2explore;

import android.content.Intent;
import android.os.Bundle;;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class church_item_list extends AppCompatActivity {

    private ListView mListView;
    private DrawerLayout mDrawerLayout;
    private ActionBarDrawerToggle mToggle;
    private ArrayList<Card> list = new ArrayList<>();
    //public Card name_Church;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.church_itemlist);


        list.add(new Card( R.drawable.image1, "Our Lady of Immaculate Conception"));
        list.add(new Card( R.drawable.image2, "Basilica of Bom Jesus"));
        list.add(new Card( R.drawable.fransis, "St Francis of Assisi"));
        list.add(new Card( R.drawable.cathedral2, "Se Cathedral"));
        list.add(new Card( R.drawable.cajetan, "St. Cajetan"));
        list.add(new Card( R.drawable.catherine, " St. Catherine"));
        list.add(new Card( R.drawable.rosary, " Lady of Rosary"));
        list.add(new Card( R.drawable.fxavier, " St. Francis Xavier"));
        list.add(new Card( R.drawable.monte, " Monte Hill"));
        list.add(new Card(R.drawable.alex,"St. Alex Church"));
        loadUI();

    }
    public void loadUI(){
        LinearLayout allPLaceLayout = (LinearLayout) findViewById(R.id.viewAllPlaces);

        try{

            for( final Card nameOfChurch : list){
                //initialisatins
                LayoutInflater layoutInflater = getLayoutInflater();
                View thePlace = layoutInflater.inflate(R.layout.add_to_church_list, null, false);
                ImageView img = thePlace.findViewById(R.id.imgChurch);
                final TextView captionImage = thePlace.findViewById(R.id.TxtChurch);
                img.setBackgroundResource(nameOfChurch.getImgURL());
                captionImage.setText(nameOfChurch.getTitle());
              //  name_Church = nameOfChurch;

                thePlace.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Toast.makeText(church_item_list.this, "Click", Toast.LENGTH_SHORT).show();
                        Intent i;
                        try{
                            switch (nameOfChurch.getTitle()) {
                                case "Our Lady of Immaculate Conception":
                                    i = new Intent(getApplicationContext(),Church.class);
                                    startActivity(i);

                                default:
                                    Toast.makeText(getApplicationContext(), "It seems you Pressed Wrongly", Toast.LENGTH_SHORT).show();
                                    break;
                            }

                        }catch (Exception e){
                            Toast.makeText(church_item_list.this, e.getMessage(), Toast.LENGTH_SHORT).show();
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