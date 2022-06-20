package com.example.trytry;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;
import com.google.firebase.auth.FirebaseAuth;

public class Home extends AppCompatActivity implements View.OnClickListener {
    public CardView card1, card2, card3, card4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        card1 = (CardView) findViewById(R.id.c1);
        card2 = (CardView) findViewById(R.id.c2);
        card3 = (CardView) findViewById(R.id.c3);
        card4 = (CardView) findViewById(R.id.c4);
        BottomNavigationView btm_view = findViewById(R.id.bottom_nav);
        btm_view.setSelectedItemId(R.id.home);
        btm_view.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id = item.getItemId();
                switch (id) {
                    //check id
                    case R.id.profile:
                        startActivity(new Intent(getApplicationContext(), User_Profile.class));
                        return true;
                    // add other add pet in here  copy from vase to class and rename and paste
                    case R.id.addpet:
                        startActivity(new Intent(getApplicationContext(), add_pet.class));
                        return true;
                }
                return true;
            }
        });
        card1.setOnClickListener(this);
        card2.setOnClickListener(this);
        card3.setOnClickListener(this);
        card4.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        Intent i;
        switch (view.getId()) {
            case R.id.c1:
                i=new Intent(this,dog.class);
                startActivity(i);
                break;

            case R.id.c2:
                i=new Intent(this,cats.class);
                startActivity(i);
                break;

            case R.id.c3:
                i=new Intent(this,reptiles.class);
                startActivity(i);
                break;

            case R.id.c4:
                i=new Intent(this,Birds.class);
                startActivity(i);
                break;
        }
    }
}



