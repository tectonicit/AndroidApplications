package com.example.democontextmenu;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button b1,b2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        b1=findViewById(R.id.button);
        b2=findViewById(R.id.button2);
        registerForContextMenu(b1);
        registerForContextMenu(b2);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        MenuInflater inflater=getMenuInflater();
        inflater.inflate(R.menu.menu2,menu);
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){

            case R.id.actions_copy:
                Toast.makeText(MainActivity.this, "copy Selected", Toast.LENGTH_SHORT).show();
                break;
            case R.id.actions_paste:
                Toast.makeText(MainActivity.this, "Paste Selected", Toast.LENGTH_SHORT).show();
                break;
            case R.id.action_exit:
                finish();
                Toast.makeText(MainActivity.this, "Exit", Toast.LENGTH_SHORT).show();
        }
        return true;
    }
}