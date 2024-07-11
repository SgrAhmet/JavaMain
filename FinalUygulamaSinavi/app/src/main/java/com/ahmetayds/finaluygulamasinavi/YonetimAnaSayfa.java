package com.ahmetayds.finaluygulamasinavi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class YonetimAnaSayfa extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_yonetim_ana_sayfa);
    }




    public  void onayBekleyenGit(View view){
        startActivity(new Intent(this, OnayBekleyenMusteriler.class));
    }

    public  void aktifMusteriGit(View view){
        startActivity(new Intent(this, AktifMusteriler.class));
    }

    public  void urunlerGit(View view){
        startActivity(new Intent(this, UrunlerListesi.class));
    }


    //==========GERİ GİT=================
    public void geriGit(View view){
        startActivity(new Intent(this, YonetimPaneliGiris.class));
    }
    //==========GERİ GİT=================
}