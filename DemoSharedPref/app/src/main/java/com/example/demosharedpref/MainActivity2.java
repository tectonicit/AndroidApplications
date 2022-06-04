package com.example.demosharedpref;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {

    TextView tv;
    Button b2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        tv=findViewById(R.id.textView);

        b2=findViewById(R.id.button2);
        //get SHared Pref object
        SharedPreferences sp;
        sp=getSharedPreferences("myfile",MODE_PRIVATE);
        String n1=sp.getString("uname","Not found");
        tv.setText(n1);
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent it=new Intent(MainActivity2.this,MainActivity3.class);
                startActivity(it);

            }
        });



    }
}