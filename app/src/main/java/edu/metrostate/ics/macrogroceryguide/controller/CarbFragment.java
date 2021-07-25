package edu.metrostate.ics.macrogroceryguide.controller;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatDialogFragment;

/**
 * Alert Dialog fragment displays message after openDiaCarb() is called from
 * FoodTypeNavActivity.java class.
 * @author Macro Grocery Guide Group 4
 */

public class CarbFragment extends AppCompatDialogFragment {
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState){
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle("Carb information")
                .setMessage("Carbohydrates provide 4 calories per gram" +
                        "\n"+"The healthiest sources of carbohydrates—unprocessed or minimally processed starches such as potatoes or yams, vegetables, fruits and beans.  They promote good health by delivering vitamins, minerals, fiber, and a host of important nutrients. Unhealthier sources of carbohydrates include breads, pasta, pastries, sodas, and other processed or refined foods.  These items contain quickly digested carbohydrates that have a high glycemic index; which contributes to weight gain, hormone imbalance, diabetes and heart disease. Your goal should be to eat whole food sources of carbohydrates such as vegetables, legumes and some fruit."+
                        "\n"+"https://www.prospectmedical.com/resources/wellness-center/macronutrients-fats-carbs-protein")
                .setPositiveButton("ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                });
        return builder.create();

    }
}

