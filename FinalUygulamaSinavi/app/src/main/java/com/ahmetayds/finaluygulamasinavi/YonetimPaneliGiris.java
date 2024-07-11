package com.ahmetayds.finaluygulamasinavi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class YonetimPaneliGiris extends AppCompatActivity {

    EditText kullaniciAdiEditText;
    EditText sifreEditText;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_yonetim_paneli_giris);

        kullaniciAdiEditText = findViewById(R.id.editTextText);
        sifreEditText = findViewById(R.id.editTextTextPassword);






    }









    public void yoneticiGirisYap(View view){
        String girilenKullaniciAdi = kullaniciAdiEditText.getText().toString();
        String girilenSifre = sifreEditText.getText().toString();

        System.out.println(girilenKullaniciAdi);
        System.out.println(girilenSifre);


        if(girilenKullaniciAdi.isEmpty() || girilenSifre.isEmpty()){
            Toast.makeText(this, "Hiçbir Alan Boş Bırakılınamaz", Toast.LENGTH_SHORT).show();
        }else{

            try {
            SQLiteDatabase veriTabani = this.openOrCreateDatabase("final_db" ,MODE_PRIVATE,null);

            Cursor cursor =veriTabani.rawQuery("SELECT * FROM yoneticiler",null);

            int kullanıciAdlari = cursor.getColumnIndex("kullaniciAdi");
            int sifreler = cursor.getColumnIndex("sifre");


            Boolean isLogin = false;

            while (cursor.moveToNext()){

                String kullaniciAdi = cursor.getString(kullanıciAdlari);
                String sifre = cursor.getString(sifreler);

                if(girilenKullaniciAdi.equals(kullaniciAdi) && girilenSifre.equals(sifre)){
                    isLogin = true;
                }


            }


            if(isLogin){
                startActivity(new Intent(this, YonetimAnaSayfa.class));
            }else{
                Toast.makeText(this, "Kullanıcı Bulunamadı", Toast.LENGTH_SHORT).show();
            }

        }catch (Exception e){
            Toast.makeText(this, "Bir Hata Oluştu!!! ", Toast.LENGTH_SHORT).show();
        }

        }

    }

//==========GERİ GİT=================
    public void geriGit(View view){
        startActivity(new Intent(this, MainActivity.class));
    }
//==========GERİ GİT=================

}