package com.example.admin.trave2explore;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import java.util.ArrayList;

public class add_to_beach_item_list extends AppCompatActivity {

    private static final String TAG = "addtobeachlist";

    private ListView mListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.beach_itemlist);

        ArrayList<Card> list = new ArrayList<>();
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

    }
}

