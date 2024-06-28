package com.ahmetayds.kbs_uygulamas;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;

public class ekle extends AppCompatActivity {

    EditText isimText;
    EditText soyisimText;
    EditText yasText;
    EditText sinifText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ekle);
    }


}