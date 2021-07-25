package edu.metrostate.ics.macrogroceryguide.controller;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.RadioButton;

import edu.metrostate.ics.macrogroceryguide.R;
import edu.metrostate.ics.macrogroceryguide.model.MacroTotals;
import edu.metrostate.ics.macrogroceryguide.model.User;

/**
 * Activity to serve as basis for res/layout/activity_goal_setter.xml
 * @author Macro Grocery Guide Group 4
 */
public class GoalSetterActivity extends AppCompatActivity {
    //view items
    private Button next;
    private int goalChoice;
    private ImageButton goalInfoBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_goal_setter);

        //locate  info ImageButton button
        goalInfoBtn = (ImageButton)findViewById(R.id.goalInformation);
        goalInfoBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openDia();
            }
        });

        //locate RadioButtons
        RadioButton lose = (RadioButton)findViewById(R.id.loseRadioButton);
        RadioButton maintain = (RadioButton)findViewById(R.id.maintainRadioButton);
        RadioButton gain = (RadioButton)findViewById(R.id.gainRadioButton);
        //capture RadioButton clicks
        lose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean checked = ((RadioButton) v).isChecked();
                if(checked){
                    goalChoice = 0;
                }
            }
        });
        maintain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean checked = ((RadioButton) v).isChecked();
                if(checked){
                    goalChoice = 1;
                }
            }
        });
        gain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean checked = ((RadioButton) v).isChecked();
                if(checked){
                    goalChoice = 2;
                }
            }
        });

        //locate next button
        next = findViewById(R.id.nextButton);
        //capture next button clicks
        next.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){

                //get tdee value and goal to calculate macro totals
                MacroTotals mTotals = new MacroTotals(User.getInstance()
                        .getAssesment().getTdeeResult(), goalChoice);
                //set Users Macro Totals
                User.getInstance().setMacroTotals(mTotals);
                //start new Activity
                Intent aintent = new Intent(GoalSetterActivity.this, CartActivity.class);
                startActivity(aintent);
            }
        });

    }
    //start info dialog
    public void openDia(){
        GoalFragment body = new GoalFragment();
        body.show(getSupportFragmentManager(), "test");
    }
}

