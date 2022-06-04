package com.example.demoanimation;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    ImageView iv;
    Button b1, b2, b3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        b1 = findViewById(R.id.button);
        b2 = findViewById(R.id.button2);
        b3 = findViewById(R.id.button3);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                iv = findViewById(R.id.imageView);
                Animation animation;
                animation = AnimationUtils.loadAnimation(MainActivity.this, R.anim.animi);
                iv.startAnimation(animation);

            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                iv = findViewById(R.id.imageView);
                Animation animation1;
                animation1=AnimationUtils.loadAnimation(MainActivity.this,R.anim.clockwise);
                iv.setAnimation(animation1);
            }
        });
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "Fade", Toast.LENGTH_SHORT).show();
                iv = findViewById(R.id.imageView);
                Animation animation1;
                animation1=AnimationUtils.loadAnimation(MainActivity.this,R.anim.fade);
                iv.setAnimation(animation1);
            }
        });


    }
}