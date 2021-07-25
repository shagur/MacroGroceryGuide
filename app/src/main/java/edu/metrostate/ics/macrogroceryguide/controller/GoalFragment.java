package edu.metrostate.ics.macrogroceryguide.controller;


import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatDialogFragment;

/**
 * Alert Dialog displays message after openDia() is called from GoalSetterActivity.java class.
 * @author Macro Grocery Guide Group 4
 */
public class GoalFragment extends AppCompatDialogFragment {
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState){
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle("Information")
                .setMessage("Because 3,500 calories equals about 1 pound (0.45 kilogram) of fat, it's estimated that you need to burn about 3,500 calories to lose 1 pound.\n" +
                        "\n" +
                        "So, in general, if you cut about 500 to 1,000 calories a day from your typical diet, you'd lose about 1 to 2 pounds a week." +
                        "\n"+ "Our goals are set to meet +1lb per week or -1lb per week"+
                        "\n"+ "https://www.mayoclinic.org/healthy-lifestyle/weight-loss/in-depth/calories/art-20048065#:~:text=Tipping%20the%20scale&text=Because%203%2C500%20calories%20equals%20about,to%202%20pounds%20a%20week.")
                .setPositiveButton("ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                });
        return builder.create();

    }
}

