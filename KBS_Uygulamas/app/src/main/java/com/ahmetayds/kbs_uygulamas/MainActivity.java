package com.ahmetayds.kbs_uygulamas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
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
            SQLiteDatabase veriTabanı = this.openOrCreateDatabase("ogrenciler",MODE_PRIVATE,null);
            veriTabanı.execSQL("CREATE TABLE IF NOT EXISTS ogreciler (id INTEGER PRIMARY KEY AUTOINCREMENT , isim VARCHAR(50),soyisim VARCHAR(50),yas INTEGER,sinif VARCHAR(50))");


        }catch (Exception e){
            Toast.makeText(this, "Bir Hata Oluştu!!", Toast.LENGTH_SHORT).show();
        }




    }


    public void listeleGit (View view){
        startActivity(new Intent(this, listele.class));
    }

    public void ekleGit (View view){
        startActivity(new Intent(this, ekle.class));
    }

    public void silGit (View view){
        startActivity(new Intent(this, sil.class));
    }
}