package com.example.admin.trave2explore;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import java.util.ArrayList;

public class add_to_fort_item_list extends AppCompatActivity {

    private static final String TAG = "addtowaterfallslist";

    private ListView mListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.waterfall_item_list);

        ArrayList<Card> list = new ArrayList<>();

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

    }
}
