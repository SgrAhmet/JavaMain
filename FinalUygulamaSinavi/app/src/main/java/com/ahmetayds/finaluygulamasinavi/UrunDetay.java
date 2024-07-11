package com.ahmetayds.finaluygulamasinavi;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.ahmetayds.finaluygulamasinavi.databinding.ActivityUrunDetayBinding;

public class UrunDetay extends AppCompatActivity {

    ActivityUrunDetayBinding binding;

    String urunAdi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_urun_detay);
        binding = ActivityUrunDetayBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        Intent gelenVeri =getIntent();
         urunAdi = gelenVeri.getStringExtra("urunAdi");
        int urunFiyati = gelenVeri.getIntExtra("urunFiyati",0);
        int stokAdedi = gelenVeri.getIntExtra("stokAdedi",0);
        int urunFotograf = gelenVeri.getIntExtra("urunFotograf",0);

        binding.textView2.setText(urunAdi);
        binding.editTextNumber3.setText(Integer.toString(urunFiyati));
        binding.editTextNumber4.setText(Integer.toString(stokAdedi));

        binding.imageView.setImageResource(urunFotograf);
//asdasdasasdads


    }






    public void urunGuncelle(View view){

        int yeniUrunFiyati = Integer.parseInt(binding.editTextNumber3.getText().toString()) ;
        int yeniStokAdedi = Integer.parseInt(binding.editTextNumber4.getText().toString()) ;


        try {

            SQLiteDatabase veriTabani = this.openOrCreateDatabase("final_db" ,MODE_PRIVATE,null);
            veriTabani.execSQL("UPDATE urunler SET fiyat = '" + yeniUrunFiyati + "' WHERE urunAdi = '" + urunAdi + "'");
            veriTabani.execSQL("UPDATE urunler SET stokAdedi = '" + yeniStokAdedi + "' WHERE urunAdi = '" + urunAdi + "'");


    toast("Ürün Başarıyla Güncellenmiştir");



        }catch (Exception e){
            toast("Bir Hata Oluştu!!!");
        }
    }

    //==========GERİ GİT VE TOAST=================
    public void geriGit(View view){
        startActivity(new Intent(this, UrunlerListesi.class));
    }
    public void toast(String mySt){
        Toast.makeText(this, mySt, Toast.LENGTH_SHORT).show();
    }
    //==========GERİ GİT VE TOAST=================
}