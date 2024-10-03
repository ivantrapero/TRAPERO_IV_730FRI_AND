package com.trapero.bottomnav;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class BottomMainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_bottomnav);

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Fragment selectedFragment = null;

                // Determine which fragment to show using if-else
                if (item.getItemId() == R.id.navigation_calculator) {
                    selectedFragment = new CalculatorFragment();
                } else if (item.getItemId() == R.id.navigation_profile) {
                    selectedFragment = new ProfileFragment();
                } else if (item.getItemId() == R.id.navigation_todo) {
                    selectedFragment = new TodoListFragment();
                }

                // Replace the current fragment if a valid fragment is selected
                if (selectedFragment != null) {
                    getSupportFragmentManager().beginTransaction()
                            .replace(R.id.fragment_container, selectedFragment)
                            .commit();
                }

                return true;
            }
        });

        // Set the default fragment to profile
        bottomNavigationView.setSelectedItemId(R.id.navigation_profile);
    }
}
