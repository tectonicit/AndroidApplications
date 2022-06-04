package com.example.demologin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText e1,e2;
    Button b1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        e1=findViewById(R.id.edit_username);
        e2=findViewById(R.id.edit_pass);
        b1=findViewById(R.id.btn_login);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String uname=e1.getText().toString();
                String pass=e2.getText().toString();
                if(uname.equals("abc") && pass.equals("xyz")) {

                    //creat object of Intent class
                    Intent it=new Intent(MainActivity.this,MainActivity2.class);
                    it.putExtra("username",uname);
                    startActivity(it);

                }else{


                    Toast.makeText(MainActivity.this, "Invalid user", Toast.LENGTH_LONG).show();
                }

            }
        });

    }
}