package com.example.admin.trave2explore;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import java.util.ArrayList;

public class add_to_church_item_list extends AppCompatActivity {

    private static final String TAG = "addtochurchList";

    private ListView mListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.church_itemlist);

        ArrayList<Card> list = new ArrayList<>();
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

    }
}