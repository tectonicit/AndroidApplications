package com.example.demosms;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity
        implements View.OnClickListener {

    Button b1;
    EditText e1,e2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        b1=findViewById(R.id.button);
        e1=findViewById(R.id.txtmessage);
        e2=findViewById(R.id.txtnumber);
        b1.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        String msg=e1.getText().toString();
        String num=e2.getText().toString();
        SmsManager sms;
        sms=SmsManager.getDefault();
        sms.sendTextMessage(num,null,msg,null,null);
        Toast.makeText(MainActivity.this, "Message Send", Toast.LENGTH_SHORT).show();

    }
}