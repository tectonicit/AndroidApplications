package com.example.demopopup;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.PopupMenu;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity
        implements View.OnClickListener, PopupMenu.OnMenuItemClickListener {

    Button b1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        b1 = findViewById(R.id.button);
        b1.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {

        PopupMenu p = new PopupMenu(MainActivity.this, b1);
        MenuInflater inflater = p.getMenuInflater();
        inflater.inflate(R.menu.menu3, p.getMenu());
        p.setOnMenuItemClickListener(this);
        p.show();
    }

    @Override
    public boolean onMenuItemClick(MenuItem menuItem) {
        switch (menuItem.getItemId()){

            case R.id.actions_settings:

                Toast.makeText(MainActivity.this, "Settings Selected", Toast.LENGTH_SHORT).show();
                break;
            case R.id.actions_copy:
                Toast.makeText(MainActivity.this, "Copy selected", Toast.LENGTH_SHORT).show();
                break;
            case R.id.actions_exit:

                finish();
                break;


        }
        return true;
    }
}