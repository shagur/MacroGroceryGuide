package edu.metrostate.ics.macrogroceryguide.controller;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import edu.metrostate.ics.macrogroceryguide.R;

/**
 * Activity to serve as basis for res/layout/activity_food_category_checkout
 * @author Macro Grocery Guide Group 4
 */
public class FoodTypeNavActivity extends AppCompatActivity {

    //view items
    private Button back;
    private Button protein;
    private Button fats;
    private Button carb;
    private ImageButton proteinInfo;
    private ImageButton fatInfo;
    private ImageButton carbInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_category_checkout);

        //locate view items
        back = findViewById(R.id.backButton);
        protein = findViewById(R.id.protein);
        fats = findViewById(R.id.fats);
        carb = findViewById(R.id.carb);
        proteinInfo = findViewById(R.id.proteininformation);
        fatInfo = findViewById(R.id.fatinformation);
        carbInfo = findViewById(R.id.carbinformation);

        //capture Button clicks
        back.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent aintent = new Intent(FoodTypeNavActivity.this, CartActivity.class);
                startActivity(aintent);
            }
        });
        protein.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent cintent = new Intent(FoodTypeNavActivity.this, ViewProtein.class);
                startActivity(cintent);
            }
        });
        fats.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent dintent = new Intent(FoodTypeNavActivity.this, ViewFats.class);
                startActivity(dintent);
            }
        });
        carb.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent eintent = new Intent(FoodTypeNavActivity.this, ViewCarbs.class);
                startActivity(eintent);
            }
        });
        //capture ImageButton clicks
        proteinInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openDiaPro();
            }
        });
        fatInfo.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                openDiaFat();
            }
        });
        carbInfo.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                openDiaCarb();
            }
        });

    }
    //start info dialog fats
    public void openDiaFat(){
        FatFragment body = new FatFragment();
        body.show(getSupportFragmentManager(), "test");
    }

    //start info dialog protein
    public void openDiaPro(){
        ProteinFragment body = new ProteinFragment();
        body.show(getSupportFragmentManager(), "test");
    }

    //start info dialog carbs
    public void openDiaCarb(){
        CarbFragment body = new CarbFragment();
        body.show(getSupportFragmentManager(), "test");
    }
}

