package com.example.receiver4;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity
        implements View.OnClickListener {

    Button b1;
    EditText e1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        b1=findViewById(R.id.button);
        e1=findViewById(R.id.txtnum);
        b1.setOnClickListener(this);
    }
    @Override
    public void onClick(View view) {

        String s1=e1.getText().toString();
        int n=Integer.parseInt(s1);

        Intent it=new Intent(this,MyReceiver.class);

        PendingIntent pd=PendingIntent.getBroadcast(this,123,it,0);

        AlarmManager am;
        am=(AlarmManager) getSystemService(ALARM_SERVICE);
        am.set(AlarmManager.RTC,System.currentTimeMillis()+n*1000,pd);

    }
}