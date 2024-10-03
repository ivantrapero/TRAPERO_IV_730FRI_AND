package com.trapero.menu;

import android.app.Dialog;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.DialogFragment;

public class MyDialogFragment extends DialogFragment {

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        // Build the dialog using AlertDialog.Builder
        AlertDialog.Builder builder = new AlertDialog.Builder(requireActivity());
        builder.setTitle("Title sa Dialog kay Dialog") // Set the title
                .setMessage("Dialog ni.") // Set the message
                .setPositiveButton("Goods?", (dialog, id) -> {
                    // User clicked OK button
                    // You can perform any action you want here
                })
                .setNegativeButton("Cancel", (dialog, id) -> {
                    // User cancelled the dialog
                    dialog.dismiss(); // Dismiss the dialog
                });
        return builder.create(); // Create and return the AlertDialog
    }
}
