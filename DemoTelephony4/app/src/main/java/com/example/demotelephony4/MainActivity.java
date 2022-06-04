package com.example.demotelephony4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.telephony.PhoneStateListener;
import android.telephony.ServiceState;
import android.telephony.TelephonyManager;
import android.util.Log;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TelephonyManager tm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tm = (TelephonyManager) getSystemService(TELEPHONY_SERVICE);
        MyPhoneListener t1 = new MyPhoneListener(MainActivity.this);
        tm.listen(t1,PhoneStateListener.LISTEN_CALL_STATE|PhoneStateListener.LISTEN_SERVICE_STATE);

    }
}

class MyPhoneListener extends PhoneStateListener {
    Context context;

    MyPhoneListener(Context c) {
        context = c;
    }

    @Override
    public void onServiceStateChanged(ServiceState serviceState) {

        switch (serviceState.getState()) {
            case ServiceState.STATE_IN_SERVICE:

                Log.i("MyInfo","STATE_IN_SERVICE");
                break;
            case ServiceState.STATE_EMERGENCY_ONLY:

                Log.i("MyInfo","STATE_EMERGENCY_ONLY");
                break;
            case ServiceState.STATE_POWER_OFF:

                Log.i("MyInfo","STATE_POWER_OFF");
                break;

        }
    }

    @Override
    public void onCallStateChanged(int state, String phoneNumber) {

        switch (state) {
            case TelephonyManager.CALL_STATE_IDLE:
                Toast.makeText(context, "IDEL", Toast.LENGTH_LONG).show();
                Log.i("MyInfo","IDEL");
                break;
            case TelephonyManager.CALL_STATE_RINGING:
                Toast.makeText(context, "RINGING", Toast.LENGTH_LONG).show();
                Log.i("MyInfo","CALL_STATE_RINGING");
                break;
            case TelephonyManager.CALL_STATE_OFFHOOK:
                Toast.makeText(context, "OFFHOOK", Toast.LENGTH_SHORT).show();
                Log.i("MyInfo","CALL_STATE_OFFHOOK");
                break;

        }
    }
}