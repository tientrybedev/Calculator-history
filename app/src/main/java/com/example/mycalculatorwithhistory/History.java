package com.example.mycalculatorwithhistory;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class History extends AppCompatActivity {
    private TextView input1,input2,result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);
        input1=findViewById(R.id.ip1);
        input2=findViewById(R.id.ip2);
        result=findViewById(R.id.rs);

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            String inp1 = extras.getString("input1");
            String inp2 = extras.getString("input2");
            String res = extras.getString("output");

            input1.setText(inp1);
            input2.setText(inp2);
            result.setText(res);

        }
    }
}