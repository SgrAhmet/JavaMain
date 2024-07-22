package com.ahmetayds.finaluygulamasinavi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.ahmetayds.finaluygulamasinavi.databinding.ActivityMusteriAnaSayfaBinding;

public class MusteriAnaSayfa extends AppCompatActivity {

    String girilenKullaniciAdi;
    String girilenSifre;
    String girilenIsim;
    String girilenSoyisim;
    String girilenCinsiyet;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_musteri_ana_sayfa);

         girilenKullaniciAdi = getIntent().getStringExtra("girilenKullaniciAdi");
         girilenSifre = getIntent().getStringExtra("girilenSifre");
         girilenIsim = getIntent().getStringExtra("girilenIsim");
         girilenSoyisim = getIntent().getStringExtra("girilenSoyisim");
         girilenCinsiyet = getIntent().getStringExtra("girilenCinsiyet");




    }




    public void profilGit(View view){

        Intent sayfayaGit = new Intent(this,MusteriProfil.class);
        sayfayaGit.putExtra("girilenKullaniciAdi",girilenKullaniciAdi);
        sayfayaGit.putExtra("girilenSifre",girilenSifre);
        sayfayaGit.putExtra("girilenIsim",girilenIsim);
        sayfayaGit.putExtra("girilenSoyisim",girilenSoyisim);
        sayfayaGit.putExtra("girilenCinsiyet",girilenCinsiyet);
        startActivity(sayfayaGit);

//        startActivity(new Intent(this,MusteriProfil.class));
    }

    public void urunlistesiGit(View view){
        startActivity(new Intent(this,UrunListeMusteri.class));
    }


    //==========GERİ GİT VE TOAST=================
    public void geriGit(View view){
        startActivity(new Intent(this, MusteriGiris.class));
    }
    public void toast(String mySt){
        Toast.makeText(this, mySt, Toast.LENGTH_SHORT).show();
    }
    //==========GERİ GİT VE TOAST=================
}