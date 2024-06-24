package com.ahmetayds.uygulamasinavi2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class OgrenciGirisi extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ogrenci_girisi);
    }


    public void ogrenciGirisiGeriGit(View view){
        Intent sayfayaGit = new Intent(this, MainActivity.class);
        startActivity(sayfayaGit);
    }
}