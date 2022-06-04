package com.example.demoaudioplayer;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button btn_start, btn_pause, btn_forward, btn_backward, btn_stop;
    MediaPlayer player;
    TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn_start = findViewById(R.id.button);
        btn_pause = findViewById(R.id.button2);
        btn_forward = findViewById(R.id.button3);
        btn_backward = findViewById(R.id.button4);
        btn_stop = findViewById(R.id.button5);

        tv=findViewById(R.id.textView);

        player = MediaPlayer.create(MainActivity.this, R.raw.song);

        int duration=player.getDuration();
        tv.setText("Total Time : "+duration);
        btn_start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //start song
                player.start();
            }
        });
        btn_pause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //pause
                player.pause();
            }
        });
        btn_forward.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //forward
                int time=player.getCurrentPosition();
                player.seekTo(time+500);
            }
        });
        btn_backward.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //backward
                int time=player.getCurrentPosition();
                player.seekTo(time-500);
            }
        });
        btn_stop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //stop
                player.stop();
                player.release();


            }
        });
    }
}