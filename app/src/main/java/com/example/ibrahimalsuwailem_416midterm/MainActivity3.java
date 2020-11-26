package com.example.ibrahimalsuwailem_416midterm;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity3 extends AppCompatActivity {

    DatabaseHelper MyDB2;
    EditText iqama;
    EditText name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        iqama = (EditText)findViewById(R.id.editText1);
        name = (EditText)findViewById(R.id.editText2);
        Button bttn1 = (Button)findViewById(R.id.button8);
        Button bttn2 = (Button)findViewById(R.id.button9);

        final Button delete = (Button)findViewById(R.id.button10);
        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyDB2.deleteIqama(iqama.getText().toString());
                Toast.makeText(MainActivity3.this,"Successful Delete",Toast.LENGTH_SHORT).show();
            }
        });

        final Button read = (Button)findViewById(R.id.button11);
        read.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Cursor cur = MyDB2.findName(name.getText().toString());
                String id = cur.getString(0);
                String name = cur.getString(1);
                String surname = cur.getString(2);
                String phone = cur.getString(3);
                String iqama = cur.getString(4);

                Toast.makeText(MainActivity3.this, id + ", " + name + ", " + surname + ", " + phone + ", " + iqama, Toast.LENGTH_LONG).show();
            }
        });

        bttn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity3.this, MainActivity.class));
            }
        });
        bttn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity3.this, MainActivity2.class));
            }
        });
    }
}