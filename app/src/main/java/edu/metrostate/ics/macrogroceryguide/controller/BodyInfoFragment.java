package edu.metrostate.ics.macrogroceryguide.controller;

import androidx.appcompat.app.AppCompatDialogFragment;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;

/**
 * Alert Dialog fragment displays message after openDia is called from
 * BodyInformationActivity.java class.
 * @author Macro Grocery Guide Group 4
 */


public class BodyInfoFragment extends AppCompatDialogFragment {
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState){
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle("This information helps us calculate you TDEE")
                .setMessage("Your Total Daily Energy Expenditure (TDEE) is an estimation of how many calories you burn per day when exercise is taken into account. It is calculated by first figuring out your Basal Metabolic Rate, then multiplying that value by an activity multiplier."
                        +"\n" + "https://tdeecalculator.net/#:~:text=Your%20Total%20Daily%20Energy%20Expenditure%20(TDEE)%20is%20an%20estimation%20of,value%20by%20an%20activity%20multiplier.")
                .setPositiveButton("ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                });
        return builder.create();

    }
}
