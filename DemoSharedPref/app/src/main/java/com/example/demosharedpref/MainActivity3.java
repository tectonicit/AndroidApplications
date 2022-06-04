package com.example.demosharedpref;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity3 extends AppCompatActivity {

    TextView tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        tv=findViewById(R.id.textView2);
        //get SHared Pref object
        SharedPreferences sp;
        sp=getSharedPreferences("myfile",MODE_PRIVATE);
        String n1=sp.getString("uname","Not found");
        tv.setText(n1);
    }
}