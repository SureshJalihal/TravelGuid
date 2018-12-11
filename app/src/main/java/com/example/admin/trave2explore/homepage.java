package com.example.admin.trave2explore;

import android.content.Intent;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;

import java.util.ArrayList;

public class homepage extends AppCompatActivity {

        private DrawerLayout mDrawerLayout;
        private ActionBarDrawerToggle mToggle;
        private TextView Usermail;
        private ListView mListView;
        private FirebaseAuth firebaseAuth;
        Button btnlogout;
        private ArrayList<Card> list = new ArrayList<>();
//        ImageView imageViewbtn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homepage);
        Usermail=findViewById(R.id.TxtUserEmail);
        btnlogout=(Button)findViewById(R.id.btnlogout);

        Usermail.setText(getIntent().getExtras().getString("Email"));
        mDrawerLayout =(DrawerLayout)findViewById(R.id.drawer);
        mToggle =new ActionBarDrawerToggle(this,mDrawerLayout, R.string.open, R.string.close);
        mDrawerLayout.addDrawerListener(mToggle);
        firebaseAuth = FirebaseAuth.getInstance();
        mToggle.syncState();


        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        list.add(new Card( R.drawable.churchlistpic, "Church"));
        list.add(new Card( R.drawable.coconu, "Beaches"));
        list.add(new Card( R.drawable.mangesh, "Temples"));
        list.add(new Card( R.drawable.dhudsagarfall, "Waterfalls"));
        list.add(new Card( R.drawable.aguadafort, "Forts"));
        loadUI();


        btnlogout.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View v) {

            LogOut();
            }
        });
    }

        @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu,menu);
        return true;
    }


    private void LogOut(){

        firebaseAuth.signOut();
        finish();
        startActivity(new Intent(homepage.this,MainActivity.class));

    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {


        switch (item.getItemId()){
            case R.id.logout:{
                LogOut();
            }
        }

           if(mToggle.onOptionsItemSelected(item)){
               return true;
           }
        return super.onOptionsItemSelected(item);
    }
    public void loadUI(){
        LinearLayout allPLaceLayout = (LinearLayout) findViewById(R.id.viewAllPlaces);

        try{

            for(final Card nameOfChurch : list){
                //initialisatins
                LayoutInflater layoutInflater = getLayoutInflater();
                View thePlace = layoutInflater.inflate(R.layout.addtohome, null);
                ImageView img = thePlace.findViewById(R.id.imgChurch);
                final TextView captionImage = thePlace.findViewById(R.id.TxtChurch);
                img.setBackgroundResource(nameOfChurch.getImgURL());
                captionImage.setText(nameOfChurch.getTitle());

                thePlace.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Toast.makeText(homepage.this, "Click", Toast.LENGTH_SHORT).show();
                        Intent i;
                        try{
                            switch (nameOfChurch.getTitle()) {
                                case "Church":
                                    i = new Intent(getApplicationContext(), church_item_list.class);
                                    startActivity(i);
                                    break;
                                case "Beaches":
                                    i = new Intent(getApplicationContext(), beach_item_list.class);
                                    startActivity(i);
                                    break;
                                case "Temples":
                                    i = new Intent(getApplicationContext(), temple_item_list.class);
                                    startActivity(i);
                                    break;
                                case "Waterfalls":
                                    i = new Intent(getApplicationContext(), waterfalls_item_list.class);
                                    startActivity(i);
                                    break;

                                case "Forts":
                                    i =new Intent(getApplicationContext(),fort_item_list.class);
                                    startActivity(i);

                                default:
                                    Toast.makeText(getApplicationContext(), "It seems you Pressed Wrongly", Toast.LENGTH_SHORT).show();
                                    break;
                            }

                        }catch (Exception e){
                            Toast.makeText(homepage.this, e.getMessage(), Toast.LENGTH_SHORT).show();
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

