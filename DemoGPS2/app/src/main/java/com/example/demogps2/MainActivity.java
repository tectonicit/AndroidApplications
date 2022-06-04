package com.example.demogps2;

import androidx.appcompat.app.AppCompatActivity;

import android.location.Address;
import android.location.Geocoder;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    Button b1,b2;
    EditText e1;
    TextView tv,tv2;
    double lat,lng;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        b1=findViewById(R.id.button);
        b2=findViewById(R.id.button2);
        e1=findViewById(R.id.txtaddress);
        tv=findViewById(R.id.textView);
        tv2=findViewById(R.id.textView2);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //forward Geocoding
                String adr=e1.getText().toString();
                Geocoder geocoder=new Geocoder(MainActivity.this, Locale.getDefault());

                try {
                   List<Address> list1= geocoder.getFromLocationName(adr,1);
                   Address ad=list1.get(0);

                   lat=ad.getLatitude();
                   lng=ad.getLongitude();

                   tv.setText(lat+","+lng);

                } catch (IOException e) {
                    Toast.makeText(MainActivity.this, "Error", Toast.LENGTH_SHORT).show();
                }


            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //revese Geocoding
                Geocoder geocoder=new Geocoder(MainActivity.this,Locale.getDefault());
                try {
                  List<Address> list1=  geocoder.getFromLocation(lat,lng,1);
                    Address ad=list1.get(0);
                    String s1=ad.getAddressLine(0);
                    s1+=ad.getLocality();
                    s1+=ad.getPostalCode();
                    s1+=ad.getCountryName();
                    tv2.setText(s1);
                } catch (IOException e) {
                    Toast.makeText(MainActivity.this, "Error", Toast.LENGTH_SHORT).show();
                }

            }
        });
    }
}