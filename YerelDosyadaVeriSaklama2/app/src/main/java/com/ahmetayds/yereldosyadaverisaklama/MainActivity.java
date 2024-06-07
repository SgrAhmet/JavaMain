package com.ahmetayds.yereldosyadaverisaklama;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class MainActivity extends AppCompatActivity {

    EditText editTextText;
    TextView  textView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextText = findViewById(R.id.editTextText);
        textView = findViewById(R.id.textView);

//===================================Veri Çekme===========================
        SharedPreferences veriGetir =this.getPreferences(Context.MODE_PRIVATE);
        String gelenVeri = veriGetir.getString("ad","");
        if(!gelenVeri.isEmpty()){
            textView.setText(gelenVeri);
        }

//        SharedPreferences sharedPreferences = this.getPreferences(Context.MODE_PRIVATE);
//        Set<String> veriSet = sharedPreferences.getStringSet("veri", new HashSet<>());
//        ArrayList<String> gelenVeri = new ArrayList<>(veriSet);

    }

    public void kaydetIslem(View view){

//===================================Veri Gönderme===========================

        SharedPreferences veriKaydet =this.getPreferences(Context.MODE_PRIVATE);
        SharedPreferences.Editor editor =veriKaydet.edit();
        editor.putString("ad",editTextText.getText().toString());
        editor.apply();

//===================================Veri Çekme===========================
        SharedPreferences veriGetir =this.getPreferences(Context.MODE_PRIVATE);
        String gelenVeri = veriGetir.getString("ad","");
        if(!gelenVeri.isEmpty()){
            textView.setText(gelenVeri);
        }

    }

}