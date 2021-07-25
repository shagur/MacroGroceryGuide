package edu.metrostate.ics.macrogroceryguide.controller;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatDialogFragment;
/**
 * Alert Dialog fragment displays message after openDiaFat() is called from
 * FoodTypeNavActivity.java class.
 * @author Macro Grocery Guide Group 4
 */
public class FatFragment extends AppCompatDialogFragment {
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState){
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        builder.setTitle("fats information")
                .setMessage("fats provide 9  calories per gram" +
                        "\n"+"Omega’s 3, 6 and 9 fats are what’s known as Essential Fatty Acids, or “EFA’s”. Similar to essential amino acids, your body can’t produce them by itself so you have to obtain them through your diet. Omega-3 fats can be found in fatty fish such as salmon, avocados, flax, fish oil and walnuts (note that they’re better absorbed from animal sources), and omega-6 fats from pretty much all kinds of vegetable oil, such as flaxseed oil, grapeseed oil, sunflower seeds, and pine nuts.  The goal is to increase the amount of Omega 3’s and limit the amount of Omega 6’s in your diet."+
                        "\n"+"https://www.prospectmedical.com/resources/wellness-center/macronutrients-fats-carbs-protein")
                .setPositiveButton("ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                });
        return builder.create();

    }
}
