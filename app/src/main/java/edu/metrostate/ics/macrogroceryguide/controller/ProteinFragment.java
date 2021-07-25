package edu.metrostate.ics.macrogroceryguide.controller;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatDialogFragment;
/**
 * Alert Dialog fragment displays message after openDiaPro() is called from
 * FoodTypeNavActivity.java class.
 * @author Macro Grocery Guide Group 4
 */

public class ProteinFragment extends AppCompatDialogFragment {
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState){
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle("Protein information")
                .setMessage("Protein provide 4 calories per gram" +
                        "\n"+"When choosing protein, be sure to select organic lean meats such as wild caught fish, free-range chicken, grass-fed beef, or plant sources such as nuts, seeds and beans. Limit your intake of processed proteins high in saturated fat such as conventional red meat, bacon, sausage, deli meats and hot dogs."+
                        "\n"+"https://www.prospectmedical.com/resources/wellness-center/macronutrients-fats-carbs-protein")
                .setPositiveButton("ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                });
        return builder.create();

    }
}

