package com.example.demovideoview;

import androidx.appcompat.app.AppCompatActivity;

import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.MediaController;
import android.widget.VideoView;

public class MainActivity extends AppCompatActivity {

    Button b1;
    VideoView vv;
    MediaController controller;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        b1=findViewById(R.id.button);
        vv=findViewById(R.id.videoView);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //forward,backward,pause
                controller=new MediaController(MainActivity.this);
                Uri path=Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.sample);

                vv.setMediaController(controller);
                vv.setVideoURI(path);
                vv.start();
            }
        });

    }
}