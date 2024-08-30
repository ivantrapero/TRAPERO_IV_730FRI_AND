package com.trapero.calculator;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;
import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    private EditText display;
    private String current = "";
    private String previous = "";
    private String operator = "";
    private boolean isOperatorClicked = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        display = findViewById(R.id.display);

        setNumberButtonListeners();
        setOperatorButtonListeners();
    }

    private void setNumberButtonListeners() {
        View.OnClickListener numberListener = view -> {
            Button button = (Button) view;
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
            findViewById(id).setOnClickListener(numberListener);
        }
    }

    private void setOperatorButtonListeners() {
        View.OnClickListener operatorListener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Button button = (Button) view;
                if (!current.isEmpty()) {
                    previous = current;
                    operator = button.getText().toString();
                    isOperatorClicked = true;
                }
            }
        };

        int[] operatorButtonIds = {
                R.id.buttonAdd, R.id.buttonSubtract, R.id.buttonMultiply, R.id.buttonDivide
        };

        for (int id : operatorButtonIds) {
            findViewById(id).setOnClickListener(operatorListener);
        }

        findViewById(R.id.buttonEqual).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
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
            }
        });

        findViewById(R.id.eraseButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                current = "";
                previous = "";
                operator = "";
                display.setText("");
            }
        });
    }

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
