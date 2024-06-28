package com.ahmetayds.sqliteornek3;

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

        try {

            SQLiteDatabase veriTabani = this.openOrCreateDatabase("kullanıcılar_db" ,MODE_PRIVATE,null);
            veriTabani.execSQL("CREATE TABLE IF NOT EXISTS kullanicilar (id INTEGER PRIMARY KEY AUTOINCREMENT, kullaniciAdi VARCHAR(50),sifre VARCHAR(50), isim VARCHAR(50),soyisim VARCHAR(50),email VARCHAR(50), telefon INTEGER)");

            Cursor cursor =veriTabani.rawQuery("SELECT * FROM kullanicilar",null);


            int kullanıciAdlari = cursor.getColumnIndex("kullaniciAdi");
            int sifreler = cursor.getColumnIndex("sifre");
            int isimler = cursor.getColumnIndex("isim");
            int soyisimker = cursor.getColumnIndex("soyisim");
            int emailler = cursor.getColumnIndex("email");
            int telefonlar = cursor.getColumnIndex("telefon");


            while(cursor.moveToNext()){
                String kullanıciAdi = cursor.getString(kullanıciAdlari);
                String sifre = cursor.getString(sifreler);
                String isim = cursor.getString(isimler);
                String soyisim = cursor.getString(soyisimker);
                String email = cursor.getString(emailler);
                String telefon = cursor.getString(telefonlar);

                System.out.println("===============================");
                System.out.println("kullanici Adi : " + kullanıciAdi);
                System.out.println("sifre  : " + sifre);
                System.out.println("isim  : " + isim);
                System.out.println("soyisim  : " + soyisim);
                System.out.println("email  : " + email);
                System.out.println("telefon  : " + telefon);
                System.out.println("===============================");

            }



        }catch (Exception e){
            Toast.makeText(this, "Bir Hata Oluştu!", Toast.LENGTH_SHORT).show();
        }


    }



    public void girisEkraniGit(View view){
        startActivity(new Intent(this, girisEkrani.class));
    }

    public void kayitEkraniGit(View view){
        startActivity(new Intent(this, kayitEkrani.class));

    }


}