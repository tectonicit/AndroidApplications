package com.example.demosms;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.SmsMessage;
import android.widget.Toast;

public class MyReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {

        Bundle ob=intent.getExtras();
        Object[] arr=(Object[]) ob.get("pdus");
        for(int i=0;i< arr.length;i++){
            SmsMessage sms=SmsMessage.createFromPdu((byte[])arr[i]);
            //read message
            String sender=sms.getOriginatingAddress();
            String msg=sms.getMessageBody();
            Toast.makeText(context, sender+":"+msg, Toast.LENGTH_LONG).show();
        }

    }
}