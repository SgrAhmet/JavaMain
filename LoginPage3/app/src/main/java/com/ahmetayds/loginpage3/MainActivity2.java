package com.ahmetayds.loginpage3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {

    TextView textView2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        textView2 = findViewById(R.id.textView2);

        String isimVerisi = getIntent().getStringExtra("isim");
        String soyisimVerisi = getIntent().getStringExtra("soyisim");

        textView2.setText(isimVerisi + " "+ soyisimVerisi);



    }
}