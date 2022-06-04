package com.example.receiver1;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.TelephonyManager;
import android.widget.Toast;

public class MyReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {

        Bundle ob=intent.getExtras();
        String num=ob.getString(TelephonyManager.EXTRA_INCOMING_NUMBER);
        Toast.makeText(context, "Received phone broadcast"+num, Toast.LENGTH_SHORT).show();

    }
}