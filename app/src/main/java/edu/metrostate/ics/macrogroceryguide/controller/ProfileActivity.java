package edu.metrostate.ics.macrogroceryguide.controller;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import edu.metrostate.ics.macrogroceryguide.R;
import edu.metrostate.ics.macrogroceryguide.model.GroceryGuide;
import edu.metrostate.ics.macrogroceryguide.model.User;

/**
 * Activity to serve as basis for res/layout/activity_profile.xml
 * @author Macro Grocery Guide Group 4
 */
public class ProfileActivity extends AppCompatActivity {

    //view items
    private Button editWeight;
    private Button nav;
    private TextView nameTextView;
    private TextView dCalTotals;
    private TextView dProtTotals;
    private TextView dFatsTotals;
    private TextView dCarbsTotals;
    private TextView wCalTotals;
    private TextView wProtTotals;
    private TextView wFatsTotals;
    private TextView wCarbsTotals;
    private TextView subCalTotals;
    private TextView subProtTotals;
    private TextView subFatsTotals;
    private TextView subCarbsTotals;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        //find daily macro totals text view
        dCalTotals = findViewById(R.id.dCaloriesTotalTextView);
        dProtTotals = findViewById(R.id.dProteinTotalTextView);
        dFatsTotals = findViewById(R.id.dFatsTotalTextView);
        dCarbsTotals = findViewById(R.id.dCarbsTotalTextView);

        //set text for macro totals text view
        dCalTotals.setText(String.valueOf(User.getInstance().getMacroTotals().getTotalCals()));
        dProtTotals.setText(String.valueOf(User.getInstance().getMacroTotals().getTotalProteinGrams()));
        dFatsTotals.setText(String.valueOf(User.getInstance().getMacroTotals().getTotalFatGrams()));
        dCarbsTotals.setText(String.valueOf(User.getInstance().getMacroTotals().getTotalCarbGrams()));

        //find macro totals text view
        wCalTotals = findViewById(R.id.wCaloriesTotalTextView);
        wProtTotals = findViewById(R.id.wProteinTotalTextView);
        wFatsTotals = findViewById(R.id.wFatsTotalTextView);
        wCarbsTotals = findViewById(R.id.wCarbsTotalTextView);

        //set text for macro totals text view
        wCalTotals.setText(String.valueOf(User.getInstance().getMacroTotals().getWeeklyTotalCals()));
        wProtTotals.setText(String.valueOf(User.getInstance().getMacroTotals().getWeeklyTotalProteinGrams()));
        wFatsTotals.setText(String.valueOf(User.getInstance().getMacroTotals().getWeeklyTotalFatGrams()));
        wCarbsTotals.setText(String.valueOf(User.getInstance().getMacroTotals().getWeeklyTotalCarbGrams()));

        //find running macro totals text views
        subCalTotals = findViewById(R.id.subCaloriesTotalTextView);
        subProtTotals = findViewById(R.id.subProteinTotalTextView);
        subFatsTotals = findViewById(R.id.subFatsTotalTextView);
        subCarbsTotals = findViewById(R.id.subCarbsTotalsTextView);

        //set text for runnning totals
        subCalTotals.setText(String.valueOf(GroceryGuide.getInstance().getCalories()));
        subProtTotals.setText(String.valueOf(GroceryGuide.getInstance().getProteinGrams()));
        subFatsTotals.setText(String.valueOf(GroceryGuide.getInstance().getFatsGrams()));
        subCarbsTotals.setText(String.valueOf(GroceryGuide.getInstance().getCarbsGrams()));

        //locate nameTextView and set text
        nameTextView = findViewById(R.id.nameTextView);
        nameTextView.setText(User.getInstance().getFirstName());

        //locate editWeight button and capture clicks
        editWeight = findViewById(R.id.weightEditText);
        editWeight.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent bintent = new Intent(ProfileActivity.this, EditAssessmentActivity.class);
                startActivity(bintent);
            }
        });
        //locate nav button and capture clicks
        nav = findViewById(R.id.nav);
        nav.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent cintent = new Intent(ProfileActivity.this, MainNavActivity.class);
                startActivity(cintent);
            }
        });
    }

}
