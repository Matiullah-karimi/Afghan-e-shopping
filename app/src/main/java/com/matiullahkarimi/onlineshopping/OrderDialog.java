package com.matiullahkarimi.onlineshopping;

import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

/**
 * Created by Karimi on 10/22/2016.
 */
public class OrderDialog extends DialogFragment {
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        // Get the layout inflater
        LayoutInflater inflater = getActivity().getLayoutInflater();

        View modifyView = inflater.inflate(R.layout.custom_dialog, null);

            Spinner colorSpinner = (Spinner) modifyView.findViewById(R.id.spinner_color);
            Spinner sizeSpinner = (Spinner) modifyView.findViewById(R.id.spinner_size);

            // Create an ArrayAdapter using the string array and a default spinner layout
            ArrayAdapter<CharSequence> colorAdapter = ArrayAdapter.createFromResource(getActivity(),
                    R.array.colors, android.R.layout.simple_spinner_item);
            // Specify the layout to use when the list of choices appears
            colorAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            // Apply the adapter to the spinner
            colorSpinner.setAdapter(colorAdapter);

            // Create an ArrayAdapter using the string array and a default spinner layout
            ArrayAdapter<CharSequence> sizeAdapter = ArrayAdapter.createFromResource(getActivity(),
                    R.array.sizes, android.R.layout.simple_spinner_item);
            // Specify the layout to use when the list of choices appears
            sizeAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            // Apply the adapter to the spinner
            sizeSpinner.setAdapter(sizeAdapter);

        // Inflate and set the layout for the dialog
        // Pass null as the parent view because its going in the dialog layout
        builder.setView(modifyView)
                // Add action buttons
                .setPositiveButton("Order", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int id) {
                        // sign in the user ...
                    }
                })
                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.dismiss();
                    }
                });
        return builder.create();
    }
}