package com.ahmetayds.finaluygulamasinavi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.ahmetayds.finaluygulamasinavi.databinding.ActivityMusteriProfilBinding;

public class MusteriProfil extends AppCompatActivity {

    String girilenKullaniciAdi;
    String girilenSifre;
    String girilenIsim;
    String girilenSoyisim;
    String girilenCinsiyet;

    ActivityMusteriProfilBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_musteri_profil);

        binding = ActivityMusteriProfilBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        girilenKullaniciAdi = getIntent().getStringExtra("girilenKullaniciAdi");
        girilenSifre = getIntent().getStringExtra("girilenSifre");
        girilenIsim = getIntent().getStringExtra("girilenIsim");
        girilenSoyisim = getIntent().getStringExtra("girilenSoyisim");
        girilenCinsiyet = getIntent().getStringExtra("girilenCinsiyet");


        binding.editTextText81.setText(girilenKullaniciAdi);
        binding.editTextText82.setText(girilenSifre);
        binding.editTextText83.setText(girilenIsim);
        binding.editTextText84.setText(girilenSoyisim);
        binding.editTextText85.setText(girilenCinsiyet);



    }




    public  void musteriBilgisiGuncelle(View view){
        try {

            String yeniKullaniciAdi = binding.editTextText81.getText().toString();
            String yeniSifre = binding.editTextText81.getText().toString();
            String yeniIsim = binding.editTextText81.getText().toString();
            String yeniSoyisim = binding.editTextText81.getText().toString();
            String yeniCinsiyet = binding.editTextText81.getText().toString();


            SQLiteDatabase veriTabani = this.openOrCreateDatabase("final_db" ,MODE_PRIVATE,null);

            veriTabani.execSQL("UPDATE musteriler SET kullaniciAdi = '" + yeniKullaniciAdi + "' WHERE kullaniciAdi = '" + girilenKullaniciAdi + "'");
            veriTabani.execSQL("UPDATE musteriler SET sifre = '" + yeniSifre + "' WHERE kullaniciAdi = '" + girilenKullaniciAdi + "'");
            veriTabani.execSQL("UPDATE musteriler SET isim = '" + yeniIsim + "' WHERE kullaniciAdi = '" + girilenKullaniciAdi + "'");
            veriTabani.execSQL("UPDATE musteriler SET soyisim = '" + yeniSoyisim + "' WHERE kullaniciAdi = '" + girilenKullaniciAdi + "'");
            veriTabani.execSQL("UPDATE musteriler SET cinsiyet = '" + yeniCinsiyet + "' WHERE kullaniciAdi = '" + girilenKullaniciAdi + "'");

            toast("Bilgiler Güncellendi");

        }catch (Exception e){
            toast("Bir Hata Oluştu !!!");
        }
    }


    //==========GERİ GİT VE TOAST=================
    public void geriGit(View view){
        startActivity(new Intent(this, MusteriAnaSayfa.class));
    }
    public void toast(String mySt){
        Toast.makeText(this, mySt, Toast.LENGTH_SHORT).show();
    }
    //==========GERİ GİT VE TOAST=================
}