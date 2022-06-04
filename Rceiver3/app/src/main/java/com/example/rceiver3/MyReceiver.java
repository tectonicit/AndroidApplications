package com.example.rceiver3;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.provider.Settings;
import android.widget.Toast;

public class MyReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {

        boolean flag= Settings.Global.getInt(context.getContentResolver(), Settings.Global.AIRPLANE_MODE_ON,0)!=0;

        if(flag){
            Toast.makeText(context, "Airplane Mode On", Toast.LENGTH_LONG).show();
        }else{
            Toast.makeText(context, "Airplane Mode Off", Toast.LENGTH_LONG).show();
        }
    }
}