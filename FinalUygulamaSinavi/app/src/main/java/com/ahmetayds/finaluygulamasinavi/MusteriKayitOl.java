package com.ahmetayds.finaluygulamasinavi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.ahmetayds.finaluygulamasinavi.databinding.ActivityMusteriKayitOlBinding;

public class MusteriKayitOl extends AppCompatActivity {
    ActivityMusteriKayitOlBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_musteri_kayit_ol);

        binding = ActivityMusteriKayitOlBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);
    }


    public void kayitOl(View view){


        try {

            String kullaniciAdiEdit = binding.editTextText3.getText().toString();
            String sifreEdit = binding.editTextTextPassword3.getText().toString();
            String isimEdit = binding.editTextText4.getText().toString();
            String soyisimEdit = binding.editTextText5.getText().toString();
            String cinsiyetEdit = binding.editTextText6.getText().toString();





            SQLiteDatabase veriTabani = this.openOrCreateDatabase("final_db" ,MODE_PRIVATE,null);
            veriTabani.execSQL("CREATE TABLE IF NOT EXISTS musteriler (id INTEGER PRIMARY KEY AUTOINCREMENT, kullaniciAdi VARCHAR(50),sifre VARCHAR(50),isim VARCHAR(50),soyisim VARCHAR(50) , cinsiyet VARCHAR(50) , onay INTEGER)");


            if(kullaniciAdiEdit.isEmpty() || sifreEdit.isEmpty() ||isimEdit.isEmpty() || soyisimEdit.isEmpty() || cinsiyetEdit.isEmpty()){
                toast("Hiçbir Alan Boş Bırakılmaz!");
            }else{

                veriTabani.execSQL("INSERT INTO musteriler (kullaniciAdi, sifre, isim, soyisim, cinsiyet, onay) VALUES ('" + kullaniciAdiEdit + "','" + sifreEdit + "','" + isimEdit + "','" + soyisimEdit + "','" + cinsiyetEdit + "'," + 0+ ")");

                startActivity(new Intent(this, MusteriGiris.class));
                toast("Kullancı Başarıyla Oluşturuldu");

            }

        }catch (Exception e){
            toast("Bir Hata Oluştu!!asdasdasdas!");
        }

    }

    //==========GERİ GİT VE TOAST=================
    public void geriGit(View view){
        startActivity(new Intent(this, MainActivity.class));
    }
    public void toast(String mySt){
        Toast.makeText(this, mySt, Toast.LENGTH_SHORT).show();
    }
    //==========GERİ GİT VE TOAST=================
}