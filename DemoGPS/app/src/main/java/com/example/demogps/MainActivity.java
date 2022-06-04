package com.example.demogps;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity
        implements LocationListener {

    LocationManager lm;
    Button b1;
    TextView tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        b1=findViewById(R.id.button);
        tv=findViewById(R.id.textView);

        lm=(LocationManager) getSystemService(LOCATION_SERVICE);
        //perform registartion
      //  lm.requestLocationUpdates(LocationManager.GPS_PROVIDER,0,0,this);


        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Location loc;
                loc=lm.getLastKnownLocation(LocationManager.GPS_PROVIDER);
                if(loc==null){
                    tv.setText("Not able to find Location");
                }else{
                    double lat,lng;
                    lat=loc.getLatitude();
                    lng=loc.getLongitude();
                    tv.setText(lat+","+lng);
                }
            }
        });
    }

    @Override
    public void onLocationChanged(@NonNull Location location) {
        double lat,lng;
        lat=location.getLatitude();
        lng=location.getLongitude();
        tv.setText(lat+","+lng);
        Toast.makeText(MainActivity.this, "Got Locations", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onProviderEnabled(@NonNull String provider) {

        tv.setText("GPS ON");
        Toast.makeText(MainActivity.this, "GPS ON", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onProviderDisabled(@NonNull String provider) {

        tv.setText("GPS OFF");
        Toast.makeText(MainActivity.this, "GPS OFF", Toast.LENGTH_SHORT).show();
    }
}