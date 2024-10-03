package com.trapero.bottomnav;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class ProfileFragment extends Fragment {

    private EditText editTextName;
    private EditText editTextEmail;
    private RadioGroup radioGroupGender;
    private CheckBox checkBoxNewsletter;
    private Button buttonSave;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_profile, container, false);

        // Initialize views
        editTextName = view.findViewById(R.id.editTextName);
        editTextEmail = view.findViewById(R.id.editTextEmail);
        radioGroupGender = view.findViewById(R.id.radioGroupGender);
        checkBoxNewsletter = view.findViewById(R.id.checkBoxNewsletter);
        buttonSave = view.findViewById(R.id.buttonSave);

        // Set button click listener
        buttonSave.setOnClickListener(v -> saveProfileData());

        return view;
    }

    private void saveProfileData() {
        // Get user input from the fields
        String name = editTextName.getText().toString();
        String email = editTextEmail.getText().toString();
        boolean isSubscribed = checkBoxNewsletter.isChecked();

        // Get selected gender from the RadioGroup
        int selectedGenderId = radioGroupGender.getCheckedRadioButtonId();
        String gender = "";
        if (selectedGenderId != -1) {
            RadioButton selectedGender = getView().findViewById(selectedGenderId);
            gender = selectedGender.getText().toString();
        }

        // Perform your data saving logic here (e.g., SharedPreferences, database)
        // For now, just show a Toast message with the data
        String message = "Saved";
        Toast.makeText(getContext(), message, Toast.LENGTH_LONG).show();
    }
}
