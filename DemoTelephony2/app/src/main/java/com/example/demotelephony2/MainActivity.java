package com.example.demotelephony2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.telephony.TelephonyManager;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity
        implements View.OnClickListener {

    TextView tv;
    TelephonyManager tm;
    Button b1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv=findViewById(R.id.txtinfo);
        b1=findViewById(R.id.button);
        b1.setOnClickListener(this);
        tm=(TelephonyManager) getSystemService(TELEPHONY_SERVICE);


    }

    @Override
    public void onClick(View view) {
        StringBuffer sb=new StringBuffer();
        String s1= tm.getDeviceId();
        int x=tm.getPhoneCount();
        String s2=tm.getDeviceSoftwareVersion();
        String s3=tm.getImei();
        String s4=tm.getLine1Number();
        sb.append("ID : "+s1);
        sb.append("\nNum of Sim : "+x);
        sb.append("\nVersion : "+s2);
        sb.append("\nIMEI : "+s3);
        sb.append("\nPhone number : "+s4);
        tv.setText(sb);

    }
}