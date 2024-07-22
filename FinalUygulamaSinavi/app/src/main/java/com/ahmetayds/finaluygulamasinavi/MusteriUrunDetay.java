package com.ahmetayds.finaluygulamasinavi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import com.ahmetayds.finaluygulamasinavi.databinding.ActivityMusteriUrunDetayBinding;

import java.util.ArrayList;

public class MusteriUrunDetay extends AppCompatActivity {

    String urunAdi;
    int stokAdedi;

    ActivityMusteriUrunDetayBinding binding;

    ArrayList<Integer> sayilar = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_musteri_urun_detay);

        binding = ActivityMusteriUrunDetayBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);



        Intent gelenVeri =getIntent();
        urunAdi = gelenVeri.getStringExtra("urunAdi");
        int urunFiyati = gelenVeri.getIntExtra("urunFiyati",0);
        stokAdedi = gelenVeri.getIntExtra("stokAdedi",0);
        int urunFotograf = gelenVeri.getIntExtra("urunFotograf",0);



        sayilar.add(1);
        sayilar.add(2);
        sayilar.add(3);
        sayilar.add(4);
        sayilar.add(5);




        binding.textView2.setText(urunAdi);
        binding.textView11.setText(Integer.toString(urunFiyati));
        binding.textView12.setText(Integer.toString(stokAdedi));

        binding.imageView.setImageResource(urunFotograf);


        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1,sayilar);
        binding.spinner.setAdapter(adapter);




    }




    public void satinAl(View view){

        try {

            int yeniStok =  stokAdedi - Integer.parseInt(binding.spinner.getSelectedItem().toString()) ;
            stokAdedi = yeniStok;

            SQLiteDatabase veriTabani = this.openOrCreateDatabase("final_db" ,MODE_PRIVATE,null);

            veriTabani.execSQL("UPDATE urunler SET stokAdedi = " + yeniStok + " WHERE urunAdi = '" + urunAdi + "'");
            
            toast("Ürün Başarıyla Satın ALındı");

            binding.textView12.setText(Integer.toString(stokAdedi));



        }catch (Exception e){
            toast("Bir Hata Oluştu!!!");
        }

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