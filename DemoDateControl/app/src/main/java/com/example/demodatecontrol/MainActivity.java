package com.example.demodatecontrol;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity
        implements View.OnClickListener, DatePickerDialog.OnDateSetListener {

    Button b1;
    TextView tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        b1=findViewById(R.id.button);
        tv=findViewById(R.id.textView);
        b1.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        //get current date
        Calendar c=Calendar.getInstance();
        int d,m,y;
        d=c.get(Calendar.DAY_OF_MONTH);
        m=c.get(Calendar.MONTH);
        y=c.get(Calendar.YEAR);
        //Create object of DatePickerDialog
        DatePickerDialog dp;
        dp=new DatePickerDialog(MainActivity.this,this,y,m,d);
        dp.show();
    }

    @Override
    public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
        i1=i1+1;
        String s1=i2+"/"+i1+"/"+i;
        tv.setText(s1);
    }
}