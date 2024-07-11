package com.ahmetayds.finaluygulamasinavi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.ahmetayds.finaluygulamasinavi.databinding.ActivityMusteriUrunDetayBinding;

public class MusteriUrunDetay extends AppCompatActivity {

    String urunAdi;

    ActivityMusteriUrunDetayBinding binding;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_musteri_urun_detay);

//        binding = ActivityMusteriUrunDetayBinding.inflate(getLayoutInflater());
//        View view = binding.getRoot();
//        setContentView(view);
//
//
//
//        Intent gelenVeri =getIntent();
//        urunAdi = gelenVeri.getStringExtra("urunAdi");
//        int urunFiyati = gelenVeri.getIntExtra("urunFiyati",0);
//        int stokAdedi = gelenVeri.getIntExtra("stokAdedi",0);
//        int urunFotograf = gelenVeri.getIntExtra("urunFotograf",0);
//
//
//        binding.textView2.setText(urunAdi);
//        binding.editTextNumber3.setText(Integer.toString(urunFiyati));
//        binding.editTextNumber4.setText(Integer.toString(stokAdedi));
//
//        binding.imageView.setImageResource(urunFotograf);
    }



    //==========GERİ GİT VE TOAST=================
    public void geriGit(View view){
        startActivity(new Intent(this, UrunListeMusteri.class));
    }
    public void toast(String mySt){
        Toast.makeText(this, mySt, Toast.LENGTH_SHORT).show();
    }
    //==========GERİ GİT VE TOAST=================
}