package com.example.cis436calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import static java.lang.Math.*;

public class MainActivity extends AppCompatActivity {

    Button b_0, b_1, b_2, b_3, b_4, b_5, b_6, b_7, b_8, b_9, b_clr, b_ce, b_sqrt, b_mod, b_plus, b_sub, b_mult, b_div, b_equal, b_dot, b_neg;
    TextView disp;
    double storedValue = 0;
    String operationToPerform = "";

    public void assignViews(){
        disp = findViewById(R.id.display);

        b_0 = findViewById(R.id.button_0);
        b_1 = findViewById(R.id.button_1);
        b_2 = findViewById(R.id.button_2);
        b_3 = findViewById(R.id.button_3);
        b_4 = findViewById(R.id.button_4);
        b_5 = findViewById(R.id.button_5);
        b_6 = findViewById(R.id.button_6);
        b_7 = findViewById(R.id.button_7);
        b_8 = findViewById(R.id.button_8);
        b_9 = findViewById(R.id.button_9);
        b_clr = findViewById(R.id.button_clear);
        b_ce = findViewById(R.id.button_ce);
        b_sqrt = findViewById(R.id.button_sqrt);
        b_mod = findViewById(R.id.button_mod);
        b_plus = findViewById(R.id.button_plus);
        b_sub = findViewById(R.id.button_sub);
        b_mult = findViewById(R.id.button_mult);
        b_div = findViewById(R.id.button_div);
        b_equal = findViewById(R.id.button_equal);
        b_dot = findViewById(R.id.button_dot);
        b_neg = findViewById(R.id.button_negative);
    }

    public void performPreviousOp(){
        if(!operationToPerform.equals("") && !disp.getText().toString().equals("")) {
            double newInput = Double.parseDouble(disp.getText().toString());

            switch (operationToPerform) {
                case "%":
                    storedValue %= newInput;
                    break;
                case "/":
                    storedValue /= newInput;
                    break;
                case "*":
                    storedValue *= newInput;
                    break;
                case "-":
                    storedValue -= newInput;
                    break;
                case "+":
                    storedValue += newInput;
                    break;
                default:
                    disp.setText("ERROR");
                    break;
            }
        }
        else{
            disp.setText("");
        }
    }

    public boolean isDispFull(){
        return disp.length() == 9;
    }

    public static String formatDecimals(double result)
    {
        if(result == (long) result) {
            return String.format("%d", (long) result);
        }
        else {
            return String.format("%s", result);
        }
    }

    public void clearLeadingZero(){
        String leading = disp.getText().toString();
        if (leading.equals("0")) {
            disp.setText("");
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        assignViews();

        b_0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!isDispFull()){
                    clearLeadingZero();
                    disp.append("0");
                }
            }
        });

        b_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!isDispFull()){
                    clearLeadingZero();
                    disp.append("1");
                }
            }
        });

        b_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!isDispFull()){
                    clearLeadingZero();
                    disp.append("2");
                }
            }
        });

        b_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!isDispFull()){
                    clearLeadingZero();
                    disp.append("3");
                }
            }
        });

        b_4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!isDispFull()){
                    clearLeadingZero();
                    disp.append("4");
                }
            }
        });

        b_5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!isDispFull()){
                    clearLeadingZero();
                    disp.append("5");
                }
            }
        });

        b_6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!isDispFull()){
                    clearLeadingZero();
                    disp.append("6");
                }
            }
        });

        b_7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!isDispFull()){
                    clearLeadingZero();
                    disp.append("7");
                }
            }
        });

        b_8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!isDispFull()){
                    clearLeadingZero();
                    disp.append("8");
                }
            }
        });

        b_9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!isDispFull()){
                    clearLeadingZero();
                    disp.append("9");
                }
            }
        });

        b_clr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                disp.setText("");
                operationToPerform = "";
                storedValue = 0;
            }
        });

        b_ce.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(disp.length() != 0) {
                    String numEntered = disp.getText().toString();
                    numEntered = numEntered.substring(0, numEntered.length() - 1);
                    disp.setText(numEntered);
                }
            }
        });

        b_sqrt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            double userInput = Double.parseDouble(disp.getText().toString());
            String sqrtInput = Double.toString(sqrt(userInput));
            disp.setText(sqrtInput);
            }
        });

        b_mod.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                storedValue = Double.parseDouble(disp.getText().toString());

                performPreviousOp();
                disp.setText("");

                operationToPerform = "%";

            }
        });

        b_div.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                storedValue = Double.parseDouble(disp.getText().toString());

                performPreviousOp();
                disp.setText("");

                operationToPerform = "/";
            }
        });

        b_plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                storedValue = Double.parseDouble(disp.getText().toString());

                performPreviousOp();
                disp.setText("");

                operationToPerform = "+";
            }
        });

        b_sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                storedValue = Double.parseDouble(disp.getText().toString());

                performPreviousOp();
                disp.setText("");

                operationToPerform = "-";
            }
        });

        b_mult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                storedValue = Double.parseDouble(disp.getText().toString());

                performPreviousOp();
                disp.setText("");

                operationToPerform = "*";
            }
        });

        b_neg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                double userInput = Double.parseDouble(disp.getText().toString());
                userInput *= -1;
                String negInput = Double.toString(userInput);
                disp.setText(formatDecimals(userInput));
            }
        });

        b_dot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!disp.getText().toString().contains("."))
                    disp.append(".");
            }
        });

        b_equal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                performPreviousOp();
                disp.setText(formatDecimals(storedValue));
                operationToPerform = "";
            }
        });
    }
}