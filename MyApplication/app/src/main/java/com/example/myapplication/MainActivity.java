package com.example.myapplication;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.telephony.PhoneStateListener;
import android.telephony.TelephonyCallback;
import android.telephony.TelephonyManager;
import android.widget.Toast;

@RequiresApi(api = Build.VERSION_CODES.S)
public class MainActivity extends AppCompatActivity {

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TelephonyManager tm;
        tm = (TelephonyManager) getSystemService(TELEPHONY_SERVICE);

        Test t1 = new Test(this);
        tm.listen(t1, PhoneStateListener.LISTEN_CALL_STATE);

    }


}

class Test extends PhoneStateListener {
    Context context;
    Test(Context c){
        context=c;
    }
    @Override
    public void onCallStateChanged(int state, String phoneNumber) {
        Toast.makeText(context, ""+state, Toast.LENGTH_SHORT).show();

    }
}
