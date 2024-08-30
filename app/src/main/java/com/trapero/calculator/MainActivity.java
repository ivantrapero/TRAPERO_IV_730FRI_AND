package com.trapero.calculator;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;
import java.text.DecimalFormat;


public class MainActivity extends AppCompatActivity {

    private EditText display;
    private String current, previous, operator;
    private boolean isOperatorClicked;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        display = findViewById(R.id.display);
        current = "";
        previous = "";
        operator = "";
        isOperatorClicked = false;

        setNumberButtonListeners();
        setOperatorButtonListeners();
    }

    private void setNumberButtonListeners() {
        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Button button = (Button) view;
                if (isOperatorClicked) {
                    current = "";
                    isOperatorClicked = false;
                }
                current += button.getText().toString();
                display.setText(current);
            }
        };

        findViewById(R.id.button0).setOnClickListener(listener);
        findViewById(R.id.button1).setOnClickListener(listener);
        findViewById(R.id.button2).setOnClickListener(listener);
        findViewById(R.id.button3).setOnClickListener(listener);
        findViewById(R.id.button4).setOnClickListener(listener);
        findViewById(R.id.button5).setOnClickListener(listener);
        findViewById(R.id.button6).setOnClickListener(listener);
        findViewById(R.id.button7).setOnClickListener(listener);
        findViewById(R.id.button8).setOnClickListener(listener);
        findViewById(R.id.button9).setOnClickListener(listener);
        findViewById(R.id.buttonDot).setOnClickListener(listener);
    }

    private void setOperatorButtonListeners() {
        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Button button = (Button) view;
                if (!current.equals("")) {
                    previous = current;
                    operator = button.getText().toString();
                    isOperatorClicked = true;
                }
            }
        };

        findViewById(R.id.buttonAdd).setOnClickListener(listener);
        findViewById(R.id.buttonSubtract).setOnClickListener(listener);
        findViewById(R.id.buttonMultiply).setOnClickListener(listener);
        findViewById(R.id.buttonDivide).setOnClickListener(listener);

        findViewById(R.id.buttonEqual).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!previous.equals("") && !current.equals("") && !operator.equals("")) {
                    double result = calculate(Double.parseDouble(previous), Double.parseDouble(current), operator);
                    display.setText(formatResult(result));
                    current = formatResult(result);
                    previous = "";
                    operator = "";
                }
            }
        });

        findViewById(R.id.buttonClear).setOnClickListener(new View.OnClickListener() {
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
                    return 0; // Avoid division by zero
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