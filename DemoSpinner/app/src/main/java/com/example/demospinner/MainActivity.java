package com.example.demospinner;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity
        implements View.OnClickListener, AdapterView.OnItemSelectedListener {

    Button b1;
    Spinner sp;
    TextView tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        b1=findViewById(R.id.button);
        sp=findViewById(R.id.spinner);
        tv=findViewById(R.id.textView);
        //create Array of String
        String[] arr={"C","CPP","JAVA","PYTHON"};
        ArrayAdapter<String> ad;
        ad=new ArrayAdapter<>(MainActivity.this,R.layout.support_simple_spinner_dropdown_item,arr);
        sp.setAdapter(ad);
        b1.setOnClickListener(this);
        sp.setOnItemSelectedListener(this);
    }

    @Override
    public void onClick(View view) {

        String s1=sp.getSelectedItem().toString();
        tv.setText(s1);
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        String s1=sp.getSelectedItem().toString();
        tv.setText("You Selected "+s1);
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}