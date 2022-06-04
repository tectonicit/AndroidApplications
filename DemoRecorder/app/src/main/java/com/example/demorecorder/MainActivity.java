package com.example.demorecorder;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.media.MediaRecorder;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    Button btn_start, btn_stop, btn_play;

    MediaRecorder recorder;
    TextView tv;
    String path = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn_start = findViewById(R.id.button);
        btn_stop = findViewById(R.id.button2);
        btn_play = findViewById(R.id.button3);
        tv = findViewById(R.id.textView);
        //start settings

        recorder = new MediaRecorder();
        //set the source of audio record
        recorder.setAudioSource(MediaRecorder.AudioSource.MIC);
        recorder.setOutputFormat(MediaRecorder.OutputFormat.THREE_GPP);

        recorder.setAudioEncoder(MediaRecorder.AudioEncoder.AMR_NB);

        path = Environment.getExternalStorageDirectory().getAbsolutePath();
        path += "/" + "myfile.3gp";

        tv.setText(path);
        recorder.setOutputFile(path);


        //stop settings


        btn_start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //record
                try {
                    recorder.prepare();
                    recorder.start();
                    Toast.makeText(MainActivity.this, "Recording Started", Toast.LENGTH_LONG).show();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

        btn_stop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //stop
                recorder.stop();
                recorder.release();
                recorder = null;
                Toast.makeText(MainActivity.this, "Recording Stopped", Toast.LENGTH_SHORT).show();
            }
        });

        btn_play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                MediaPlayer player;
                player = new MediaPlayer();
                try {
                    player.setDataSource(path);
                    player.prepare();
                    player.start();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        });


    }
}