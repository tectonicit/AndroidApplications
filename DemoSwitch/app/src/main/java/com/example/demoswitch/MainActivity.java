package com.example.demoswitch;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.CompoundButton;
import android.widget.RadioGroup;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity
        implements CompoundButton.OnCheckedChangeListener {

    Switch sw;
    TextView tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sw=findViewById(R.id.switch1);
        tv=findViewById(R.id.textView);
        sw.setOnCheckedChangeListener(this);
    }


    @Override
    public void onCheckedChanged(CompoundButton compoundButton, boolean b) {

//        tv.setText("Bluetooth selected "+b);
        if(b==true){
            tv.setText("On");
            Toast.makeText(MainActivity.this, "ON", Toast.LENGTH_LONG).show();
        }else{
            Toast.makeText(MainActivity.this, "OFF", Toast.LENGTH_LONG).show();
            tv.setText("Off");
        }
    }
}