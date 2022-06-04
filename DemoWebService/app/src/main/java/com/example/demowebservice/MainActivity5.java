package com.example.demowebservice;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity5 extends AppCompatActivity {

    Button b1,b2,b3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main5);
        b1=findViewById(R.id.button14);
        b2=findViewById(R.id.button15);
        b3=findViewById(R.id.button16);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ImageView image = findViewById(R.id.imageView2);
                Animation animation = AnimationUtils.loadAnimation(getApplicationContext(),
                        R.anim.animi);
                image.startAnimation(animation);
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ImageView image = (ImageView)findViewById(R.id.imageView2);
                Animation animation1 = AnimationUtils.loadAnimation(getApplicationContext(),
                        R.anim.clockwise);
                image.startAnimation(animation1);
            }
        });
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ImageView image = (ImageView)findViewById(R.id.imageView2);
                Animation animation1 = AnimationUtils.loadAnimation(getApplicationContext(),
                        R.anim.fade);
                image.startAnimation(animation1);
            }
        });
    }
}