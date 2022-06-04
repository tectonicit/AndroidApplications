package com.example.myprefdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button b1,b2,b3,b4;
    LinearLayout l1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        b1=findViewById(R.id.button);
        b2=findViewById(R.id.button2);
        b3=findViewById(R.id.button3);
        b4=findViewById(R.id.button4);
        l1=findViewById(R.id.linearLayout);
        SharedPreferences sp;
        sp=getSharedPreferences("myfile1",MODE_PRIVATE);
        String cn=sp.getString("bgcolor","no set");

        if(!cn.equals("no set")){

            if(cn.equals("red")){
                l1.setBackgroundColor(Color.RED);
            }
            else  if(cn.equals("green")){
                l1.setBackgroundColor(Color.GREEN);
            }
            else  if(cn.equals("blue")){
                l1.setBackgroundColor(Color.BLUE);
            }

        }


        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences sp;
                sp=getSharedPreferences("myfile1",MODE_PRIVATE);
                SharedPreferences.Editor ed;
                ed=sp.edit();
                ed.putString("bgcolor","red");

                l1.setBackgroundColor(Color.RED);
                ed.commit();

                Toast.makeText(MainActivity.this, "RED", Toast.LENGTH_SHORT).show();
            }
        });

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences sp;
                sp=getSharedPreferences("myfile1",MODE_PRIVATE);
                SharedPreferences.Editor ed;
                ed=sp.edit();
                ed.putString("bgcolor","green");
                l1.setBackgroundColor(Color.GREEN);
                Toast.makeText(MainActivity.this, "GREEN", Toast.LENGTH_SHORT).show();
                ed.commit();
            }
        });
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences sp;
                sp=getSharedPreferences("myfile1",MODE_PRIVATE);
                SharedPreferences.Editor ed;
                ed=sp.edit();
                ed.putString("bgcolor","blue");

                ed.commit();
                l1.setBackgroundColor(Color.BLUE);
                Toast.makeText(MainActivity.this, "BLUE", Toast.LENGTH_SHORT).show();
            }
        });
        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences sp;
                sp=getSharedPreferences("myfile1",MODE_PRIVATE);
                SharedPreferences.Editor ed;
                ed=sp.edit();
               ed.remove("bgcolor");
                Toast.makeText(MainActivity.this, "Deleted", Toast.LENGTH_SHORT).show();

                ed.commit();
            }
        });
    }
}