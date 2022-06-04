package com.example.demologcat;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    String TAG = "MyTAG";

    Button b1, b2, b3, b4;
    EditText e1, e2, e3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        Log.e(TAG,"This is ERROR");
//        Log.i(TAG,"This is information");
//        Log.d(TAG,"This is Debug");
//        Log.v("TAG","This Verbose");
//        Log.w(TAG,"This is Warning");
        b1 = findViewById(R.id.button);
        b2 = findViewById(R.id.button2);
        b3 = findViewById(R.id.button3);
        b4 = findViewById(R.id.button4);
        b1.setOnClickListener(this);
        b2.setOnClickListener(this);
        b3.setOnClickListener(this);
        b4.setOnClickListener(this);
        e1 = findViewById(R.id.editTextNumber);
        e2 = findViewById(R.id.editTextNumber2);
        e3 = findViewById(R.id.editTextNumber3);
    }

    @Override
    public void onClick(View view) {
        String n1 = e1.getText().toString();
        String n2 = e2.getText().toString();
        int a,b,c=0;
        a=Integer.parseInt(n1);
        b=Integer.parseInt(n2);

        switch (view.getId()) {
            case R.id.button:
                //add
                c=a+b;
                break;
            case R.id.button2:
                //sub
                c=a-b;
                break;
            case R.id.button3:
                //mul
                c=a*b;
                break;
            case R.id.button4:
                //div
                try {
                    c=a/b;
                }catch (Exception e){
                    e3.setText("Can not Divide by zero!!");
                    Toast.makeText(this, "Can not Divide by zero!!", Toast.LENGTH_SHORT).show();
                }
                break;
        }
        e3.setText(""+c);

    }
}