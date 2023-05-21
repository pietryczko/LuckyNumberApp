package com.training.luckynumber;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class LuckyNumberActicity extends AppCompatActivity {

    TextView txt, lucky_Number_txt;
    Button share_Button;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lucky_number_acticity);

        txt = findViewById(R.id.textView);
        lucky_Number_txt = findViewById(R.id.luckyNum);
        share_Button = findViewById(R.id.share_button);

        Intent i = getIntent();
        String userName = i.getStringExtra("name");

        int randomNumber = generateRandomNumber();
        lucky_Number_txt.setText(""+randomNumber);

        share_Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                shareData(userName, randomNumber);
            }
        });
    }


    public int generateRandomNumber() {
        Random random = new Random();
        return random.nextInt(20);
    }

    public void shareData(String userName, int luckyNumber) {
        Intent i = new Intent(Intent.ACTION_SEND);
        i.setType("text/plain");
        i.putExtra(Intent.EXTRA_SUBJECT, userName + "got lucky today!");
        i.putExtra(Intent.EXTRA_TEXT,"His lucky number is " + String.valueOf(luckyNumber));

        startActivity(Intent.createChooser(i, "Choose a platform"));
    }
}