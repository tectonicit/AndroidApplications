package com.example.agecalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity
        implements View.OnClickListener , DatePickerDialog.OnDateSetListener {

    Button b1;
    EditText e1;
    TextView tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        b1=findViewById(R.id.button);
        e1=findViewById(R.id.txt_date);
        tv=findViewById(R.id.textView);
        b1.setOnClickListener(this);
    }
    int d,m,y;
    @Override
    public void onClick(View view) {
        Calendar c=Calendar.getInstance();

        d=c.get(Calendar.DAY_OF_MONTH);
        m=c.get(Calendar.MONTH);
        y=c.get(Calendar.YEAR);
        DatePickerDialog dp;
        dp=new DatePickerDialog(MainActivity.this,this::onDateSet,y,m,d);
        dp.show();

    }

    @Override
    public void onDateSet(DatePicker datePicker, int year, int month, int day) {
        int age;
        age=y-year;
        e1.setText(year+"/"+month+"/"+day);
        tv.setText(""+age);
    }
}