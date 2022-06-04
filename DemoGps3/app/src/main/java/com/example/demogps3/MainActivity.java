package com.example.demogps3;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements LocationListener {

    TextView tv;
    Button b1;
    LocationManager lm;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        b1=findViewById(R.id.button);
        tv=findViewById(R.id.textView);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //goto next map
                Intent it=new Intent(MainActivity.this,MapsActivity.class);
                startActivity(it);
            }
        });
        lm=(LocationManager) getSystemService(LOCATION_SERVICE);
        lm.requestLocationUpdates(LocationManager.GPS_PROVIDER,0,0,this);
    }

    @Override
    public void onLocationChanged(@NonNull Location location) {

        double lat,lng;
        lat=location.getLatitude();
        lng=location.getLongitude();
        TEST.lat=lat;
        TEST.lng=lng;
        tv.setText(lat+","+lng);
        Toast.makeText(MainActivity.this, "Got Locations", Toast.LENGTH_SHORT).show();
    }
}