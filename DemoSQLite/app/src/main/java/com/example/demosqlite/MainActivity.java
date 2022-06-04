package com.example.demosqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button b1,b2,b3,b4;
    EditText e1,e2;
    SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        b1=findViewById(R.id.button);
        b2=findViewById(R.id.button2);
        b3=findViewById(R.id.button3);
        b4=findViewById(R.id.button4);
        e1=findViewById(R.id.txt_id);
        e2=findViewById(R.id.txt_name);
        //get MyHelper object

        MyHelper ob=new MyHelper(MainActivity.this,"db1",null,1);
        db=ob.getWritableDatabase();

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //save
                String id=e1.getText().toString();
                String name=e2.getText().toString();
                String sql="";
                sql="insert into student values("+id+",'"+name+"')";
                //execute query
                db.execSQL(sql);
                Toast.makeText(MainActivity.this, "Record Inserted!!", Toast.LENGTH_LONG).show();

            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("Range")
            @Override
            public void onClick(View view) {

                //select
                String id=e1.getText().toString();
                String sql="select * from student where id="+id;
                Cursor c;
                c=db.rawQuery(sql,null);
                if(c.moveToNext()){
                    e2.setText(c.getString(c.getColumnIndex("name")));
                }
                else{
                    Toast.makeText(MainActivity.this, "Record Not found", Toast.LENGTH_SHORT).show();
                }
            }
        });
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //save
                String id=e1.getText().toString();
                String name=e2.getText().toString();
                String sql="";
                sql="update student set name='"+name+"' where id="+id;
                //execute query
                db.execSQL(sql);
                Toast.makeText(MainActivity.this, "Record Updated!!!!", Toast.LENGTH_LONG).show();

            }
        });
        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //delete
                String id=e1.getText().toString();

                String sql="";
                sql="delete from student where id="+id;
                //execute query
                db.execSQL(sql);
                Toast.makeText(MainActivity.this, "Record Deleted!!!!", Toast.LENGTH_LONG).show();

            }
        });
    }
}