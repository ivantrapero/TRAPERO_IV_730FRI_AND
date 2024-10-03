package com.trapero.menu;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import java.util.Objects;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Set up the toolbar
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        Objects.requireNonNull(getSupportActionBar()).setTitle("Dish Menu");
        getSupportActionBar().setSubtitle("Pili na mga Suki");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle menu item clicks without switch-case
        if (item.getItemId() == R.id.action_go_to_fragment) {
            loadFragment(new AnotherFragment());
            return true;
        } else if (item.getItemId() == R.id.action_show_dialog) {
            showDialog();
            return true;
        } else if (item.getItemId() == R.id.action_sub_menu) {
            // Handle sub menu action here if needed
            return true;
        } else if (item.getItemId() == R.id.action_exit) {
            finish(); // Exit the app
            return true;
        } else {
            return super.onOptionsItemSelected(item);
        }
    }

    public void onDishClick(View view) {
        Toast.makeText(this, "Dish clicked!", Toast.LENGTH_SHORT).show();
    }

    private void loadFragment(AnotherFragment fragment) {
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.toolbar, fragment)
                .addToBackStack(null)
                .commit();
    }

    private void showDialog() {
        MyDialogFragment dialog = new MyDialogFragment();
        dialog.show(getSupportFragmentManager(), "MyDialog");
    }
}
