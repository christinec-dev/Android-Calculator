package com.christiencdev.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    //multiple declaration of button objects
    private Button btn0, btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9,  btnAC, btnDot, btnAdd, btnMinus, btnDivide, btnMulti, btnEqual, btnDel;

    //multiple declaration of textview objects
    private TextView textViewResult, textViewHistory;

    //needed for numbers entry
    private  String number = null;
    double firsNum = 0;
    double lastNum = 0;

    String status = null;
    Boolean operator = false;
    DecimalFormat myFormatter = new DecimalFormat("######.######");

    //needed for history (sum) display
    String history, currentResult;

    //needed to prevent multiple dots (decimal) points
    boolean dot = true;

    //checks to see if ac is pressed
    boolean btnACControl = true;

    //needed for new sum creation
    boolean btnEqualsControl = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //link components to id
        btn0 = findViewById(R.id.btn0);
        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);
        btn3 = findViewById(R.id.btn3);
        btn4 = findViewById(R.id.btn4);
        btn5 = findViewById(R.id.btn5);
        btn6 = findViewById(R.id.btn6);
        btn7 = findViewById(R.id.btn7);
        btn8 = findViewById(R.id.btn8);
        btn9 = findViewById(R.id.btn9);

        btnAdd = findViewById(R.id.btnAdd);
        btnDivide = findViewById(R.id.btnDivide);
        btnMinus = findViewById(R.id.btnMinus);
        btnMulti = findViewById(R.id.btnMulti);

        btnAC = findViewById(R.id.btnAC);
        btnDel = findViewById(R.id.btnDel);
        btnEqual = findViewById(R.id.btnEqual);
        btnDot = findViewById(R.id.btnDot);

        textViewHistory = findViewById(R.id.textViewHistory);
        textViewResult = findViewById(R.id.textViewResult);

        //we activate our objects
        //numbers
        btn0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //will print this number into numberClick method
                numberClick("0");
            }
        });

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //will print this number into numberClick method
                numberClick("1");
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //will print this number into numberClick method
                numberClick("2");
            }
        });

        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //will print this number into numberClick method
                numberClick("3");
            }
        });

        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //will print this number into numberClick method
                numberClick("4");
            }
        });

        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //will print this number into numberClick method
                numberClick("5");
            }
        });

        btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //will print this number into numberClick method
                numberClick("6");
            }
        });

        btn7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //will print this number into numberClick method
                numberClick("7");
            }
        });

        btn8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //will print this number into numberClick method
                numberClick("8");
            }
        });

        btn9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //will print this number into numberClick method
                numberClick("9");
            }
        });

        //operators
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                history = textViewHistory.getText().toString();
                currentResult = textViewResult.getText().toString();
                textViewHistory.setText(history + currentResult + " + ");

                //will add
                if (operator)
                {
                    if (status == "multiplication")
                    {
                        multiply();
                    }
                    else if (status == "division")
                    {
                        divide();
                    }
                    else if (status == "subtraction")
                    {
                        minus();
                    }
                    else
                    {
                        plus();
                    }
                }

                status = "sum";
                operator = false;
                number = null;
            }
        });

        btnMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                history = textViewHistory.getText().toString();
                currentResult = textViewResult.getText().toString();
                textViewHistory.setText(history + currentResult + " - ");

                //will minus
                if (operator)
                {
                    if (status == "multiplication")
                    {
                        multiply();
                    }
                    else if (status == "division")
                    {
                        divide();
                    }
                    else if (status == "sum")
                    {
                        plus();
                    }
                    else
                    {
                        minus();
                    }
                }

                status = "subtraction";
                operator = false;
                number = null;
            }
        });

        btnDivide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                history = textViewHistory.getText().toString();
                currentResult = textViewResult.getText().toString();
                textViewHistory.setText(history + currentResult + " / ");

                //will divide
                if (operator)
                {
                    if (status == "multiplication")
                    {
                        multiply();
                    }
                    else if (status == "subtraction")
                    {
                        minus();
                    }
                    else if (status == "sum")
                    {
                        plus();
                    }
                    else
                    {
                        divide();
                    }
                }

                status = "division";
                operator = false;
                number = null;
            }
        });

        btnMulti.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                history = textViewHistory.getText().toString();
                currentResult = textViewResult.getText().toString();
                textViewHistory.setText(history + currentResult + " * ");

                //will multiply
                if (operator)
                {
                    if (status == "subtraction")
                    {
                        minus();
                    }
                    else if (status == "division")
                    {
                        divide();
                    }
                    else if (status == "sum")
                    {
                        plus();
                    }
                    else
                    {
                        multiply();
                    }
                }

                status = "multiplication";
                operator = false;
                number = null;
            }
        });

        //functions
        btnAC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //will clear the screen
                number = null;
                status = null;
                textViewResult.setText("0");
                textViewHistory.setText("");
                firsNum = 0;
                lastNum = 0;
                dot = true;
                btnACControl = true;
            }
        });

        btnDot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //needed to prevent multiple dots (decimal) points
                if (dot)
                {
                    //add decimal
                    if (number == null)
                    {
                        number = "0.";
                    }
                    else
                    {
                        number = number + ".";
                    }
                }

                textViewResult.setText(number);
                dot = false;
            }
        });

        btnDel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //will check if there is anything first
                if (btnACControl)
                {
                    textViewResult.setText("0");
                }
                else {
                    //will delete only the last digit entered
                    number = number.substring(0, number.length()-1);

                    if (number.length() == 0)
                    {
                        btnDel.setClickable(false);
                    }
                    else if (number.contains("."))
                    {
                        dot = false;
                    }
                    else {
                        dot = true;
                    }

                    textViewResult.setText(number);
                }
            }
        });

        btnEqual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //will create equal functionality
                if (operator)
                {
                    if (status == "multiplication")
                    {
                        multiply();
                    }
                    else if (status == "division")
                    {
                        divide();
                    }
                    else if (status == "sum")
                    {
                        plus();
                    }
                    else if (status == "subtraction")
                    {
                        minus();
                    }
                    else
                    {
                        firsNum = Double.parseDouble(textViewResult.getText().toString());
                    }
                }
                operator = false;
                btnEqualsControl = true;
            }
        });
    }

    //method will print numbers in the textViewResult
    public void numberClick(String view)
    {
        //if no number has been selected, print nothing
        if (number == null)
        {
            number = view;
        }
        //will start new sum after equal btn has been pressed
        else if(btnEqualsControl == true)
        {
            firsNum = 0;
            lastNum = 0;
            number = view;
        }
        //else print the number / operator into the textViewResult component
        else
        {
            number = number + view;
        }
        textViewResult.setText(number);
        operator = true;
        btnACControl = false;
        btnDel.setClickable(true);
        btnEqualsControl = false;
    }

    //operations methods
    public void plus()
    {
        //we capture the last number and add it to first number, the print
        lastNum = Double.parseDouble(textViewResult.getText().toString());
        firsNum = firsNum + lastNum;
        textViewResult.setText(myFormatter.format(firsNum));
        dot = true;
    }

    public void minus()
    {
        //if we subtract 0, the answer will always be first num
        if (firsNum == 0)
        {
            firsNum = Double.parseDouble(textViewResult.getText().toString());
        }
        //else subtract
        else
        {
            lastNum = Double.parseDouble(textViewResult.getText().toString());
            firsNum = firsNum - lastNum;
        }
        textViewResult.setText(myFormatter.format(firsNum));
        dot = true;
    }

    public void multiply()
    {
        //if we multiply by 0, the answer will always be 0
        if (firsNum == 0)
        {
            firsNum = 1;
            lastNum = Double.parseDouble(textViewResult.getText().toString());
            firsNum = firsNum * lastNum;
        }
        //else multiply
        else
        {
            lastNum = Double.parseDouble(textViewResult.getText().toString());
            firsNum = firsNum * lastNum;
        }
        textViewResult.setText(myFormatter.format(firsNum));
    }


    public void divide()
    {
        //if we divide by 0, the answer will always be 0
        if (firsNum == 0)
        {
            lastNum = Double.parseDouble(textViewResult.getText().toString());
            firsNum = firsNum / 1;
        }
        //else multiply
        else
        {
            lastNum = Double.parseDouble(textViewResult.getText().toString());
            firsNum = firsNum / lastNum;
        }
        textViewResult.setText(myFormatter.format(firsNum));
        dot = true;
    }
}