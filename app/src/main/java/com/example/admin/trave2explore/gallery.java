package com.example.admin.trave2explore;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.ImageView;


public class gallery extends AppCompatActivity {

    GridView Grid;
    GRIDAdapter adapter;
    final Integer[] image = new Integer[]{R.drawable.conceptio1, R.drawable.conceptio2, R.drawable.conceptio3,
            R.drawable.conceptio4, R.drawable.conceptio6, R.drawable.conceptio6,R.drawable.conceptio7,R.drawable.conceptio8};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gallery);
//        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar);



        Grid = (GridView)findViewById(R.id.MyGrid);
        adapter = new GRIDAdapter(getApplicationContext(), R.layout.churchimage, image);

        Grid.setAdapter(adapter);
        Grid.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
                Intent go = new Intent(getApplicationContext(), Details.class);
                go.putExtra("image", image[position]);
                //By position Clicked
                startActivity(go);
            }
        });

    }


    public class GRIDAdapter extends ArrayAdapter {
        private Integer[] Image;
        private int resource;
        private LayoutInflater inflater;

        public GRIDAdapter(Context context, int resource, Integer[] image) {
            super(context, resource, image);
            Image = image;
            this.resource = resource;
            inflater = (LayoutInflater)gallery.this.getSystemService(LAYOUT_INFLATER_SERVICE);
        }

        @NonNull
        @Override
        public View getView(int position, View convertView, @NonNull ViewGroup parent) {
            try {
                ViewHolder holder = null;

                holder = new ViewHolder();
                convertView = inflater.inflate(resource, null);
                holder.IMAGE = (ImageView) convertView.findViewById(R.id.imageID);
                convertView.setTag(holder);
                holder.IMAGE.setImageResource(image[position]);
                Log.w("oimg ", image[position].toString());
                holder.IMAGE.setScaleType(ImageView.ScaleType.CENTER_CROP);

                return convertView;
            }catch (Exception e){
               Log.w("Error", e.getMessage());
            }
            return null;
        }

        class ViewHolder {
            private ImageView IMAGE;
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
