package com.trapero.todolist;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.ListView;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ItemAdapter adapter;
    private List<String> items;
    private int editPosition = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView listView = findViewById(R.id.listView);
        EditText editText = findViewById(R.id.editText);

        items = new ArrayList<>();
        adapter = new ItemAdapter(this, items);
        listView.setAdapter(adapter);

        editText.setOnEditorActionListener((v, actionId, event) -> {
            String newItem = editText.getText().toString();
            if (!newItem.isEmpty()) {
                if (editPosition == -1) {
                    items.add(newItem);
                } else {
                    items.set(editPosition, newItem);
                    editPosition = -1;
                }
                adapter.notifyDataSetChanged();
                editText.setText("");
            }
            return true;
        });

        listView.setOnItemLongClickListener((parent, view, position, id) -> true);
    }
}