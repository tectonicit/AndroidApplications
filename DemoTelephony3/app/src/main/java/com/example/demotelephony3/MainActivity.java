package com.example.demotelephony3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.telephony.TelephonyManager;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView tv1, tv2;
    TelephonyManager tm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv1 = findViewById(R.id.textView);
        tv2 = findViewById(R.id.textView2);

        tm = (TelephonyManager) getSystemService(TELEPHONY_SERVICE);

        StringBuffer sb1 = new StringBuffer();
        int x, y;
        x = tm.getDataActivity();
        y = tm.getDataState();
        String s1 = "";
        switch (y) {
            case TelephonyManager.DATA_CONNECTED:
                s1 = "CONNECTED";
                break;
            case TelephonyManager.DATA_DISCONNECTED:
                s1 = "DISCONNECTED";
                break;
        }
        String s2 = "";
        switch (x) {
            case TelephonyManager.DATA_ACTIVITY_IN:
                s2 = "IN";
                break;
            case TelephonyManager.DATA_ACTIVITY_OUT:
                s2 = "OUT";
                break;
            case TelephonyManager.DATA_ACTIVITY_INOUT:
                s2 = "INOUT";
                break;
            case TelephonyManager.DATA_ACTIVITY_NONE:
                s2 = "NONE";
                break;

        }
        sb1.append("\nStatus :" + s1);
        sb1.append("\nActivity :" + s2);
        tv1.setText(sb1.toString());

        StringBuffer sb2=new StringBuffer();
        //SIM Details
        String s3=tm.getNetworkOperatorName();
        sb2.append(s3);
        String s4=tm.getNetworkOperator();
        String s5=tm.getNetworkCountryIso();
       // String s6=tm.getSimSerialNumber();
        sb2.append("Name : "+s3);
        sb2.append("\nCode : "+s4);
        sb2.append("\nISO : "+s5);
      //  sb2.append("\nSerial Number : "+s6);

        tv2.setText(sb2.toString());


    }
}