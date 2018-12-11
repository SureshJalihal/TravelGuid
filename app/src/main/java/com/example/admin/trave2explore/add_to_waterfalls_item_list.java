package com.example.admin.trave2explore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import java.util.ArrayList;

public class add_to_waterfalls_item_list extends AppCompatActivity {

    private static final String TAG = "addtowaterfallslist";

    private ListView mListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.waterfall_item_list);

        ArrayList<Card> list = new ArrayList<>();
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
    }
}
