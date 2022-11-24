package com.example.mclab3;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.mclab3.R.id;

public class MainActivity extends AppCompatActivity implements OnClickListener
{
    //Defining the Views
    EditText Num1;
    EditText Num2;
    Button Add;
    Button Sub;
    Button Mul;
    Button Div;
    TextView Result;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Referring the Views
        Num1 = findViewById(id.editText1);
        Num2 = findViewById(id.editText2);
        Add = findViewById(id.Add);
        Sub = findViewById(id.Sub);
        Mul = findViewById(id.Mul);
        Div = findViewById(id.Div);
        Result = findViewById(id.textView);

        // set a listener
        Add.setOnClickListener(this);
        Sub.setOnClickListener(this);
        Mul.setOnClickListener(this);
        Div.setOnClickListener(this);
    }

    @Override
    public void onClick (View v) {

        float num1;
        float num2;
        float result = 0;
        String oper = "";

        // check if the fields are empty
        if (TextUtils.isEmpty(Num1.getText().toString()) || TextUtils.isEmpty(Num2.getText().toString()))
        return;

        // read EditText and fill variables with numbers
        num1 = Float.parseFloat(Num1.getText().toString());
        num2 = Float.parseFloat(Num2.getText().toString());

        // defines the button that has been clicked and performs the corresponding operation
        // write operation into oper, we will use it later for output
        switch (v.getId()) {
            case id.Add:
                oper = "+";
                result = num1 + num2;
                break;
            case id.Sub:
                oper = "-";
                result = num1 - num2;
                break;
            case id.Mul:
                oper = "*";
                result = num1 * num2;
                break;
            case id.Div:
                oper = "/";
                result = num1 / num2;
                break;
            default:
                break;
}
// form the output line
Result.setText(String.format("%s %s %s = %s", num1, oper, num2, result));
}
}