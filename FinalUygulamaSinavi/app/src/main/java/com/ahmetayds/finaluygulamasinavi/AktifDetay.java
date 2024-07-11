package com.ahmetayds.finaluygulamasinavi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.ahmetayds.finaluygulamasinavi.databinding.ActivityAktifDetayBinding;
import com.ahmetayds.finaluygulamasinavi.databinding.ActivityOnayBekleyenDetayBinding;

public class AktifDetay extends AppCompatActivity {

    ActivityAktifDetayBinding binding;
    String kullaniciAdi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_aktif_detay);
        binding = ActivityAktifDetayBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);



        Intent gelenVeri =getIntent();
         kullaniciAdi = gelenVeri.getStringExtra("kullaniciAdi");
        String isim = gelenVeri.getStringExtra("isim");
        String soyisim = gelenVeri.getStringExtra("soyisim");
        String cinsiyet = gelenVeri.getStringExtra("cinsiyet");


        binding.textView7.setText(kullaniciAdi);
        binding.textView8.setText(isim);
        binding.textView9.setText(soyisim);
        binding.textView10.setText(cinsiyet);
    }





    public void onayKaldir(View view){
        try {

            SQLiteDatabase veriTabani = this.openOrCreateDatabase("final_db" ,MODE_PRIVATE,null);


            veriTabani.execSQL("UPDATE musteriler SET onay = '" + 0 + "' WHERE kullaniciAdi = '" + kullaniciAdi + "'");

            startActivity(new Intent(this, AktifMusteriler.class));

            toast("Kullanıcıdan Onay Kaldırılmıştır");

        }catch (Exception e){
            toast("Bir Hata Oluştu!!!");
        }
    }

    //==========GERİ GİT VE TOAST=================
    public void geriGit(View view){
        startActivity(new Intent(this, AktifMusteriler.class));
    }
    public void toast(String mySt){
        Toast.makeText(this, mySt, Toast.LENGTH_SHORT).show();
    }
    //==========GERİ GİT VE TOAST=================
}