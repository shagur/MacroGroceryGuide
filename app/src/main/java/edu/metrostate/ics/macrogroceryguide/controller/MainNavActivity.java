package edu.metrostate.ics.macrogroceryguide.controller;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import edu.metrostate.ics.macrogroceryguide.R;

/**
 * Activity to serve as basis for res/layout/activity_main_nav.java class.
 * @author Macro Grocery Guide Group 4
 */
public class MainNavActivity extends AppCompatActivity {
    //view items
    private Button cart;
    private Button profile;
    private Button logout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_nav);

        //locate view items and capture button clicks
        cart = findViewById(R.id.nextButton);
        cart.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent aintent = new Intent(MainNavActivity.this, CartActivity.class);
                startActivity(aintent);
            }
        });

        profile = findViewById(R.id.nav);
        profile.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent bintent = new Intent(MainNavActivity.this, ProfileActivity.class);
                startActivity(bintent);
            }
        });

        logout = findViewById(R.id.logout);
        logout.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent cintent = new Intent(MainNavActivity.this, LoginActivity.class);
                startActivity(cintent);
            }
        });
    }
}
