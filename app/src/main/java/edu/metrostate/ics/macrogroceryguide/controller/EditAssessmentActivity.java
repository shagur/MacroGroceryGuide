package edu.metrostate.ics.macrogroceryguide.controller;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import edu.metrostate.ics.macrogroceryguide.R;
import edu.metrostate.ics.macrogroceryguide.model.Assessment;
import edu.metrostate.ics.macrogroceryguide.model.MacroTotals;
import edu.metrostate.ics.macrogroceryguide.model.User;

/**
 * Activity serves as the basis for res/layout/activity_edit_assessment.xml.
 * @author Macro Grocery Guide Group 4
 */
public class EditAssessmentActivity extends AppCompatActivity {

    //view items
    private Button back;
    private Button confirm;
    private EditText ageText;
    private EditText heightText;
    private EditText weightText;
    private User.Gender gender;
    //variables
    private double pal;
    private int age; //in years
    private double height; //in cm
    private double weight; //in kg
    private int goalChoice;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_assessment);

        //locate edit text boxes
        ageText = (EditText)findViewById(R.id.ageEditText);
        heightText = (EditText)findViewById(R.id.heightEditText);
        weightText = (EditText)findViewById(R.id.weightEditText);

        //locate RadioButtons
        RadioButton lose = (RadioButton)findViewById(R.id.loseRadioButton);
        RadioButton maintain = (RadioButton)findViewById(R.id.maintainRadioButton);
        RadioButton gain = (RadioButton)findViewById(R.id.gainRadioButton);
        //capture goal radio group button clicks
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
        //locate physical activity level radio buttons
        RadioButton sedentaryRadioButton = (RadioButton) findViewById(R.id.sedentaryRadioButton);
        RadioButton lightActiveRadioButton = (RadioButton) findViewById(R.id.lightActiveRadioButton);
        RadioButton modActiveRadioButton = (RadioButton) findViewById(R.id.modActiveRadioButton);
        RadioButton heavyActiveRadioButton = (RadioButton) findViewById(R.id.heavyActiveRadioButton);
        //capture clicks for pal radio buttons
        sedentaryRadioButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean checked = ((RadioButton) v).isChecked();
                if(checked){
                    pal = 1.2;
                }
            }
        });
        lightActiveRadioButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean checked = ((RadioButton) v).isChecked();
                if(checked){
                    pal = 1.375;
                }
            }
        });
        modActiveRadioButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean checked = ((RadioButton) v).isChecked();
                if(checked){
                    pal = 1.55;
                }
            }
        });
        heavyActiveRadioButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean checked = ((RadioButton) v).isChecked();
                if(checked){
                    pal = 1.725;
                }
            }
        });

        //locate buttons
        back = findViewById(R.id.backButton);
        confirm = findViewById(R.id.nextButton);
        //capture button clicks
        back.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent aintent = new Intent(EditAssessmentActivity.this, ProfileActivity.class);
                startActivity(aintent);
            }
        });
        confirm.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                //get values from edit text boxes
                if(ageText != null){
                    age = Integer.parseInt(ageText.getText().toString());
                }else{
                    Toast.makeText(getApplicationContext(), "Input an age", Toast.LENGTH_LONG).show();
                }
                if(heightText != null){
                    height = Double.parseDouble(heightText.getText().toString());
                    //convert from inches to cm
                    height = (height * 2.54);
                }else{
                    Toast.makeText(getApplicationContext(), "Input your height", Toast.LENGTH_LONG).show();
                }
                if(weightText != null){
                    weight = Double.parseDouble(weightText.getText().toString());
                    //convert weight from lbs to kg and round to 2 decimal points
                    weight = Math.round((weight * 0.453592) * 100.00) / 100.00;
                }else{
                    Toast.makeText(getApplicationContext(), "Input your weight", Toast.LENGTH_LONG).show();
                }
                //get gender from the user
                gender = User.getInstance().getAssesment().getGen();
                //create new assessment
                Assessment nAssessment = new Assessment(gender, age, height, weight, pal);
                //save to the user
                User.getInstance().setAssesment(nAssessment);
                //get tdee value and goal to calculate macro totals
                MacroTotals nMTotals = new MacroTotals(User.getInstance()
                        .getAssesment().getTdeeResult(), goalChoice);
                //set Users  New Macro Totals
                User.getInstance().setMacroTotals(nMTotals);
                //start new activity
                Intent bintent = new Intent(EditAssessmentActivity.this, ProfileActivity.class);
                startActivity(bintent);
            }
        });
    }
}
