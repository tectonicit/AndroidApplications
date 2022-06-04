package com.example.demowebservice;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.graphics.PixelFormat;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.SurfaceHolder;
import android.view.View;
import android.widget.Button;
import android.widget.MediaController;
import android.widget.VideoView;

public class MainActivity2 extends AppCompatActivity {

    Button b1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        b1=findViewById(R.id.button17);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                VideoView videoView =findViewById(R.id.videoView);
                //Set MediaController  to enable play, pause, forward, etc options.
                MediaController mediaController= new MediaController(MainActivity2.this);

                //Location of Media File
                Uri uri = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.sample);
                //Starting VideView By Setting MediaController and URI
                videoView.setMediaController(mediaController);
                videoView.setVideoURI(uri);

                videoView.start();
            }
        });

    }
}