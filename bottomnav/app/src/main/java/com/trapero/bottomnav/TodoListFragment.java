package com.trapero.bottomnav;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ListView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import java.util.ArrayList;
import java.util.List;

public class TodoListFragment extends Fragment {

    private TODOItemAdapter adapter;
    private List<String> items;
    private int editPosition = -1;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.activity_main_todo, container, false);

        ListView listView = view.findViewById(R.id.listView);
        EditText editText = view.findViewById(R.id.editText);

        items = new ArrayList<>();
        adapter = new TODOItemAdapter(getContext(), items);
        listView.setAdapter(adapter);

        // Set editor action listener to handle adding and editing items
        editText.setOnEditorActionListener((v, actionId, event) -> {
            String newItem = editText.getText().toString();
            if (!newItem.isEmpty()) {
                if (editPosition == -1) {
                    // Add new item
                    items.add(newItem);
                } else {
                    // Edit existing item
                    items.set(editPosition, newItem);
                    editPosition = -1;
                }
                adapter.notifyDataSetChanged();  // Notify adapter that data has changed
                editText.setText("");  // Clear the EditText
            }
            return true;
        });

        // Set long click listener to edit items
        listView.setOnItemLongClickListener((parent, view1, position, id) -> {
            // Set the current item to edit
            editPosition = position;
            editText.setText(items.get(position));
            return true;
        });

        return view;
    }
}
