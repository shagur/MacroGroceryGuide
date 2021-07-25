package edu.metrostate.ics.macrogroceryguide.controller;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.Toast;

import edu.metrostate.ics.macrogroceryguide.R;
import edu.metrostate.ics.macrogroceryguide.model.Assessment;
import edu.metrostate.ics.macrogroceryguide.model.User;
/**
 * Activity to serve as basis for res/layout/activity_body_information.xml
 * @author Macro Grocery Guide Group 4
 */

public class BodyInformationActivity extends AppCompatActivity {

    //define view items
    private Button next;
    private EditText ageText;
    private EditText heightText;
    private EditText weightText;
    private ImageButton bodyInfoDialogBtn;
    private User.Gender gender = User.Gender.F;
    private double pal = 1.5;
    private int age; //in years
    private double height; //in cm
    private double weight; //in kg


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_body_information);

        //locate body information dialog button
        bodyInfoDialogBtn = (ImageButton)findViewById(R.id.bodyinformation);
        //capture clicks
        bodyInfoDialogBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openDia();
            }
        });

        //locate Edit Text boxes
        ageText = (EditText) findViewById(R.id.ageEditText);
        heightText = (EditText) findViewById(R.id.heightEditText);
        weightText = (EditText) findViewById(R.id.weightEditText);

        //locate male radio button
        RadioButton maleRadioButton = (RadioButton) findViewById(R.id.maleRadioButton);
        //capture clicks male radio button
        maleRadioButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean checked = ((RadioButton)v).isChecked();
                if(checked){
                    gender = User.Gender.M;
                }
            }
        });
        //locate female radio button
        RadioButton femaleRadioButton = (RadioButton) findViewById(R.id.femaleRadioButton);
        //capture clicks female radio button
        femaleRadioButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean checked = ((RadioButton)v).isChecked();
                if(checked){
                    gender = User.Gender.F;
                }
            }
        });
        //locate physical activity level radio buttons
        RadioButton sedentaryRadioButton = (RadioButton) findViewById(R.id.sedentaryRadioButton);
        RadioButton lightActiveRadioButton = (RadioButton) findViewById(R.id.lightActiveRadioButton);
        RadioButton modActiveRadioButton = (RadioButton) findViewById(R.id.modActiveRadioButton);
        RadioButton heavyActiveRadioButton = (RadioButton) findViewById(R.id.heavyActiveRadioButton);
        //capture click for pal radio buttons
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

        //locate submitBtn
        next = findViewById(R.id.nextButton);
        //capture submitBtn clicks
        next.setOnClickListener(new View.OnClickListener(){
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
                    weight = Math.round(((weight * 0.453592) * 100.00) / 100.00);
                }else{
                    Toast.makeText(getApplicationContext(), "Input your weight", Toast.LENGTH_LONG).show();
                }

                //create an assessment object and associate it with the user
                Assessment assessment = new Assessment(gender, age, height, weight, pal);
                User.getInstance().setAssesment(assessment);
                Intent aintent = new Intent(BodyInformationActivity.this, GoalSetterActivity.class);
                startActivity(aintent);
            }
        });

    }
    //start info dialog fragment
    public void openDia(){
        BodyInfoFragment body = new BodyInfoFragment();
        body.show(getSupportFragmentManager(), "test");
    }



}