package com.example.secondapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button b1,b2;
    ConstraintLayout l1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        b1=findViewById(R.id.button);
        b2=findViewById(R.id.button2);
        l1=findViewById(R.id.layout1);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

               // l1.setBackgroundColor(Color.RED);
                l1.setBackgroundResource(R.drawable.image1);
            }
        });

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //l1.setBackgroundColor(Color.GREEN);
                l1.setBackgroundResource(R.drawable.image2);
            }
        });

    }
}