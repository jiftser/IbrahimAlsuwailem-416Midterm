package com.example.ibrahimalsuwailem_416midterm;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity2 extends AppCompatActivity {

    DatabaseHelper MyDB1;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        textView = (TextView)findViewById(R.id.textView11);
        Button bttn1 = (Button)findViewById(R.id.button2);
        Button bttn2 = (Button)findViewById(R.id.button5);

        final Button read = (Button)findViewById(R.id.button6);
        read.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Cursor cur = MyDB1.find(1);
                String id = cur.getString(0);
                String name = cur.getString(1);
                String surname = cur.getString(2);
                String phone = cur.getString(3);
                String iqama = cur.getString(4);

                textView.setText(id + ", " + name + ", " + surname + ", " + phone + ", " + iqama);
            }
        });

        final Button delete = (Button)findViewById(R.id.button7);
        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyDB1.deleteID("1");
                Toast.makeText(MainActivity2.this,"Successful Delete",Toast.LENGTH_SHORT).show();
            }
        });

        bttn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity2.this, MainActivity.class));
            }
        });
        bttn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity2.this, MainActivity3.class));
            }
        });
    }
}