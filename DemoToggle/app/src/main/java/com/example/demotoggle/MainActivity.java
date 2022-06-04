package com.example.demotoggle;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    ToggleButton tb;
    TextView tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tb=findViewById(R.id.toggleButton);
        tv=findViewById(R.id.textView);
        tb.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {

        String s1="";
        if(tb.isChecked()){
            s1="ON";
        }
        else{
            s1="OFF";
        }
        tv.setText(s1);

    }
}