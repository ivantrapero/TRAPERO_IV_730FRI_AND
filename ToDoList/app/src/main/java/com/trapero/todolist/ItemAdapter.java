package com.trapero.todolist;

import android.app.AlertDialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class ItemAdapter extends ArrayAdapter<String> {

    private final Context context;
    private final List<String> items;

    public ItemAdapter(Context context, List<String> items) {
        super(context, 0, items);
        this.context = context;
        this.items = items;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.list_item, parent, false);
        }

        TextView itemText = convertView.findViewById(R.id.item_text);
        ImageView itemImage = convertView.findViewById(R.id.item_image);
        CheckBox itemCheckbox = convertView.findViewById(R.id.item_checkbox);

        String currentItem = getItem(position);
        itemText.setText(currentItem);

        itemText.setOnLongClickListener(v -> {
            showEditDeleteDialog(position);
            return true;
        });

        return convertView;
    }

    private void showEditDeleteDialog(int position) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle("Edit or Delete Item")
                .setPositiveButton("Edit", (dialog, which) -> showEditDialog(position))
                .setNegativeButton("Delete", (dialog, which) -> {
                    items.remove(position);
                    notifyDataSetChanged();
                    Toast.makeText(context, "Item deleted", Toast.LENGTH_SHORT).show();
                })
                .show();
    }

    private void showEditDialog(int position) {
        AlertDialog.Builder editDialogBuilder = new AlertDialog.Builder(context);
        EditText input = new EditText(context);
        input.setText(items.get(position));

        editDialogBuilder.setTitle("Edit Item")
                .setView(input)
                .setPositiveButton("Save", (editDialog, whichButton) -> {
                    String updatedText = input.getText().toString();
                    if (!updatedText.isEmpty()) {
                        items.set(position, updatedText);
                        notifyDataSetChanged();
                    }
                })
                .setNegativeButton("Cancel", null)
                .show();
    }
}