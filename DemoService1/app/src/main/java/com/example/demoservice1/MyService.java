package com.example.demoservice1;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.util.Log;
import android.widget.Toast;

public class MyService extends Service {
    MediaPlayer player;
    public MyService() {
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Log.i("MyService","OnCreate()");
      Toast.makeText(MyService.this, "OnCreate()", Toast.LENGTH_LONG).show();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
       // Toast.makeText(MyService.this, "OnSTartCommand()", Toast.LENGTH_LONG).show();
        Log.i("MyService","OnSTartCommand()");
        player=MediaPlayer.create(this, R.raw.tone1);
        player.setLooping(true);
        player.start();
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
       // Toast.makeText(MyService.this, "OnDestroy()", Toast.LENGTH_LONG).show();
        Log.i("MyService","OnDestroy()");
        player.stop();
        super.onDestroy();
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }
}