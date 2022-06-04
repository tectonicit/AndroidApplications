package com.example.demosharedpref;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText e1;
    Button b1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        e1=findViewById(R.id.txt_name);
        b1=findViewById(R.id.button);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //get SharedPref object

                SharedPreferences preferences;
                preferences=getSharedPreferences("myfile",MODE_PRIVATE);

                //Edit SharedPref
                SharedPreferences.Editor ed;
                ed=preferences.edit();
                String n=e1.getText().toString();

                ed.putString("uname",n);
                //commit (save changes to Shared Pref)
                ed.commit();

                Intent it=new Intent(MainActivity.this,MainActivity2.class);

                startActivity(it);

            }
        });
    }
}