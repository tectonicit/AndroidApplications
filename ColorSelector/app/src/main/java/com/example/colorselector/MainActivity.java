package com.example.colorselector;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.SeekBar;

public class MainActivity extends AppCompatActivity
        implements SeekBar.OnSeekBarChangeListener {

    SeekBar red,green,blue;
    LinearLayout l1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        red=findViewById(R.id.seekBar);
        green=findViewById(R.id.seekBar2);
        blue=findViewById(R.id.seekBar3);
        l1=findViewById(R.id.linearLayout);
        red.setOnSeekBarChangeListener(this);
        green.setOnSeekBarChangeListener(this);
        blue.setOnSeekBarChangeListener(this);
    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int i, boolean b2) {

        int r,g,b;
        r=red.getProgress();
        g=green.getProgress();
        b=blue.getProgress();

        l1.setBackgroundColor(Color.rgb(r,g,b));

    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {

    }
}