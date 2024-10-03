package com.trapero.bottomnav;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import java.text.DecimalFormat;

public class CalculatorFragment extends Fragment {

    private EditText display;
    private String current = "";
    private String previous = "";
    private String operator = "";
    private boolean isOperatorClicked = false;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.activity_main_calcu, container, false);

        display = view.findViewById(R.id.display);

        setNumberButtonListeners(view);
        setOperatorButtonListeners(view);

        return view;
    }

    private void setNumberButtonListeners(View view) {
        View.OnClickListener numberListener = v -> {
            Button button = (Button) v;
            if (isOperatorClicked) {
                current = "";
                isOperatorClicked = false;
            }
            String buttonText = button.getText().toString();
            if (buttonText.equals(".") && current.contains(".")) {
                return;
            }
            current += buttonText;
            display.setText(current);
        };

        int[] numberButtonIds = {
                R.id.button0, R.id.button1, R.id.button2, R.id.button3,
                R.id.button4, R.id.button5, R.id.button6, R.id.button7,
                R.id.button8, R.id.button9, R.id.buttonDot
        };

        for (int id : numberButtonIds) {
            view.findViewById(id).setOnClickListener(numberListener);
        }
    }

    @SuppressLint("SetTextI18n")
    private void setOperatorButtonListeners(View view) {
        View.OnClickListener operatorListener = v -> {
            Button button = (Button) v;
            if (!current.isEmpty()) {
                previous = current;
                operator = button.getText().toString();
                isOperatorClicked = true;
            }
        };

        int[] operatorButtonIds = {
                R.id.buttonAdd, R.id.buttonSubtract, R.id.buttonMultiply, R.id.buttonDivide
        };

        for (int id : operatorButtonIds) {
            view.findViewById(id).setOnClickListener(operatorListener);
        }

        view.findViewById(R.id.buttonEqual).setOnClickListener(v -> {
            if (!previous.isEmpty() && !current.isEmpty() && !operator.isEmpty()) {
                try {
                    double result = calculate(Double.parseDouble(previous), Double.parseDouble(current), operator);
                    display.setText(formatResult(result));
                    current = formatResult(result);
                    previous = "";
                    operator = "";
                } catch (NumberFormatException e) {
                    display.setText("Error");
                }
            }
        });

        view.findViewById(R.id.eraseButton).setOnClickListener(v -> {
            current = "";
            previous = "";
            operator = "";
            display.setText("");
        });
    }

    @SuppressLint("SetTextI18n")
    private double calculate(double a, double b, String operator) {
        switch (operator) {
            case "+":
                return a + b;
            case "-":
                return a - b;
            case "*":
                return a * b;
            case "/":
                if (b != 0) {
                    return a / b;
                } else {
                    display.setText("Error");
                    return 0;
                }
            default:
                return 0;
        }
    }

    private String formatResult(double result) {
        DecimalFormat decimalFormat = new DecimalFormat("0.00");
        return decimalFormat.format(result);
    }
}
