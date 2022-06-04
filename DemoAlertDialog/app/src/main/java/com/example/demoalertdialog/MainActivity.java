package com.example.demoalertdialog;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity
        implements View.OnClickListener, DialogInterface.OnClickListener {

    Button b1;
    TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        b1 = findViewById(R.id.button);
        tv = findViewById(R.id.textView);
        b1.setOnClickListener(this);
    }

    void showdialog() {
        //AlertDialog control
        AlertDialog ad;
        ad = new AlertDialog.Builder(this).create();
        ad.setMessage("Do you want to exit?");
        ad.setButton(AlertDialog.BUTTON_NEGATIVE, "No", this);
        ad.setButton(AlertDialog.BUTTON_POSITIVE, "YES", this);
        ad.setButton(AlertDialog.BUTTON_NEUTRAL, "CANCEL", this);
        ad.show();
    }

    @Override
    public void onClick(View view) {
        showdialog();
    }

    @Override
    public void onBackPressed() {
        showdialog();
    }

    @Override
    public void onClick(DialogInterface dialogInterface, int which) {

        String s1 = "";
        switch (which) {

            case AlertDialog.BUTTON_POSITIVE:
                s1 = "Yes";
                //hide screes
                finish();
                break;
            case AlertDialog.BUTTON_NEGATIVE:
                s1 = "NO";
                break;
            case AlertDialog.BUTTON_NEUTRAL:
                s1 = "Cancel";
        }
        tv.setText(s1);
    }
}