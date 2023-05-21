package com.training.luckynumber;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText name_txt;
    Button findNum;
    TextView txt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txt = findViewById(R.id.text1);
        name_txt = findViewById(R.id.name);
        findNum = findViewById(R.id.button1);

        findNum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = name_txt.getText().toString();
                //Explicit Intent
                Intent i = new Intent(getApplicationContext(), LuckyNumberActicity.class);

                //Passing the name to secound activity
                i.putExtra("name", name);
                startActivity(i);
            }
        });
    }
}