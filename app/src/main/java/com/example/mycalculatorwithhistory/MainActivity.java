package com.example.mycalculatorwithhistory;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText inputone,inputtwo;
    TextView output;
    Button add,divide,minus,multiply,history,clear;
    private double result;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        inputone=findViewById(R.id.input1);
        inputtwo=findViewById(R.id.Input2);
        output=findViewById(R.id.output);
        add=findViewById(R.id.btnadd);
        minus=findViewById(R.id.btnminus);
        divide=findViewById(R.id.btndivide);
        multiply=findViewById(R.id.btnmultiply);
        history=findViewById(R.id.btnhis);
        clear=findViewById(R.id.btnclear);

        if (savedInstanceState != null) {
            result = savedInstanceState.getDouble("result");
            output.setText(String.valueOf(result));
        }

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                double num1=Double.parseDouble(inputone.getText().toString());
                double num2=Double.parseDouble(inputtwo.getText().toString());
                result=num1 + num2;
                output.setText(String.valueOf(result));
            }
        });
        minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                double num1=Double.parseDouble(inputone.getText().toString());
                double num2=Double.parseDouble(inputtwo.getText().toString());
                result=num1 - num2;
                output.setText((String.valueOf(result)));
            }
        });
        multiply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                double num1=Double.parseDouble(inputone.getText().toString());
                double num2=Double.parseDouble(inputtwo.getText().toString());
                result= num1 * num2;
                output.setText((String.valueOf(result)));
            }
        });
        divide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                double num1=Double.parseDouble(inputone.getText().toString());
                double num2=Double.parseDouble(inputtwo.getText().toString());
                result= num2 / num1;
                output.setText((String.valueOf(result)));
            }
        });
        history.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(MainActivity.this,History.class);
                i.putExtra("input1", inputone.getText().toString());
                i.putExtra("input2", inputtwo.getText().toString());
                i.putExtra("output", output.getText().toString());
                startActivity(i);
            }
        });
        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                inputone.setText("0");
                inputtwo.setText("0");
                output.setText("0"); ;
            }
        });

    }
    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putDouble("result", result);
    }
}