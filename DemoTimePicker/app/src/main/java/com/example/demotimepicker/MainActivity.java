package com.example.demotimepicker;

import androidx.appcompat.app.AppCompatActivity;

import android.app.TimePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.TimePicker;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity
        implements View.OnClickListener, TimePickerDialog.OnTimeSetListener {

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
        Calendar c=Calendar.getInstance();
        int hour,min;
        hour=c.get(Calendar.HOUR);
        min=c.get(Calendar.MINUTE);

        TimePickerDialog tp;
        tp=new TimePickerDialog(MainActivity.this,MainActivity.this,hour,min,false);
        tp.show();
    }

    @Override
    public void onTimeSet(TimePicker timePicker, int i, int i1) {
String s1=i+":"+i1;
tv.setText(s1);
    }
}