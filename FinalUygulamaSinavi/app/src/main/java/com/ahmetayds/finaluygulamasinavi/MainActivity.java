package com.ahmetayds.finaluygulamasinavi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


//        try {
//
//            SQLiteDatabase veriTabani = this.openOrCreateDatabase("final_db" ,MODE_PRIVATE,null);
//            veriTabani.execSQL("CREATE TABLE IF NOT EXISTS yoneticiler (id INTEGER PRIMARY KEY AUTOINCREMENT, kullaniciAdi VARCHAR(50),sifre VARCHAR(50))");
////            veriTabani.execSQL("CREATE TABLE IF NOT EXISTS musteriler (id INTEGER PRIMARY KEY AUTOINCREMENT, kullaniciAdi VARCHAR(50),sifre VARCHAR(50), isim VARCHAR(50),soyisim VARCHAR(50),email VARCHAR(50), telefon INTEGER)");
////            veriTabani.execSQL("CREATE TABLE IF NOT EXISTS urunler (id INTEGER PRIMARY KEY AUTOINCREMENT, kullaniciAdi VARCHAR(50),sifre VARCHAR(50), isim VARCHAR(50),soyisim VARCHAR(50),email VARCHAR(50), telefon INTEGER)");
//
//            Cursor cursor =veriTabani.rawQuery("SELECT * FROM yoneticiler",null);
//
//            int kullanıciAdlari = cursor.getColumnIndex("kullaniciAdi");
//            int sifreler = cursor.getColumnIndex("sifre");
//
//
//            Boolean isWorked = false;
//            while (cursor.moveToNext()){
//                String sifre = cursor.getString(sifreler);
//
//                if(!sifre.equals("123456")){
//                    isWorked = true;
//                }
//
//
//            }
//
//
//            if(!isWorked){
//                yoneticiKaydet();
//            }
//
//        }catch (Exception e){
//            Toast.makeText(this, "Bir Hata Oluştu!!!", Toast.LENGTH_SHORT).show();
//        }





    }





    public void yoneticiKaydet(){
        Toast.makeText(this, "Çalıştı", Toast.LENGTH_SHORT).show();

        try {
            String admin1 = "admin1";
            String admin2 = "admin2";
            String admin1sifre = "123456";
            String admin2sifre = "123456";


            SQLiteDatabase veriTabani = this.openOrCreateDatabase("final_db" ,MODE_PRIVATE,null);


            veriTabani.execSQL("INSERT INTO yoneticiler (kullaniciAdi,sifre) VALUES ( '" + admin1 +"','" + admin1sifre + "')" );
            veriTabani.execSQL("INSERT INTO yoneticiler (kullaniciAdi,sifre) VALUES ( '" + admin2 +"','" + admin2sifre + "')" );








        }catch (Exception e){
            Toast.makeText(this, "Bir Hata Oluştu!!! asdasdasdasdasd", Toast.LENGTH_SHORT).show();
        }
    }


    public void yonetimGirisGit(View view){
        startActivity(new Intent(this, YonetimPaneliGiris.class));
    }
    public void musteriGirisGit(View view){
        startActivity(new Intent(this, MusteriGiris.class));
    }
}