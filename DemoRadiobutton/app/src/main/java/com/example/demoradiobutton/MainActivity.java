package com.example.demoradiobutton;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    RadioGroup rg;
    Button b1;
    TextView tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rg=findViewById(R.id.radiogroup);
        b1=findViewById(R.id.button);
        tv=findViewById(R.id.textView);
        b1.setOnClickListener(this::onClick);
    }

    @Override
    public void onClick(View view) {

        String s1="";
        switch (rg.getCheckedRadioButtonId()){
            case R.id.radioButton:
                s1="Male";
                break;
            case R.id.radioButton2:
                s1="Female";
                break;
        }

        tv.setText(s1);





    }
}